FROM tomcat:8-jre8
ARG WAR_FILE=target/scheduleRelease-2.6.1.war
ADD ${WAR_FILE} /usr/local/tomcat/webapps/scheduleRelease.war
EXPOSE 8080