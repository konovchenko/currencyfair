package com.currencyfair;

import com.currencyfair.dao.spi.MessageDao;
import com.currencyfair.model.MessageEntity;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * @author Anton Konovchenko
 * @version 1.0.0
 */
@ManagedBean
@SessionScoped
public class MessageBean implements Serializable {
    @EJB
    private MessageDao messageDao;

    public List<MessageEntity> getMessages() {
        return messageDao.findAll();
    }
}
