job(NodeJs Docker Demo){
    scm{
        git('git://github.com/wardviaene/docker-demo.git'){
            node ->
            node / gitConfigName('AmanPatwa')
            node / gitConfigEmail('amanpatwa999@gmail.com')
        }
    }
    triggers{
        scm('H/5 * * * *')
    }
    wrappers{
        nodejs('nodejs')
    }
    steps(
        dockerBuildAndPublish{
            repositoryName('wardviaene/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    )
}