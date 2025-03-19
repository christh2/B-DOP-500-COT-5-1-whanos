Whanos
=======
In this project, we are asked to use all the notions that have been thought throughout our first and second year. We must set up an as-powerful
Whanos infrastructure that allows any developer to automatically deploy an application into a cluster, just by a push to their Git repository.

Following a push to a Whanos-compatible repository, it will perform the following steps:

1. Fetches the Git repository.

2. Analyses its content to determine its technology.

3. Containerizes the application into an image, based on both a Whanos image, and an eventual user-provided image customization.

4. Pushes the image into a Docker registry.

5. If a valid "whanos.yml" file exists, deploys the image into a cluster following the given configuration.


Structure of the repository
============================

Images
++++++

- *C*:

  - Detection: Makefile at the root.

  - Execution: Compiled binary.

  - Base Image: whanos-c.


- *Java*:

  - Detection: pom.xml in the app directory.

  - Execution: java -jar app.jar.

  - Base Image: whanos-java.


- *JavaScript*:

  - Detection: package.json at the root.

  - Execution: node ..

  - Base Image: whanos-javascript.


- *Python*:

  - Detection: requirements.txt at the root.

  - Execution: python -m app.

  - Base Image: whanos-python.


- *Befunge*:

  - Detection: main.bf in the app directory.

  - Execution: Free choice.

  - Base Image: whanos-befunge.