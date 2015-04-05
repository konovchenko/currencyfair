package com.currencyfair.service;

import com.currencyfair.dao.spi.MessageDao;
import com.currencyfair.model.MessageEntity;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @author Anton Konovchenko
 * @version 1.0.0
 */
@ServerEndpoint(
        value = "/endpoint",
        encoders = { MessageEncoder.class }
)
public class MessageEndpoint {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MessageEndpoint.class);
    private static Queue<Session> queue = new ConcurrentLinkedQueue<>();

    @Inject
    private MessageDao messageDao;

    public static void send(MessageEntity messageEntity) {
        try {
            for (Session session : queue) {
                session.getBasicRemote().sendObject(messageEntity);
            }
        } catch (IOException | EncodeException e) {
            logger.error("", e);
        }
    }

    @OnOpen
    public void openConnection(Session session) {
        queue.add(session);
        logger.info("Connection opened.");

        List<MessageEntity> messageList = messageDao.findAll();
        for (MessageEntity messageEntity : messageList) {
            send(messageEntity);
        }
    }

    @OnClose
    public void closedConnection(Session session) {
        queue.remove(session);
        logger.info("Connection closed.");
    }

    @OnError
    public void error(Session session, Throwable t) {
        queue.remove(session);
        logger.info(t.toString());
        logger.info("Connection error.");
    }

}

