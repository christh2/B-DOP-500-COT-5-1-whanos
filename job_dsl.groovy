folder('Whanos base images') {
    displayName('Whanos base images')
    description('Folder for Whanos base images.')

    freeStyleJob('whanos-c') {
        steps {
            shell("docker build -t whanos-c -f images/c/Dockerfile.base .")
        }
        
        wrappers {
            preBuildCleanup()
        }
    }

    freeStyleJob('whanos-java') {
        steps {
            shell("docker build -t whanos-java -f images/java/Dockerfile.base .")
        }

        wrappers {
            preBuildCleanup()
        }
    }

    freeStyleJob('whanos-javascript') {
        steps {
            shell("docker build -t whanos-javascript -f images/javascript/Dockerfile.base .")
        }

        wrappers {
            preBuildCleanup()
        }
    }

    freeStyleJob('whanos-python') {
        steps {
            shell("docker build -t whanos-python -f images/python/Dockerfile.base .")
        }

        wrappers {
            preBuildCleanup()
        }
    }

    freeStyleJob('whanos-befunge') {
        steps {
            shell("docker build -t whanos-befunge -f images/befunge/Dockerfile.base .")
        }

        wrappers {
            preBuildCleanup()
        }
    }

    freeStyleJob('Build all base images') {
        steps {
            publishers {
                downstream('Whanos base images/whanos-c')
                downstream('Whanos base images/whanos-java')
                downstream('Whanos base images/whanos-javascript')
                downstream('Whanos base images/whanos-python')
                downstream('Whanos base images/whanos-befunge')
            }
        }

        wrappers {
            preBuildCleanup()
        }
    }
}

folder('Projects') {
    displayName('Projects')
    description('projects.')
}

freeStyleJob('link-project') {
        parameters {
            stringParam('REPO_URL', '', 'GitHub repository URL (e.g., https://github.com/owner/repo.git)')
            stringParam('DISPLAY_NAME', '', 'Display name for the job')
            stringParam('GIT_BRANCH_NAME', 'main', 'Git branch to clone (default: main)')
        }

        steps {
            dsl {
                text('''job ("Projects/$DISPLAY_NAME") {
                    triggers {
                        scm('* * * * *')
                    }

                    scm {
                        git {
                            remote {
                                name('origin')
                                url("${REPO_URL}")
                                credentials('e1979c73-8dc6-4e2e-aa5a-b53da3f9c0f3')
                            }
                            branches("${GIT_BRANCH_NAME}")
                        }
                    }

                    wrappers {
                        preBuildCleanup()
                    }

                    steps {
                        shell('make')
                        shell('make fclean')
                        shell('make clean')
                    }
                }''')
            }
        }
    }