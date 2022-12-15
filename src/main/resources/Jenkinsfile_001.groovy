pipeline {
    agent any

    environment {
        workdir = "/root/.jenkins/workspace/Pipeline_001/target"
        project = "Pipeline_001"
        COMMIT_EMAIL = sh(script:'git show -s --format=%ae', returnStdout:true).trim()
    }

    stages {

        stage('检出最新代码') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], browser: [$class: 'GithubWeb', repoUrl: 'https://github.com/cuigw001/springboot001'], extensions: [], userRemoteConfigs: [[credentialsId: '82343b80-e151-4438-8f70-62b551189331', url: 'https://github.com/cuigw001/springboot001.git']]])
            }
        }

        stage('打包代码') {
            steps {
                echo "开始打包代码"
                script{
                    def codeCommitMessage = sh( script:'git show', returnStdout:true)
                    echo "代码作者【${COMMIT_EMAIL}】"

                    try{
                        def packageResult = sh( script:'mvn -U -am clean package -Dmaven.test.skip=true | grep -c "BUILD SUCCESS"', returnStdout:true)
                        echo "${project}打包成功:${packageResult}"
                    }catch(e){
                        echo "${project}打包失败"
                        throw e
                    }
                }
            }
        }


        stage('停止服务') {
            steps {
                echo "开始停止服务"
                script{
                    sh "if (ps -ef| grep java|grep 8001)then (ps -ef| grep java|grep 8001| awk '{print \$2}'|xargs kill -9) fi"
                    echo "停止服务完成"
                }
            }
        }

        stage('发布服务') {
            steps {
                script{
                    sh "export BUILD_ID='dontKillMe'"
                    sh "JENKINS_NODE_COOKIE=dontKillMe nohup java -jar /root/.jenkins/workspace/Pipeline_001/target/springboot001-0.0.1-SNAPSHOT.jar --server.port=8001 &"
                    echo "发布服务完成"
                }
            }
        }
    }
}
