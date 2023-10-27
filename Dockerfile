FROM openjdk:8-jdk-alpine
EXPOSE 8089

ADD http://192.168.1.25:8081/repository/maven-snapshots/tn/esprit/spring/kaddem/0.0.1-SNAPSHOT/kaddem-0.0.1-20231027.135311-23.jar /kaddem1:0.0.1.jar
RUN jar -xf ./kaddem1:0.0.1.jar

FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","tn/esprit/spring/kaddem/KaddemApplication.java"]


