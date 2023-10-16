FROM openjdk:17-jdk-slim
RUN apt-get update && apt-get install -y openjdk-17-jdk
RUN apt-get install dos2unix
WORKDIR /app
COPY . .

RUN dos2unix ./gradlew
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

EXPOSE 8080
CMD ["java", "-jar", "build/libs/dssd-api-0.0.1-SNAPSHOT.jar"]