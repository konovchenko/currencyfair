package com.currencyfair.service;

import com.currencyfair.dao.spi.MessageDao;
import com.currencyfair.model.MessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author Anton Konovchenko
 * @version 1.0.0
 */
@Stateless(name = "MessageService")
@Path("message")
public class MessageService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @EJB
    private MessageDao messageDao;

    @POST
    @Consumes("application/json")
    public void postMessage(MessageEntity messageEntity) {
        messageDao.save(messageEntity);
        MessageEndpoint.send(messageEntity);
    }

}
