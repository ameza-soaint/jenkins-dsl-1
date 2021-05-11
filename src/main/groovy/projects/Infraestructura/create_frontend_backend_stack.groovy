// def jobDescription = "Este job utiliza una plantilla CloudFormation de un stack tipo Frontend/Backend (Client Side Render / REST API) " +
//   "para un ambiente con recursos livianos y sin alta disponibilidad. Crea un stack que utiliza un Beanstalk junto a un API Gateway mas " +
//   "un RDS para el backend y un Bucket S3 para el stack frontend. Ambos quedan configurados en CloudFront para recibir peticiones por Internet. " +
//   "Mas info en https://confluence.coopeuch.cl/x/izKSB"

import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()
println instance.inspect()

def realm = instance.getSecurityRealm()
println realm.dump()

println (realm.getClass() == hudson.security.HudsonPrivateSecurityRealm)

if (realm.getClass() == hudson.security.HudsonPrivateSecurityRealm) {
    println "Auth Security Realm Selected: hudson.security.HudsonPrivateSecurityRealm"
}
else {
    println "Auth Security Realm Selected: com.microsoft.jenkins.azuread.AzureSecurityRealm"
}

def jobDescription = 'asdf'

def job = pipelineJob('Infraestructura/create-frontend-backend-stack') {
    definition {
                cps {
                    script(readFileFromWorkspace('src/main/groovy/projects/Infraestructura/create-frontend-backend-stack.jenkinsfile'))
                    sandbox()
                }
            }
}



