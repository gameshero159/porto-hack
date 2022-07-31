FROM openjdk:11.0.16-jdk

COPY target/portotech-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080:8080/tcp

VOLUME /var/portotech

ENTRYPOINT ["java", "-jar", "/app.jar"]