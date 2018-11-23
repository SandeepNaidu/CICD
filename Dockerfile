FROM openjdk:8

RUN mkdir /cicd
COPY universal/stage /cicd
WORKDIR /cicd
CMD bin/cicd
EXPOSE 8080
