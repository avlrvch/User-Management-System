package ua.net.ums.dao;

import java.util.List;

public interface GenericDao<T> {

    void create(T entity);
    void remove(T entity);
    T findById(Long id);
    List<T> getAll();
    void update(T entity);
}
