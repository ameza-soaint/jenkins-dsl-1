
folder('QA') {
    displayName('QA')
    description('QA')
	//def userIDs = helpers.Build_Job_Helper.dev_users()
	// def userIDs = ['developer']
        
    //         for (String oneUser : userIDs) {
    //             authorization {
    //                 permissions("${oneUser}", [
    //                     'hudson.model.Item.Build',
    //                     'hudson.model.Item.Discover',
    //                     'hudson.model.Item.Cancel',
    //                     'hudson.model.Item.Read'
    //                 ])
    //             }
    //         }
}
