FROM jenkins/jenkins:lts-jdk17
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
ENV CASC_JENKINS_CONFIG="/var/jenkins_home/config.yaml"
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY config.yaml /var/jenkins_home/config.yaml
COPY job_dsl.groovy /var/jenkins_home/job_dsl.groovy
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt
USER root
RUN apt-get update && apt-get install -y make
RUN apt-get update && apt-get install -y build-essential gcc
