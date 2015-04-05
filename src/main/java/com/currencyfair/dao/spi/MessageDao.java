package com.currencyfair.dao.spi;

import com.currencyfair.model.MessageEntity;

import java.util.List;

/**
 * @author Anton Konovchenko
 * @version 1.0.0
 */
public interface MessageDao {
    List<MessageEntity> findAll();

    void save(MessageEntity entity);
}
