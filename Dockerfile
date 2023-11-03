FROM openjdk:8-jdk-alpine
EXPOSE 8089

ADD http://172.16.1.160:8081/repository/maven-snapshots/tn/esprit/spring/kaddem/0.0.1-SNAPSHOT/kaddem-0.0.1-20231029.221913-43.jar /kaddem-0.0.1-20231029.221913-43.jar
ENTRYPOINT ["java", "-jar", "/kaddem-0.0.1-20231029.221913-43.jar"]


