node {
    stage 'Checkout' {
      checkout scm
    }

    stage 'Maven Build' {

      withMaven {
        maven: 'Maven 3.5.3',
        // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
        // Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
        // mavenSettingsConfig: 'my-maven-settings',
        mavenLocalRepo: '.repository') {
          sh "mvn clean install"
      }
    }
}    
