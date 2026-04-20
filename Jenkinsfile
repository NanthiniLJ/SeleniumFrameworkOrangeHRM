pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Build') {
            steps {
                dir('SeleniumFramework') {
                    bat 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                dir('SeleniumFramework') {
                    bat 'mvn test'
                }
            }
	post {
            always {
            	junit 'SeleniumFramework/target/surefire-reports/*.xml'
        }
    }
        }
    }
}