pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                // git 'https://github.com/jglick/simple-maven-project-with-tests.git'

                checkout([$class: 'GitSCM', branches: [[name: '*/main']], browser: [$class: 'GithubWeb', repoUrl: 'https://github.com/cuigw001/springboot001'], extensions: [], userRemoteConfigs: [[credentialsId: '82343b80-e151-4438-8f70-62b551189331', url: 'https://github.com/cuigw001/springboot001.git']]])

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"


                sh "if (ps -ef| grep java|grep 8001)then (ps -ef| grep java|grep 8001| awk '{print \$2}'|xargs kill -9) fi"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"


                sh "export BUILD_ID='dontKillMe'"
                sh "JENKINS_NODE_COOKIE=dontKillMe nohup java -jar /root/.jenkins/workspace/Pipeline_001/target/springboot001-0.0.1-SNAPSHOT.jar --server.port=8001 &"

            }

        }
    }
}
