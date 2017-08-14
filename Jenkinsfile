node {
  stage('checkout') {
    echo 'checkout from github'
    git url: 'https://github.com/imjacklai/android-jenkins.git', branch: 'master'
  }

  stage('move file') {
    echo 'move file'
    def workspace = pwd() 
    sh 'mv /home/imjacklai/google-services.json ${workspace}/app/'
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

  // stage('upload to google play') {
  //   echo 'upload to google play'
  //   androidApkUpload googleCredentialsId: 'android-interest', apkFilesPattern: '**/*-release.apk', trackName: 'alpha', recentChangeList: [[language: 'zh-TW', text: "Alpha 新版上架！"]]
  // }
}
