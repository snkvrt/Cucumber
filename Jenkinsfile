pipeline{
    agent any
    stages{
        stage('authentication'){
                    steps {
                        bat 'echo  dakjd'
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
