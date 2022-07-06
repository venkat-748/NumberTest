pipeline{
    agent any
    stages {
        stage('build') {
            java NumberConversion
            echo "building........"
        }
        stage('test'){
            java NumberTest
            echo "testing......"
        }
    }
}
