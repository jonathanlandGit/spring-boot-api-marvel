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
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}