FROM openjdk:12
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Datos.jar
ENTRYPOINT ["java","-jar","/Datos.jar"]