def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=df53b8aba6msh32b1da396f0e548p1d775cjsn9108e8018b75 -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker-cred']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
