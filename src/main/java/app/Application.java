package app;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import app.akka.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import  static  app.di.SpringExtension.SpringExtProvider;

/**
 * Created by thecodemaker on 3/6/14.
 */
public class Application {

    private final Logger logger = LoggerFactory.getLogger(Application.class);

    public void start() {

        logger.debug("Application(Start)");

        // create a spring context and scan the classes
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);

        // get hold of the actor system
        ActorSystem actorSystem = ctx.getBean(ActorSystem.class);

        // use the Spring Extension to create props for a named actor bean
        ActorRef businessActor = actorSystem.actorOf(SpringExtProvider.get(actorSystem).props("businessActor"), "businessActor");

        /*
        final ActorRef businessActor = actorSystem.actorOf(
                Props.create(SpringActorProducer.class, ctx, "businessActor"),
                "businessActor");
        */

        businessActor.tell(new Message("test"), null);

        actorSystem.shutdown();
    }
}
