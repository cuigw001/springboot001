
FROM budweiserapac-registry.cn-shanghai.cr.aliyuncs.com/apac-bcc/vic-price-automation-api/openjdk:8-jdk-oraclelinux8

ADD /opt/docker-workspace/springboot001.jar /opt/springboot001.jar

EXPOSE 8880

ENTRYPOINT ["/bin/bash","-c","java -jar -Xms1024m -Xmx1024m /opt/springboot001.jar"]
