package io.khasang.jrepetitor.dao;

import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {

    /**
     * receiving session
     */
    Session getSessionFactory();

    /**
     * method for add entity
     *
     * @param entity = new cat for creation in DB
     * @return created entity
     */
    T create(T entity);

    /**
     * method for receiving all entity
     *
     * @return all entity
     */
    List<T> getList();
}
