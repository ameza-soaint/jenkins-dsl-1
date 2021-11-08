def job = pipelineJob('QA/test') {
    definition {
                cps {
                    script(readFileFromWorkspace('src/main/groovy/projects/QA/test.jenkinsfile'))
                    sandbox()
                }
            }
}


