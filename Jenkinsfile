pipeline {
  agent any

  stages {
    stage('Controllo Branch') {
      steps {
        script {
          if (env.BRANCH_NAME != 'prod-back') {
            echo "Build saltato: branch non 'production'."
            currentBuild.result = 'SUCCESS'
            return
          }
        }
      }
    }

    stage('Build Immagine Backend') {
      steps {
        dir('.') {
          sh 'docker build -t registroits-backend:latest .'
        }
      }
    }

    stage('Deploy con Docker Compose') {
      steps {
        sh 'docker-compose -f ../docker-compose.yml up -d --no-deps spring'
      }
    }
  }

  post {
    always {
      echo 'Pipeline terminata.'
    }
  }
}
