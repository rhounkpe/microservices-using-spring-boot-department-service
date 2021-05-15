pipeline {

    agent any

    options {
        buildDiscarder logRotator(
                    daysToKeepStr: '16',
                    numToKeepStr: '10'
            )
    }

    stages {

        stage('Cleanup Workspace') {
            steps {
                cleanWs()
                sh """
                echo "Cleaned Up Workspace For Project"
                """
            }
        }

        stage('Code Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/develop'], [name: '*/staging'], [name: '*/production']],
                    extensions: [[
                        $class: 'CleanBeforeCheckout',
                        deleteUntrackedNestedRepositories: true
                    ]],
                    userRemoteConfigs: [[url: 'https://github.com/rhounkpe/microservices-using-spring-boot-department-service']]
                ])
            }
        }

        stage(' Unit Testing') {
            when {
                branch 'develop'
            }
            steps {
                sh """
                echo "Running Unit Tests"
                """
            }
        }

        stage('Code Analysis') {
            when {
                branch 'develop'
            }
            steps {
                sh """
                echo "Running Code Analysis"
                """
            }
        }

        stage('Build') {
            when {
                branch 'develop'
            }
            steps {
                sh """
                echo "Building Artifact"
                """

                sh """
                echo "Deploying Code"
                """
            }
        }

        stage('Publish') {
            when {
                branch 'develop'
            }
            steps {
                sh """
                echo "Building Artifact"
                """

                sh """
                echo "Deploying Code"
                """
            }
        }

        stage('Deploy to Develop') {
            when {
                branch 'develop'
            }
            steps {
                sh """
                echo "Building Artifact"
                """

                sh """
                echo "Deploying Code to Develop"
                """
            }
        }

        stage('Deploy to Staging') {
            when {
                branch 'staging'
            }
            steps {
                sh """
                echo "Building Artifact"
                """

                sh """
                echo "Deploying Code to Staging"
                """
            }
        }

        stage('Deploy to Production') {
            when {
                branch 'production'
            }
            steps {
                sh """
                echo "Building Artifact"
                """

                sh """
                echo "Deploying Code to Production"
                """
            }
        }
    }

    /*
    post {
        success {
            mail to: "rhounkpe@gmail.com", subject:"SUCCESS: ${currentBuild.fullDisplayName}", body: "Yay, we passed."
        }
        failure {
          mail to: "rhounkpe@gmail.com", subject:"FAILURE: ${currentBuild.fullDisplayName}", body: "Boo, we failed."
        }
      }
     */
}
