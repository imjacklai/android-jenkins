node {
	stage('checkout') {
  	echo 'checkout from github'
    git url: 'https://github.com/imjacklai/android-jenkins.git', branch: 'master'
  }

  stage('build') {
    echo 'build and test'
    sh "./gradlew clean test assembleDebug"
  }
}
