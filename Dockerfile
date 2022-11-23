FROM openjdk:12
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Datos.jar
ENTRYPOINT ["java","-jar","/Datos.jar"]
ENV JAVA_OPTS="-XX:PermSize=8192m -XX:MaxPermSize=4096m"