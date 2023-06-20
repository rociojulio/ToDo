FROM amazoncorretto:17-alpine-jdk
MAINTAINER ROCIO
COPY out/artifacts/project_jar/project.jar todo-app.jar
ENTRYPOINT ["java","-jar","/todo-app.jar"]