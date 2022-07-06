pipeline{
    agent any
    stages {
        stage('build') {
            steps{
            java NumberConversion
            echo "building........"
        }
        }
        stage('test'){
            steps{
            java NumberTest
            echo "testing......"
        }
        }
    }
}
