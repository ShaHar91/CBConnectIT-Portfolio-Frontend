pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                echo 'building the application...'
//                     def mvnHome = tool 'Maven'
//                     def mvnCMD = "${mvnHome}/bin/mvn"
//                     sh "${mvnCMD} clean install"
                }
            }
        }
        stage('Test') {
            steps {
                script {
                echo 'testing the application...'
//                     def mvnHome = tool 'Maven'
//                     def mvnCMD = "${mvnHome}/bin/mvn"
//                     sh "${mvnCMD} test"
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                echo 'deploying the application...'
//                     def mvnHome = tool 'Maven'
//                     def mvnCMD = "${mvnHome}/bin/mvn"
//                     sh "${mvnCMD} deploy"
                }
            }
        }
    }
}