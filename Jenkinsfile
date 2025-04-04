pipeline {
    agent any

    environment {
        XRAY_AUTH_URL = 'https://xray.cloud.getxray.app/api/v2/authenticate'
        XRAY_EXPORT_URL = 'https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=POEI20252-526'
        CLIENT_ID = 'DA94515D482B438FA35A924E4B840298'
        CLIENT_SECRET = '8da250e9eb7def34f65be632e6fc7e13a229059bcc8a9dbb1ae1e9c3deb33fdf'
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

                    response = response.replaceAll('"', '')
                    env.XRAY_TOKEN = response
                    echo "Token: ${env.XRAY_TOKEN}"
                }
            }
        }


    }}

