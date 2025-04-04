pipeline {
    agent any

    environment {
        XRAY_AUTH_URL = 'https://xray.cloud.getxray.app/api/v2/authenticate'
        XRAY_EXPORT_URL = 'https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=POEI20252-526'
        CLIENT_ID = '2FEC2E12DE334E9DB616218132A9A437'
        CLIENT_SECRET = '81ede3caa8d53247ae0e12e0698a089d65f77b4adcaaf6829347433a71e85f98'
        XRAY_TOKEN = ""
    }

    stages {
        stage('Authenticate with Xray') {
            steps {
                script {
                    def response = bat(script: """
                        curl -H "Content-Type: application/json" -X POST ^
                        ${env.XRAY_AUTH_URL} ^
                        --data "{ \\"client_id\\": \\"${env.CLIENT_ID}\\", \\"client_secret\\": \\"${env.CLIENT_SECRET}\\" }"
                    """, returnStdout: true).trim()

                    def lines = response.readLines()
                    def token = lines[1].replaceAll('"', '').trim()
                   XRAY_TOKEN = token
                   echo "Xray Token: ${XRAY_TOKEN}"
                }
            }
        }
       stage('Importer les features de Xray') {
                   steps {
                       script {
                           def exportResponse = bat(
                               script: """
                                   curl -H "Content-Type: application/json" -X GET -H "Authorization: Bearer ${XRAY_TOKEN}"  "https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=POEI20252-526" -o "xray_features.zip"
                                   powershell Expand-Archive -Path xray_features.zip -DestinationPath src\\test\\resources\\features -Force

                               """,
                               returnStdout: true
                           ).trim()

                           echo "Exported Xray features: ${exportResponse}"
                           echo "Features saved in xray_features.json"
                       }
                   }
               }
       stage('test'){
            steps{
                bat 'mvn test'
            }
            post{
                always{
                     junit 'target/surefire-reports/*.xml'
                     cucumber fileIncludePattern: 'target/cucumber.json'
                }
            }
        }
         stage('Send Results to Xray') {
            steps {
                script {
                    bat """
                        curl -X POST https://xray.cloud.getxray.app/api/v2/import/execution/cucumber ^
                        -H "Content-Type: application/json" ^
                        -H "Authorization: Bearer ${XRAY_TOKEN}" ^
                        --data @"target/cucumber.json"
                    """
                }
            }
        }

    }}