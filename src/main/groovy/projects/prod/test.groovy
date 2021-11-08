def job = pipelineJob('Prod/test') {
    definition {
                cps {
                    script(readFileFromWorkspace('src/main/groovy/projects/Prod/test.jenkinsfile'))
                    sandbox()
                }
            }
}


