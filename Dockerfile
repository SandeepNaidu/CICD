FROM openjdk:8

RUN mkdir /cicd
COPY target/universal/* /cicd
WORKDIR /cicd
CMD bin/cicd
EXPOSE 8080
