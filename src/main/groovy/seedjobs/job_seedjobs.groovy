import groovy.io.FileType

def list = []

def currentDir = new File(".").getAbsolutePath()
println currentDir

println new File(getClass().protectionDomain.codeSource.location.path).parent

println getClass().protectionDomain.codeSource.location.path

// def branches = new groovy.json.JsonSlurper().parse(branchApi.newReader())
// branches.each {
//     def branchName = it.name
//     def jobName = "${project}-${branchName}".replaceAll('/','-')
//     job(jobName) {
//         scm {
//             git("https://github.com/${project}.git", branchName)
//         }
//     }
// }

seedjobs = [
        [name: 'Infraestructura', external: 'src/main/groovy/projects/Infraestructura/*.groovy']
        [name: 'Prod', external: 'src/main/groovy/projects/Prod/*.groovy']
        [name: 'QA', external: 'src/main/groovy/projects/QA/*.groovy']
]

seedjobs.each { seedjob ->

    def jobName = seedjob.name + '/' +'job_seedjob'

    job(jobName) {
        scm {
            git {
                remote {
                    url('https://github.com/ameza-soaint/jenkins-dsl-1.git')
                }
                branch('master')
                extensions {
                    cleanBeforeCheckout()
                    cloneOptions {
                        shallow(true)
                    }
                }
            }
        }
        wrappers {
            timestamps()
        }
        steps {
            dsl{
                external(seedjob.external)
                additionalClasspath('src/main/groovy/dsl-helpers')
            }
        }
    }
    queue(jobName)
}
