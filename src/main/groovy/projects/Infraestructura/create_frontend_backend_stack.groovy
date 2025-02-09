import jenkins.model.*
import hudson.security.*


// def jobDescription = "Este job utiliza una plantilla CloudFormation de un stack tipo Frontend/Backend (Client Side Render / REST API) " +
//   "para un ambiente con recursos livianos y sin alta disponibilidad. Crea un stack que utiliza un Beanstalk junto a un API Gateway mas " +
//   "un RDS para el backend y un Bucket S3 para el stack frontend. Ambos quedan configurados en CloudFront para recibir peticiones por Internet. " +
//   "Mas info en https://confluence.coopeuch.cl/x/izKSB"

def jobDescription = 'asdf'

def job = pipelineJob('Infraestructura/create-frontend-backend-stack') {
    definition {
                cps {
                    script(readFileFromWorkspace('src/main/groovy/projects/Infraestructura/create-frontend-backend-stack.jenkinsfile'))
                    sandbox()
                }
            }
}

def jenkins = Jenkins.getInstance()
def realm = jenkins.getSecurityRealm()
println realm.getClass().toString()
println realm.getClass().getName()
println realm.getClass().getSimpleName()
println realm.getClass().getName() == "hudson.security.HudsonPrivateSecurityRealm"
println realm.getClass().getSimpleName() == "HudsonPrivateSecurityRealm"

println "inside job groovy"

helpers.Build_Job_Helper.general_config(job)

println "fin"

