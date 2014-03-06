package app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by thecodemaker on 3/6/14.
 */

@Service
public class SimpleServiceImpl implements SimpleService{

    private final Logger logger = LoggerFactory.getLogger(SimpleServiceImpl.class);

    @Override
    public void doAction(String s) {
        logger.debug("ServiceImpl -> doAction({})", s);
    }
}
