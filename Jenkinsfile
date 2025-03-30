pipeline {
    agent any

    environment {
        IMAGE_NAME = "kobweb-frontend"
        CONTAINER_NAME = "kobweb-frontend"
    }

    stages {
//         stage('Run Unit Tests') {
//             steps {
//                 script {
//                     sh '.gradlew test'
//                 }
//             }
//         }
//         stage('Static Code Analysis') {
//             steps {
//                 script {
//                 echo 'testing the application...'
// //                     def mvnHome = tool 'Maven'
// //                     def mvnCMD = "${mvnHome}/bin/mvn"
// //                     sh "${mvnCMD} test"
//                 }
//             }
//         }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t ${IMAGE_NAME} .'
                }
            }
        }
        stage('Deploy to local docker') {
            steps {
                sh 'docker stop ${CONTAINER_NAME} || true'
                sh 'docker rm ${CONTAINER_NAME} || true'
                sh 'docker run -d --name ${CONTAINER_NAME} -p 3000:8081 ${IMAGE_NAME}'
            }
        }
    }
}