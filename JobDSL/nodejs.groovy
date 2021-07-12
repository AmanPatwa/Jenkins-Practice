job('NodeJs Example'){
    scm{
        git('git://github.com/wardviaene/docker-demo.git')
    }
    triggers{
        scm('H/5 * * * *')
    }
    wrappers{
        nodejs('nodejs')
    }
    steps{
        shell("npm start")
    }
}