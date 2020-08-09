FROM openjdk:14-alpine
COPY build/libs/friends-api-*-all.jar friends-api.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "friends-api.jar"]