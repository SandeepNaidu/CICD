FROM openjdk:8

RUN mkdir /cicd
COPY . /cicd
WORKDIR /cicd
CMD project/target/universal/scripts/bin/cicd
