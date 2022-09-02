node("master") {
    stage("Checking out Code") {
        checkout scm
    }
    stage("Code Stability") {
        sh "mvn clean install"
    }
    stage("Code Quality") {
        sh "mvn checkstyle:checkstyle"
        recordIssues(tools: [checkStyle(pattern: '**/checkstyle-result.xml')])
    }
    stage("Unit Testing") {
        sh "mvn test"
        recordIssues(tools: [junitParser(pattern: 'target/surefire-reports/*.xml')])
    }
    stage("Security Testing") {
        sh "mvn org.owasp:dependency-check-maven:check"
        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target', reportFiles: 'dependency-check-report.html', reportName: 'Dependency Check Report', reportTitles: ''])
    }
    stage("Sonarqube Analysis") {
        sh "mvn sonar:sonar -Dsonar.host.url=${SONAR_URL} -Dsonar.login=${SONAR_USER} -Dsonar.password=${SONAR_PASSWORD} -Dsonar.java.binaries=."
    }
    stage("Uploading artifact") {
        nexusArtifactUploader artifacts: [[artifactId: 'spring3hibernate', classifier: '', file: 'target/Spring3HibernateApp.war', type: 'war']], credentialsId: 'nexus-creds', groupId: 'org', nexusUrl: '34.210.179.48:8081/', nexusVersion: 'nexus3', protocol: 'http', repository: 'spring3hibernate', version: 'v0.1'
    }
    stage("Deploying to Dev Environment") {
        //sh "ansible-playbook -i hosts playbook.yaml -e nexus_artifact_url=http://34.210.179.48:8081/repository/spring3hibernate/org/spring3hibernate/v0.1/spring3hibernate-v0.1.war"
        echo "Deployment"
    }
    stage("DB Update") {
        sh "mvn flyway:migrate"
    }
}
