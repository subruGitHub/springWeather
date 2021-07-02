#!groovy

pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Users\\msubr\\.jdks\\openjdk-16.0.1'
        PATH = "${PATH}" + ';C:\\Users\\msubr\\apache-maven-3.8.1\\bin\\' + ';C:\\Users\\msubr\\AppData\\Roaming\\npm\\'
        SELENIUM_PATH = 'bin;C:\\Users\\msubr\\Webdriver\\chromedriver_win32;C:\\Users\\msubr\\SpringProject\\springWeather\\target\\SpringWeather-0.0.1-SNAPSHOT\\WEB-INF\\lib\\*;C:\\Users\\msubr\\Webdriver\\geckodriver-v0.29.1-win64;lib/*;./*;%CLASSPATH%\\*;C:\\Windows\\System32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\springdemoPipelineFromGITHUB\\target\\*;C:\\Windows\\System32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\springdemoPipelineFromGITHUB\\target\\test-classes\\*;C:\\Users\\msubr\\.m2\\repository\\com\\beust\\jcommander\\1.48\\jcommander-1.48.jar;C:\\Users\\msubr\\.m2\\repository\\org\\testng\\testng\\6.10\\testng-6.10.jar;C:\\Users\\msubr\\.m2\\repository\\org\\seleniumhq\\selenium\\*;'

    }

    stages {

        stage('Initialize') {
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
                echo 'Testing API using postman..'
                bat "npm install -g newman"
                bat "newman run src\\test\\api\\WeatherAPITestCollection.postman_collection.json"
                echo 'API Testing over..'
                bat "java -cp ${PATH} org.testng.TestNG C:\\Windows\\System32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\springdemoPipelineFromGITHUB\\src\\test\\testng.xml"
            }
        }


        stage('Deploy') {
            steps {
                echo 'Deploying....'
                deploy adapters: [tomcat9(credentialsId: 'Tomcat9', path: '', url: 'http://localhost:8085/')], contextPath: 'SpringWeather-0.0.1-SNAPSHOT', war: '**/SpringWeather-0.0.1-SNAPSHOT.war'
                echo 'End of Deploy to Tomcat 9'
            }
        }

    }
}
