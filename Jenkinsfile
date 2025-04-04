pipeline{
    agent any
    stages{
        stage('authentication'){
                    steps {
                        script{
                        def token = bat (script : 'curl -H "Content-Type: application/json" -X POST --data "{\\"client_id\\":\\"DA94515D482B438FA35A924E4B840298\\",\\"client_secret\\":\\"8da250e9eb7def34f65be632e6fc7e13a229059bcc8a9dbb1ae1e9c3deb33fdf\\"}" https://xray.cloud.getxray.app/api/v2/authenticate'
                            , returnStdout: true)
                        }
                        echo token
                        echo ''
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
