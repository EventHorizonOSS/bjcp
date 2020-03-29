pipeline {
    agent any
    tools {
        maven 'mvn3.6.3'
    }
    stages {
        stage('Initialize') {
            steps {
                echo 'Initializing ...'
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
                git branch: 'dev', credentialsId: 'd2b44dbf-2319-4c71-aa76-02f4e61d6b1f', url: 'https://github.com/EventHorizonOSS/bjcp.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building ...'
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing ...'
                sh 'mvn clean verify -P UnitTests || true'
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
