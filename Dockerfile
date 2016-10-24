FROM maven:3.3.9-jdk-8
COPY . /usr/src/app
WORKDIR /usr/src/app
EXPOSE 8080
CMD mvn clean tomcat:run -Dmaven.tomcat.port=8080

