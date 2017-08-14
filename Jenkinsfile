node {
	stage('checkout') {
  	echo 'checkout from github'
    git url: 'https://github.com/imjacklai/android-jenkins.git', branch: 'master'
  }

  stage('clean') {
    echo 'clean'
    sh './gradlew clean'
  }

  stage('test') {
    echo 'test'
    sh './gradlew test'
  }

  stage('build apk') {
    echo 'build apk'
    withCredentials([string(credentialsId: 'android_signing_password', variable: 'PASSWORD')]) {
      sh '''
        set +x
        ./gradlew -PkeyAlias='android' -PkeyPassword=${PASSWORD} -PstorePassword=${PASSWORD} -PstoreFile='/home/imjacklai/ctl.jks' assembleRelease
      '''
    }
  }

  // stage('build') {
  //   echo 'build and test'

  //   withCredentials([string(credentialsId: 'android_signing_password', variable: 'PASSWORD')]) {
  //     sh '''
  //       set +x
  //       ./gradlew -PkeyAlias='android' -PkeyPassword=${PASSWORD} -PstorePassword=${PASSWORD} -PstoreFile='/home/imjacklai/ctl.jks' clean test assembleRelease
  //     '''
  //   }
  // }
}
