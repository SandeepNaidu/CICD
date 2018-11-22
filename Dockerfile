FROM openjdk:8

RUN mkdir /cicd
COPY . /cicd
WORKDIR /cicd
CMD target/universal/stage/bin/cicd
EXPOSE 8080
