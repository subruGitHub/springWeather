#!groovy

pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Users\\msubr\\.jdks\\openjdk-16.0.1'
        PATH = "${PATH}" + ';C:\\Users\\msubr\\apache-maven-3.8.1\\bin\\'

    }

    stages {

        stage ('Initialize') {
            steps {

                    echo "PATH = ${PATH}"
                    echo "JAVA_HOME = ${JAVA_HOME}"
            }
        }

        stage('Build') {
            steps {
                echo 'Building pipeline from SCM demo project..'
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '0c7b040d-7881-4c44-a436-1f17e6914827', url: 'https://github.com/subruGitHub/springWeather.git']]])
                bat "mvn clean package verify"
                echo 'deploy removed from mvn for trying purpose.. so no update in artificatory'
                bat "copy target\\*.war target\\springWeather.war"

            }
        }

        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                deploy adapters: [tomcat9(credentialsId: 'Tomcat9', path: '', url: 'http://localhost:8085/')], contextPath: 'springWeather-0.0.1-SNAPSHOT', war: '**/springWeather-0.0.1-SNAPSHOT.war'
                echo 'End of Deploy to Tomcat 9'
            }
        }

    }
}
