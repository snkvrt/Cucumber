pipeline{
    agent any
    stages{
        stage('authentication'){
                    steps {
                        bat 'curl -H "Content-Type: application/json" -X POST --data { "client_id": %idClient%,"client_secret": %SecretClient% }  https://xray.cloud.getxray.app/api/v2/authenticate'
                    }
        }
        stage('build'){
            steps{
                bat 'mvn clean'
            }
        }
        stage('test'){
            steps{
                bat 'mvn test  -Dcucumber.filter.tags="@KO"'
            }

        }
       
    }
    post{
        always{
             junit 'target/surefire-reports/*.xml'
             cucumber fileIncludePattern :'target/cucumber.json'
        }
    }
}
