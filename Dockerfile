
# 基础镜像
FROM budweiserapac-registry.cn-shanghai.cr.aliyuncs.com/apac-bcc/vic-price-automation-api/openjdk:8-jdk-oraclelinux8
# 指定作者信息
MAINTAINER by cuigw
#设置工作空间
#WORKDIR /opt
# 复制本地打包好的jar到 docker容器的/opt目录
ADD springboot001.jar .
# 对外暴露端口
EXPOSE 8400
# 运行容器时候，启动jar包
ENTRYPOINT ["/bin/bash","-c","java -jar -Xms1024m -Xmx1024m /opt/springboot001.jar"]
