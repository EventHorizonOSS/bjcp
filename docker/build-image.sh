#!/usr/bin/env bash

DOCKER_IMAGE_NAME="bjcp"
DOCKER_CONTAINER_NAME="bjcp"

echo
echo "============================================================================================="
echo "Removing old Docker containers ..."
echo "============================================================================================="
echo
DOCKER_CONTAINER_IDS=`docker container ls -f name=${DOCKER_CONTAINER_NAME} -a -q`
for DOCKER_CONTAINER_ID in ${DOCKER_CONTAINER_IDS}; do
    echo "Stopping container ${DOCKER_CONTAINER_ID}"
    docker container stop ${DOCKER_CONTAINER_ID}
    echo "Removing container ${DOCKER_CONTAINER_ID}"
    docker container rm ${DOCKER_CONTAINER_ID}
done
sleep 1

echo
echo "============================================================================================="
echo "Removing old Docker images ..."
echo "============================================================================================="
echo
DOCKER_OLD_IMAGES=`docker image ls -q ${DOCKER_IMAGE_NAME}`
for DOCKER_IMAGE_ID in ${DOCKER_OLD_IMAGES}; do
    echo "Removing image ${DOCKER_IMAGE_ID}"
    docker image rm ${DOCKER_IMAGE_ID}
done
DOCKER_OLD_IMAGES=`docker image ls -f "dangling=true" -q`
for DOCKER_IMAGE_ID in ${DOCKER_OLD_IMAGES}; do
    echo "Removing image ${DOCKER_IMAGE_ID}"
    docker image rm ${DOCKER_IMAGE_ID}
done
sleep 1

echo
echo "============================================================================================="
echo "Building the new Docker image ..."
echo "============================================================================================="
echo
docker build -t ${DOCKER_IMAGE_NAME} .
sleep 1

exit 0