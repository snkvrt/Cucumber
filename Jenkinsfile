pipeline {
    agent any

    environment {
        // Variables d'environnement pour l'authentification Xray
        PATH = "C:\\Users\\IB\\.jenkins\\workspace\\pipCucumberXray"
        XRAY_AUTH_URL = 'https://xray.cloud.getxray.app/api/v2/authenticate'
        XRAY_EXPORT_URL = 'https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=POEI20252-526'
        CLIENT_ID = 'DA94515D482B438FA35A924E4B840298'
        CLIENT_SECRET = '8da250e9eb7def34f65be632e6fc7e13a229059bcc8a9dbb1ae1e9c3deb33fdf'
        XRAY_TOKEN = ""
    }

    stages {
        stage('Authenticate with Xray') {
                    steps {
                        script {
                            def response = bat(script: """
                                curl -H "Content-Type: application/json" -X POST ^
                                ${env.XRAY_AUTH_URL} ^
                                --data "{ \"client_id\": \"${env.CLIENT_ID}\", \"client_secret\": \"${env.CLIENT_SECRET}\" }"
                            """, returnStdout: true).trim()

                            def lines = response.readLines()
                            def token = lines[1].replaceAll('"', '').trim()
                           XRAY_TOKEN = token
                           echo "Xray Token: ${XRAY_TOKEN}"
                        }
                    }
                }
                }
        // stage('Get Xray Export') {
        //             steps {
        //                 bat(script: """
        //                 curl -H "Content-Type: application/json" -X GET -H "Authorization: Bearer ${env.XRAY_TOKEN}"  "https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=POEI25-657" "-o features.zip"
        //                     """)
        //
        //             }
        // }
        //
        // stage('Extract Features') {
        //     steps {
        //         script {
        //             // 1. Vérifier que le fichier existe
        //             def zipExists = fileExists "C:\\Users\\IB\\.jenkins\\workspace\\pipCucumberXray\\features.zip"
        //             if (!zipExists) {
        //                 def currentDir = bat(script: '@echo %cd%', returnStdout: true).trim()
        //                 echo "Dossier courant (Windows): ${currentDir}"
        //                 error "Le fichier features.zip est introuvable dans le workspace"
        //             }else echo "zip features trouvé !"
        //
        //         }
        //     }
        // }

    }
}

