//pipeline syntax = poll version control and do this for every minute
// all is just to say to build off of master branch
//we want two stages. builds app with assemble and we run some tests

//make sure to chmod the build so you can run the gradle commands
pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
        //commenting this for now
//         stage('Test') {
//             steps {
//                 sh './gradlew test'
//             }
//         }
        stage('Build Docker image') {
            steps {
                sh './gradlew docker'
            }
        }
        stage('Push Docker image') {
            environment {
                DOCKER_HUB_LOGIN = credentials('docker-hub')
            }
            steps {
                sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                sh './gradlew dockerPush'
            }
        }
    }
}