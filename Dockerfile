FROM openjdk:12
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Datos.jar
ENTRYPOINT ["java","-jar","/Datos.jar"]
ENV JAVA_OPTS="-XX:PermSize=1024m -XX:MaxPermSize=512m"