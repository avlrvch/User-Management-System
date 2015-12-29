package ua.net.ums.dao.impl;

import ua.net.ums.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class JpaDao<T> implements GenericDao<T> {

    private static final String GET_ALL_QUERRY = "SELECT e FROM %s e";

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> type;

    public JpaDao() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        type = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public void remove(T entity) {
        entityManager.remove(entityManager.contains(entity)
                ? entity : entityManager.merge(entity));
    }

    public T findById(Long id) {
        return entityManager.find(type,id);
    }

    public List<T> getAll() {
        String query = String.format(GET_ALL_QUERRY, type.getSimpleName());
        return entityManager.createQuery(query).getResultList();
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }
}
