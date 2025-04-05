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

                    // Set environment values
                    env.ENVIRONMENT = environment
                    env.IMAGE_NAME = "portfolio-frontend-${environment}"
                    env.CONTAINER_NAME = "${IMAGE_NAME}-${environment}"

                    // Set port based on environment
                    env.EXPOSED_PORT = environment == 'production' ? '2022' :
                                       environment == 'staging' ? '2021' : '2020'

                    env.BASE_URL = environment == 'production' ? 'https://cb-connect-it.com' :
                                    environment == 'staging' ? 'https://stag.cb-connect-it.com' :
                                    'https://dev.cb-connect-it.com'

                    def envFileId = "env-file-${environment}"

                    withCredentials([file(credentialsId: envFileId, variable: 'ENV_FILE_PATH')]) {
                        sh 'cp "$ENV_FILE_PATH" .env'
                    }

                    // Use correct env file
                    env.ENV_FILE = ".env"

                    echo "Branch: ${branch}"
                    echo "Environment: ${ENVIRONMENT}"
                    echo "Using port: ${EXPOSED_PORT}"
                    echo "Using env file: ${ENV_FILE}"
                }
            }
        }

        stage('Prepare Environment File') {
            steps {
                script {
                    // Fail if the env file doesn't exist
                    sh "[ -f ${ENV_FILE} ] || (echo 'Missing environment file: ${ENV_FILE}' && exit 1)"
                    sh "cp ${ENV_FILE} .env"
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
