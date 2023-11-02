FROM openjdk:8-jdk-alpine
EXPOSE 8089

ADD http://192.168.33.10:8081/repository/maven-snapshots/tn/esprit/spring/kaddem/0.0.1-SNAPSHOT/kaddem-0.0.1-20231102.150926-5.jar /kaddem-0.0.1-20231102.150926-5.jar
ENTRYPOINT ["java", "-jar", "/kaddem-0.0.1-20231102.150926-5.jar"]