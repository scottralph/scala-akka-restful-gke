FROM openjdk:11
ARG SBT_VERSION="1.2.0"

RUN \
  curl -L -o sbt-$SBT_VERSION.deb http://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt && \
  sbt sbtVersion

  COPY rest rest
  WORKDIR /rest

EXPOSE 8081

CMD ["sbt", "runMain SimpleServer"]
