job('NodeJs Example'){
    scm{
        git('git://github.com/wardviaene/docker-demo.git') {
            node -> // is hudson.plugins.git.GitSCM
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
    steps{
        shell("npm install")
    }
}