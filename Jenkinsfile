// Why not work with only 1 main branch (no develop)
// - Always build a dev image when pushing to the main branch
// - Always build a staging image when adding tag with `staging-version`
// - Always build a production image when adding tag with `release-version`

pipeline {
    agent any

    environment {
        IMAGE_NAME = "portfolio-frontend"
    }

    stages {
        stage('Determine Environment') {
            steps {
                script {
                    // Determine current Git tag, if any
                    def tag = sh(script: "git describe --tags --exact-match || echo ''", returnStdout: true).trim()
                    def branch = sh(script: "git rev-parse --abbrev-ref HEAD", returnStdout: true).trim()

                    echo "Branch: ${branch}"
                    echo "Tag: ${tag}"

                    def environment = 'develop'
                    def version = 'latest'

                    if (tag == '') {
                        // Not a tag, just a push to main or other branches
                        if (branch == 'main' || branch == 'master') {
                            environment = 'develop'
                        }
                    } else if (tag ==~ /^staging-v\d+\.\d+\.\d+$/) {
                        environment = 'staging'
                        version = tag.replaceFirst(/^staging-v/, '')
                    } else if (tag ==~ /^v\d+\.\d+\.\d+$/) {
                        environment = 'production'
                        version = tag.replaceFirst(/^v/, '')
                    } else {
                        // Unknown tag format
                        error("Unknown tag format: ${tag}")
                    }

                    // Export values to env
                    env.ENVIRONMENT = environment
                    env.VERSION = version
                    env.CONTAINER_NAME = "${IMAGE_NAME}-${environment}"

                    // Set port and base url
                    env.EXPOSED_PORT = environment == 'production' ? '2022' :
                                       environment == 'staging' ? '2021' : '2020'

                    env.BASE_URL = environment == 'production' ? 'https://cb-connect-it.com' :
                                   environment == 'staging' ? 'https://stag.cb-connect-it.com' :
                                   'https://dev.cb-connect-it.com'

                    echo "Environment: ${ENVIRONMENT}"
                    echo "Version: ${VERSION}"
                    echo "Exposed port: ${EXPOSED_PORT}"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${IMAGE_NAME}-${ENVIRONMENT}:${VERSION} ."
            }
        }

        stage('Deploy to Docker') {
            steps {
                script {
                    sh "docker stop ${CONTAINER_NAME} || true"
                    sh "docker rm ${CONTAINER_NAME} || true"
                    sh "docker run -d --name ${CONTAINER_NAME} -p ${EXPOSED_PORT}:8081 ${IMAGE_NAME}-${ENVIRONMENT}:${VERSION}"
                    sh "docker system prune -f"
                }
            }
        }
    }
}

//  // Testing out the environment file!!!
// pipeline {
//     agent any
//
//     stages {
//         stage('Determine Environment') {
//             steps {
//                 script {
//                     def branch = env.GIT_BRANCH?.replaceFirst(/^origin\//, '') ?: 'develop'
//
//                     // Determine environment based on branch/tag
//                     def environment = 'feature'
//                     if (branch == 'main' || branch == 'master') {
//                         environment = 'production'
//                     } else if (branch == 'develop') {
//                         environment = 'develop'
//                     } else if (branch == 'develop' && env.GIT_TAG?.startsWith('staging-')) {
//                         environment = 'staging'
//                     }
//
//                     // Set environment values
//                     env.ENVIRONMENT = environment
// //                     env.IMAGE_NAME = "portfolio-frontend-${environment}"
// //                     env.CONTAINER_NAME = "${IMAGE_NAME}-${environment}"
// //
// //                     // Set port based on environment
// //                     env.EXPOSED_PORT = environment == 'production' ? '2022' :
// //                                        environment == 'staging' ? '2021' : '2020'
// //
// //                     env.BASE_URL = environment == 'production' ? 'https://cb-connect-it.com' :
// //                                     environment == 'staging' ? 'https://stag.cb-connect-it.com' :
// //                                     'https://dev.cb-connect-it.com'
//
//                     def envFileId = "env-file-${environment}"
//
//                     withCredentials([file(credentialsId: envFileId, variable: 'ENV_FILE_PATH')]) {
//                         sh 'cp "$ENV_FILE_PATH" .env.temp'
//                     }
//
//                     // Use correct env file
//                     env.ENV_FILE = ".env.temp"
//
//                     echo "Branch: ${branch}"
//                     echo "Environment: ${ENVIRONMENT}"
// //                     echo "Using port: ${EXPOSED_PORT}"
// //                     echo "Using env file: ${ENV_FILE}"
//                 }
//             }
//         }
//
//         stage('Prepare Environment File') {
//             steps {
//                 script {
//                     // Fail if the env file doesn't exist
//                     sh "[ -f ${ENV_FILE} ] || (echo 'Missing environment file: ${ENV_FILE}' && exit 1)"
//                     sh "cp ${ENV_FILE} .env"
//                 }
//             }
//         }
//
//         stage('Build Docker Image') {
//             steps {
//                 sh "docker build -t ${env.IMAGE_NAME}:${ENVIRONMENT} ."
//             }
//         }
//
//         stage('Deploy to Docker') {
//             when {
//                 anyOf {
//                     branch 'main'
//                     branch 'develop'
//                     expression { return env.GIT_TAG?.startsWith('staging-') }
//                 }
//             }
//             steps {
//                 script {
//                     sh "docker stop ${env.CONTAINER_NAME} || true"
//                     sh "docker rm ${env.CONTAINER_NAME} || true"
//                     sh "docker run -d --name ${env.CONTAINER_NAME} -p ${env.EXPOSED_PORT}:8081 ${env.IMAGE_NAME}:${ENVIRONMENT}"
//                     sh "docker system prune -f"
//                 }
//             }
//         }
//     }
// }

