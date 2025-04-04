stage('Xray Authentication') {
    steps {
        script {
            def token = sh(returnStdout: true, script: '''
                curl -X POST \
                -H "Content-Type: application/json" \
                -d "{\\"client_id\\":\\"${CLIENT_ID}\\", \\"client_secret\\":\\"${SECRET_CLIENT}\\"}" \
                https://xray.cloud.getxray.app/api/v2/authenticate
            ''').trim()

            env.XRAY_TOKEN = token
            echo "Xray Token: ${token}"
        }
    }
}