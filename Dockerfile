FROM openjdk:8
#ENV SBT_VERSION 1.2.6
#RUN \
#  apt-get update && \
#  apt-get -y install curl
#RUN \
#  curl -L -o sbt-$SBT_VERSION.deb http://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
#  dpkg -i sbt-$SBT_VERSION.deb && \
#  rm sbt-$SBT_VERSION.deb && \
#  apt-get update && \
#  apt-get install sbt

WORKDIR /CICD
ADD . /CICD
CMD target/universal/scripts/bin/cicd
