pipeline {
    agent any

    tools {
        jdk 'Java17'
        maven 'maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Extent Reports') {
            steps {
                publishHTML(target: [
                    reportDir: 'Test-Reports',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent HTML Report',
                    keepAll: true
                ])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'Test-Reports/ExtentReport.html', fingerprint: true
            junit 'target/surefire-reports/*.xml'
        }

        success {
            emailext(
                to: 'sanjaytanguturi37@gmail.com',
                subject: "Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                <html><body>
                <p>Hello Team,</p>
                <p>The Jenkins build has completed <b style='color:green;'>SUCCESSFULLY ✅</b>.</p>

                <p><b>Project Name:</b> ${env.JOB_NAME}</p>
                <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>

                <p><b>Build URL:</b> 
                    <a href="${env.BUILD_URL}">${env.BUILD_URL}</a>
                </p>

                <p>Please check the Extent Report in Jenkins.</p>

                <p>Regards,<br/>Automation Team</p>
                </body></html>
                """,
                mimeType: 'text/html',
                attachLog: true
            )
        }

        failure {
            emailext(
                to: 'sanjaytanguturi37@gmail.com',
                subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                <html><body>
                <p>Hello Team,</p>
                <p>The Jenkins build has <b style='color:red;'>FAILED ❌</b>.</p>

                <p><b>Project Name:</b> ${env.JOB_NAME}</p>
                <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>

                <p><b>Build URL:</b> 
                    <a href="${env.BUILD_URL}">${env.BUILD_URL}</a>
                </p>

                <p>Please review logs and reports.</p>

                <p>Regards,<br/>Automation Team</p>
                </body></html>
                """,
                mimeType: 'text/html',
                attachLog: true
            )
        }
    }
}
