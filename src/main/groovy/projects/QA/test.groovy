def job = pipelineJob('QA/test') {
    definition {
                cps {
                    script(readFileFromWorkspace('src/main/groovy/projects/QA/test.jenkinsfile'))
                    sandbox()
                }
            }
	def userIDs = ['developer']        
        
    for (String oneUser : userIDs) {
        authorization {
            permissions("${oneUser}", [
                'hudson.model.Item.Build',
                'hudson.model.Item.Discover',
                'hudson.model.Item.Cancel',
                'hudson.model.Item.Read'
            ])
        }
    }
}