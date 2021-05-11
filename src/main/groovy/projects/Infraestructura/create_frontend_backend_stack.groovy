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

helpers.Build_Job_Helper.general_config(job)


