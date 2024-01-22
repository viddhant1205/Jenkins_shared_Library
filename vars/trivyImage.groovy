def call() {
    sh 'trivy image kubegourav/youtube:latest > trivyimage.txt'
}
