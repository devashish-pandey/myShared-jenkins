def call (String test , String imgName) {
  withCredentials([usernamePassword(
                    credentialsId: "${test}",
                    passwordVariable: "dockerHubPass",
                    usernameVariable: "dockerHubUser"
                    )]){
                        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                        sh "docker tag ${imgName}:latest ${env.dockerHubUser}/${imgName}:latest"
                        sh "docker push ${env.dockerHubUser}/${imgName}:latest"
                    }
}
