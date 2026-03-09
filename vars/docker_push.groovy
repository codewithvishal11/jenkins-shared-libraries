def call(String Project, String ImageTag, String dockerhubuser){
    withCredentials([usernamePassword(credentialsId: 'dockerhubcred',
        usernameVariable: 'dockerhubUser',
        passwordVariable: 'dockerhubPass')]) {

        sh """
        docker login -u \$dockerhubUser -p \$dockerhubPass
        docker tag ${Project}:${ImageTag} ${dockerhubuser}/${Project}:${ImageTag}
        docker push ${dockerhubuser}/${Project}:${ImageTag}
        """
    }
}
