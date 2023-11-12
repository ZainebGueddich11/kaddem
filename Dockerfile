FROM openjdk:8-jdk-alpine
EXPOSE 8089
#192.168.100.110http://
ADD http://192.168.100.110:8081/repository/maven-snapshots/tn/esprit/spring/kaddem/0.0.1-SNAPSHOT/kaddem-0.0.1-20231112.171854-12.jar /kaddem-0.0.1-20231112.171854-12.jar
ENTRYPOINT ["java","-jar","/kaddem-0.0.1-20231112.171854-12.jar"]