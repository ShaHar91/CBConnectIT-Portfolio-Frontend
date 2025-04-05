pipeline {
    agent any

    stages {
        stage('Determine Environment') {
            steps {
                script {
                    def branch = env.GIT_BRANCH?.replaceFirst(/^origin\//, '') ?: 'develop'

                    // Determine environment based on branch/tag
                    def environment = 'feature'
                    if (branch == 'main' || branch == 'master') {
                        environment = 'production'
                    } else if (branch == 'develop') {
                        environment = 'develop'
                    } else if (branch == 'develop' && env.GIT_TAG?.startsWith('staging-')) {
                        environment = 'staging'
                    }

                    def envFileId = "env-file-${environment}"

                    withCredentials([file(credentialsId: envFileId, variable: 'ENV_FILE_PATH')]) {
                        sh 'cp "$ENV_FILE_PATH" .env'
                    }

                    echo "Branch: ${branch}"
                    echo "Environment: ${environment}"
                    echo "Using port: ${EXPOSED_PORT}"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${ENVIRONMENT} ."
            }
        }

        stage('Deploy to Docker') {
            when {
                anyOf {
                    branch 'main'
                    branch 'develop'
                    expression { return env.GIT_TAG?.startsWith('staging-') }
                }
            }
            steps {
                script {
                    sh "docker stop ${CONTAINER_NAME} || true"
                    sh "docker rm ${CONTAINER_NAME} || true"
                    sh "docker run -d --name ${CONTAINER_NAME} -p ${EXPOSED_PORT}:8081 ${IMAGE_NAME}:${ENVIRONMENT}"
                    sh "docker system prune -f"
                }
            }
        }
    }
}
