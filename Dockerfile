FROM openjdk:11-jdk-slim AS BUILD_IMAGE
ENV APP_HOME=/root/dev/igaming/
RUN mkdir -p $APP_HOME/src/main/java
WORKDIR $APP_HOME
COPY build.gradle gradlew gradlew.bat $APP_HOME
COPY gradle $APP_HOME/gradle


RUN ./gradlew build -x :bootRepackage -x test --continue
COPY . .
RUN ./gradlew build

FROM openjdk:11-jdk-slim
WORKDIR /root/
COPY --from=BUILD_IMAGE /root/dev/igaming/build/libs/igaming.jar .

EXPOSE 8080
ENTRYPOINT ["java","-jar","igaming.jar"]