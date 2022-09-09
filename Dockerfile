FROM sunbird/openjdk-java11-alpine:latest
WORKDIR /home
RUN apk update \
    && apk add unzip \
    && mkdir -p /home \
    && mkdir -p /data
COPY ./conf/contents.json   /data/
COPY ./target/content-api-1.0-SNAPSHOT-dist.zip /home/
RUN unzip /home/content-api-1.0-SNAPSHOT-dist.zip -d /home
RUN rm /home/content-api-1.0-SNAPSHOT-dist.zip
CMD java -cp '/home/content-api-1.0-SNAPSHOT/lib/*' -Dplay.http.secret.key='QCY?tAnfk?aZ?iwrNwnxIlR6CTf:G3gf:90Latabg@5241AB`R5W:1uDFN];Ik@n' play.core.server.ProdServerStart  /home/content-api-1.0-SNAPSHOT