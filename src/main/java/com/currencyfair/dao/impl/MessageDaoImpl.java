package com.currencyfair.dao.impl;

import com.currencyfair.dao.spi.MessageDao;
import com.currencyfair.model.MessageEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Anton Konovchenko
 * @version 1.0.0
 */
@Stateless(name = "MessageDao")
public class MessageDaoImpl implements MessageDao {
    @PersistenceContext(unitName = "currencyfair")
    protected EntityManager entityManager;

    @Override
    public void save(MessageEntity entity) {
        entityManager.persist(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MessageEntity> findAll() {
        return entityManager.createQuery("from MessageEntity").getResultList();
    }
}
