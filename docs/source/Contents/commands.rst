commands
========

1. Build image

docker build -t jenkins:jcasc .

2. Run Jenkins with JCasC (Jenkins Configuration as Code) plugin

sudo docker run --name jenkins --rm -p 8080:8080 --env-file test.env jenkins:jcasc
