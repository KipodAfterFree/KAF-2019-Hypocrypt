FROM openjdk:11-slim-buster
EXPOSE 8000
WORKDIR /home
COPY build/libs/2019-Hypocrypt-1.0.jar /home/app.jar
CMD exec java -jar /home/app.jar