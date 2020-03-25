FROM mongo:4.0.11

RUN mkdir -p /data/mongo/data /data/mongo/config /data/mongo/logs \
    && chown -R mongodb:mongodb /data/mongo

ADD ./mongod.conf.yml /data/mongo/config/mongod.conf

CMD mongod --config /data/mongo/config/mongod.conf