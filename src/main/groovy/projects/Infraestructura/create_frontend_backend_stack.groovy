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

//helpers.Build_Job_Helper.general_config(job, jobDescription)

//TO-DO
// Obtener los parametros desde el jenkinsfile y configurarlos en el job.
// Esto debido a que los parametros en el jenkinsfile se configuran
// cuando se ejecuta el job por lo tanto se pierden cada vez que se ejecuta un seed.
// get parameters
def pipelineFile = readFileFromWorkspace('src/main/groovy/projects/Infraestructura/create-frontend-backend-stack.jenkinsfile')
println "${pipelineFile}"

// def parameters = build?.actions.find{ it instanceof ParametersAction }?.parameters
// parameters.each {
//    println "parameter ${it.name}:"
//    println it.dump()
// }

