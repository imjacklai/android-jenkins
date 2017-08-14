node {
	stage('checkout') {
  	echo 'checkout from github'
    git url: 'https://github.com/imjacklai/android-jenkins.git', branch: 'master'
  }

  stage('build') {
    echo 'build and test'

    withCredentials([string(credentialsId: 'android_signing_password', variable: 'ANDROID_SIGNING_PASSWORD')]) {
      sh '''
        set +x
        ./gradlew -PkeyAlias='android' -PkeyPassword=${ANDROID_SIGNING_PASSWORD} -PstorePassword=${ANDROID_SIGNING_PASSWORD} -PstoreFile='/home/imjacklai/ctl.jks' clean test assembleRelease
      '''
    }
  }
}
