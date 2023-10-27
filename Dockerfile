FROM openjdk:8-jdk-alpine
EXPOSE 8089

ADD http://192.168.1.25:8081/repository/maven-snapshots/tn/esprit/spring/kaddem/0.0.1-SNAPSHOT/kaddem-0.0.1-SNAPSHOT.jar /kaddem:0.0.1.jar
ENTRYPOINT ["java", "-jar", "/kaddem:0.0.1.jar"]

