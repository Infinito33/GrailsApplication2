
import grailsapplication2.Comment
import grailsapplication2.Feedback
import grailsapplication2.User

class BootStrap {

    def init = { servletContext ->
        User user = new User(name:'Tomek', email:'tomekmail@gmail.com', webpage:'http://www.polsl.pl')
        User otherUser = new User(name:'Mateusz', email:'mateuszmail@gmail.com', webpage:'http://mateuszweb.pl')
        if (!user.save()){
            log.error "Could not save user!!"
            log.error "${user.errors}"
        }
        if (!otherUser.save()){
            log.error "Could not save otherUser!!"
        }

        Feedback feedback = new Feedback(title:'Initial feedback', feedback:'First feedback of Tomek', user:user)
        feedback.save()

        Comment comment = new Comment(comment:'Hi ho, my name is Mateusz', user:otherUser)
        comment.feedback = feedback
        comment.save();

    }

    def destroy = {
    }

}
