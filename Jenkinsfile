pipeline {
    agent any

  environment {
        CLIENT_ID    = credentials('idClient')
        SECRET_CLIENT    = credentials('SecretClient')

    }
    stages {
         stage('Build'){
            steps{
                bat 'mvn clean'
            }
        }
      stage('Curl') {
  steps {
    script{
    def token = bat(script: 'curl -H "Content-Type: application/json" -X POST --data "{ \"client_id\": \"%CLIENT_ID%\",\"client_secret\": \"%SECRET_CLIENT%\" }"  https://xray.cloud.getxray.app/api/v2/authenticate',returnStdout: true)
    echo token

    }

  }
}
        stage('Test'){
            steps{
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    cucumber fileIncludePattern: 'target/cucumber.json'
                }
            }
        }
    }
}