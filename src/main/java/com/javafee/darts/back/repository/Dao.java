package com.javafee.darts.back.repository;

import com.javafee.darts.back.config.HibernateConfig;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

@Slf4j
public class Dao<T> {
    static {
        HibernateConfig hc = new HibernateConfig();
    }

    private Class<?> persistenceClass;

    public Dao(Class<T> c) {
        persistenceClass = c;
    }

    public void save(T entity) {
        transactional(e -> e.persist(entity));
    }

    public List<T> findAll() {
        List<T> result = null;
        Transaction transaction = HibernateConfig.getSession().getTransaction();
        try {
            if (!transaction.isActive()) {
                transaction.begin();
                result = (List<T>) HibernateConfig.getSession()
                        .createQuery("from " + persistenceClass.getSimpleName(), persistenceClass).getResultList();
                transaction.commit();
            }
        } catch (Exception e) {
            if (!Objects.isNull(transaction))
                transaction.rollback();
            log.error(e.getMessage());
        }
        return result;
    }

    public List<T> executeQuery(String hql) {
        return (List<T>) HibernateConfig.getSession().createQuery(hql, persistenceClass).getResultList();
    }

    public List<T> executeNativeQuery(String sql) {
        return (List<T>) HibernateConfig.getSession().createNamedQuery(sql, persistenceClass).getResultList();
    }

    private void transactional(Consumer<Session> action) {
        Transaction transaction = HibernateConfig.getSession().getTransaction();
        try {
            if (!transaction.isActive()) {
                transaction.begin();
                action.accept(HibernateConfig.getSession());
                transaction.commit();
            }
        } catch (Exception e) {
            if (!Objects.isNull(transaction))
                transaction.rollback();
            log.error(e.getMessage());
        }
    }
}
