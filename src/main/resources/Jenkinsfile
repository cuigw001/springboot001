#!/usr/bin/env groovy
pipeline {
   agent {label 'slave1'}
   environment {
       workdir = "$WORKSPACE"
       project = "$JOB_NAME"
       COMMIT_EMAIL = sh(script:'git show -s --format=%ae', returnStdout:true).trim()
   }
   stages {
      stage('检出最新代码') {
          steps {
              script{
                  echo "检出标签代码"
                  sh 'git checkout'
              }
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
                      echo "service打包失败"
                      throw e
                  }
              }
          }
      }
       /*
      stage('发布部署') {
          steps{
			dir('/etc/ansible/playbooks/dev/deploy/auth'){
				ansiblePlaybook(
					credentialsId: 'ansible-syj',
					inventory: 'hosts.auth',
					playbook: 'auth_dubbo.yml',
					extraVars:[
						build_id: [value: "${BUILD_ID}", hidden: false]
					]
				)
			}
          }
       }
        */
   }
}
