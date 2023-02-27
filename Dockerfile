#FROM tomcat:8
#RUN mv webapps webapps2 \
# && mv webapps.dist webapps
#ADD /target/vic.war /usr/local/tomcat/webapps/
#EXPOSE 8080
#CMD ["catalina.sh", "run"]

FROM budweiserapac-registry.cn-shanghai.cr.aliyuncs.com/apac-bcc/vic-price-automation-api/openjdk:8-jdk-oraclelinux8

#RUN apt-get update \
# && apt-get install openssl=1.1.1f-1ubuntu2.17 \
# && apt-get install libssl-dev=1.1.1f-1ubuntu2.17 -y

ADD /opt/docker-workspace/springboot001.jar /opt/springboot001.jar

EXPOSE 8080

#CMD java -jar -Xms1024m -Xmx2048m /vic/vic.jar
ENTRYPOINT ["/bin/bash","-c","java -jar -Xms1024m -Xmx1024m /opt/springboot001.jar"]
