Whanos

Automatically deploy (nearly) anything with a snap!
*Project Overview*

Whanos combines powerful DevOps technologies to create an infrastructure that enables developers to automatically deploy applications to a cluster with a simple Git push. It leverages:

    Docker for containerization
    GitHub Actions/Jenkins for task automation
    Ansible for configuration management
    Kubernetes for orchestration

*Features*

    Automatic Deployment Pipeline:
        Detect repository content.
        Build Docker images based on Whanos specifications.
        Push Docker images to a registry.
        Deploy applications to a Kubernetes cluster.
    Supported Languages: C, Java, JavaScript, Python, Befunge.
    Infrastructure: Fully automated using Jenkins jobs and Kubernetes clusters.

*Repository Structure*

    ├── app/                  # Source code directory
    ├── images/               # Dockerfiles for base and standalone images
    │   ├── c/
    │   ├── java/
    │   ├── javascript/
    │   ├── python/
    │   └── befunge/
    ├── docs/                 # Documentation files
    ├── Jenkins/              # Jenkins configuration files
    └── whanos.yml            # Deployment specifications

*Setup and Installation*

    Clone the repository:

git clone git@github.com:EpitechPromo2027/B-DOP-500-COT-5-1-whanos-ange-marie.dossou.git

Install required dependencies for Docker, Jenkins, Ansible, and Kubernetes.
Deploy the infrastructure:

    ansible-playbook -i inventory playbook.yml

    Access the Jenkins instance to manage jobs and deployments.

*Usage*

    To deploy an application:
        Ensure the application repository is Whanos-compatible.
        Push the repository to Git.
        Jenkins will automatically build, containerize, and deploy it to the Kubernetes cluster.

*Contributing*

Contributions are welcome! Please ensure all changes are tested and documented.
License

MIT License.
Documentation
1. Overview

Whanos is a DevOps platform designed to streamline application deployment. It integrates leading technologies for:

    Containerization: Docker.
    Task Automation: Jenkins.
    Configuration Management: Ansible.
    Orchestration: Kubernetes.

2. Whanos-Compatible Repository Specifications

Each repository must:

    Contain a single application in an app directory.
    Include a dependency file (Makefile, pom.xml, package.json, requirements.txt, or main.bf).
    Support languages: C, Java, JavaScript, Python, or Befunge.

3. Infrastructure Details
Docker Images

    Standalone Images: For default runtime configurations.
    Base Images: Allow custom runtime configurations via user-defined Dockerfiles.

Jenkins

    Jenkins manages job pipelines to:
        Build Docker images.
        Deploy applications to Kubernetes clusters.

Kubernetes

    Deploy applications using the specifications in whanos.yml.

4. Deployment Steps

    Configure Jenkins jobs for base image builds and application deployment.
    Ensure the Kubernetes cluster is accessible (2+ nodes).
    Deploy the infrastructure using Ansible:

    ansible-playbook deploy.yml

5. Example whanos.yml File

deployment:
  replicas: 2
  resources:
    limits:
      memory: "512Mi"
      cpu: "0.5"
  ports:
    - 80

6. Troubleshooting

    Repository Compatibility Issues:
        Ensure the correct dependency file exists.
        Check for errors in whanos.yml.
    Deployment Errors:
        Verify cluster status and Jenkins job configurations.
