package app.akka.actor;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import app.akka.message.Message;
import app.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by thecodemaker on 3/6/14.
 */

@Component
@Scope("prototype")
public class BusinessActor extends UntypedActor {

    private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this);

    @Autowired
    private SimpleService service;

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Message) {
            logger.debug("BusinessActor -> onReceive({})", message);
            service.doAction(((Message) message).getContent());
        } else {
            unhandled(message);
        }
    }
}
