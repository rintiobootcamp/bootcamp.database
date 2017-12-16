package com.bootcamp.repositories;

import com.bootcamp.commons.constants.DatabaseConstants;
import com.bootcamp.commons.exceptions.DatabaseException;
import com.bootcamp.commons.models.Criterias;
import com.bootcamp.commons.utils.NativeQueryResultsMapper;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.*;

/**
 * Created by SOUL repository de base implementer par chaque entite
 *
 * @param <T>
 */
public abstract class BaseRepository<T> implements DatabaseConstants {

    private EntityManager em;
    private String persistUnit;
    private Class entityClass;
    private EntityManagerFactory emf;

    /**
     * Initialize the Base Repository with the wanted persistence unit and
     * entity class
     *
     * @param persistUnit
     * @param entityClass
     */
    public BaseRepository(String persistUnit, Class entityClass) {
        this.persistUnit = persistUnit;
        emf = Persistence.createEntityManagerFactory(this.persistUnit);
        this.em = getEntityManager();
        this.entityClass = entityClass;
    }

    /**
     * Get the repository entity manager
     *
     * @return the repository entity manager
     */
    public final EntityManager getEntityManager() {
        em = emf.createEntityManager();
        return em;
    }

    /**
     * Insert an object in the database
     *
     * @param object
     * @return
     * @throws SQLException
     */
    public boolean create(T object) throws SQLException {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();

        return true;
    }

    /**
     * Delete an object in the database
     *
     * @param object
     * @return boolean
     * @throws java.sql.SQLException
     */
    public boolean delete(T object) throws SQLException {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();

        return true;
    }

    /**
     * Update an object in the database
     *
     * @param object
     * @return boolean
     * @throws java.sql.SQLException
     */
    public boolean update(T object) throws SQLException {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();

        return true;
    }

    /**
     * Get an object in the database knowing its id
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public T findById(int id) throws SQLException {
        String className = entityClass.getSimpleName();

        String request = "select t from " + className + " t where t.id =:param";
        Query query = getEntityManager().createQuery(request);
        query.setParameter("param", id);
        return (T) query.getSingleResult();
    }

    /**
     * Find all the T objects in the database
     *
     * @return all the T objects
     * @throws SQLException
     */
    public List<T> findAll() throws SQLException {
        String className = entityClass.getSimpleName();

        String req = "select t from " + className + " t";
        Query query = getEntityManager().createQuery(req);
        return query.getResultList();
    }

    /**
     * Find all the T objects in the database matching the given criteria list
     *
     * @param criterias
     * @param entityPrefix
     * @return objects
     */
    public List<T> getDataByCriteria(Criterias criterias, String entityPrefix) {
        criterias.setEntityClass(entityClass);

        String request = criterias.getAsStringQuery(entityPrefix);
        String className = entityClass.getSimpleName();

        String s = "SELECT " + entityPrefix + " FROM " + className + " " + entityPrefix + " WHERE " + request;
        Query query = getEntityManager().createQuery(s);
        List<T> result = query.getResultList();
        return result;
    }

    /**
     * Find all the T objects in the database matching the given criteria list
     *
     * @param criterias
     * @return objects
     */
    public List<T> getDataByCriteria(Criterias criterias) {
        criterias.setEntityClass(entityClass);

        return getDataByCriteria(criterias, QUERY_PREFIX);
    }

    /**
     * Find all the T objects in the database matching the given criteria list,
     * page and size
     *
     * @param criterias
     * @param entityPrefix
     * @param page
     * @param size
     * @return objects
     */
    public List<T> getDataByCriteria(Criterias criterias, String entityPrefix, int page, int size) {
        criterias.setEntityClass(entityClass);

        String request = criterias.getAsStringQuery(entityPrefix);
        String className = entityClass.getSimpleName();

        String s = "SELECT " + entityPrefix + " FROM " + className + " " + entityPrefix + " WHERE " + request;
        Query query = getEntityManager().createQuery(s);
        query.setFirstResult(page);
        query.setMaxResults(size);
        List<T> result = query.getResultList();
        return result;
    }

    /**
     * Find all the T objects in the database matching the given criteria list,
     * page and size
     *
     * @param criterias
     * @param page
     * @param size
     * @return objects
     */
    public List<T> getDataByCriteria(Criterias criterias, int page, int size) {
        criterias.setEntityClass(entityClass);

        return getDataByCriteria(criterias, QUERY_PREFIX, page, size);
    }

    /**
     * Find all the given fields of all the T objects in the database matching
     * the given criteria list
     *
     * @param criterias
     * @param entityPrefix
     * @param fields
     * @return objects
     * @throws IllegalAccessException
     * @throws DatabaseException
     * @throws InvocationTargetException
     */
    public List<T> getDataByCriteria(Criterias criterias, String entityPrefix, List<String> fields) throws IllegalAccessException, DatabaseException, InvocationTargetException {
        criterias.setEntityClass(entityClass);

        String request = criterias.getAsStringQuery(entityPrefix);
        String fullClassname = entityClass.getName();
        String className = entityClass.getSimpleName();

        String selectedFields = "SELECT ";

        for (int i = 0; i < fields.size(); i++) {
            String field = fields.get(i);
            if (i != fields.size() - 1) {
                selectedFields = selectedFields + " " + entityPrefix + "." + field + ", ";
            } else {
                selectedFields = selectedFields + " " + entityPrefix + "." + field;
            }
        }

        selectedFields = selectedFields + " FROM " + className + " " + entityPrefix + " WHERE " + request;

        Query query = getEntityManager().createQuery(selectedFields);
        List<Object[]> objects = query.getResultList();

        List<T> results = NativeQueryResultsMapper.map(objects, fields, entityClass);

        return results;
    }

    /**
     * Find all the given fields of all the T objects in the database matching
     * the given criteria list
     *
     * @param criterias
     * @param fields
     * @return objects
     * @throws IllegalAccessException
     * @throws DatabaseException
     * @throws InvocationTargetException
     */
    public List<T> getDataByCriteria(Criterias criterias, List<String> fields) throws IllegalAccessException, DatabaseException, InvocationTargetException {
        criterias.setEntityClass(entityClass);

        return getDataByCriteria(criterias, QUERY_PREFIX, fields);
    }

    /**
     * Find all the given fields of all the T objects in the database
     *
     * @param entityPrefix
     * @param fields
     * @return objects
     * @throws IllegalAccessException
     * @throws DatabaseException
     * @throws InvocationTargetException
     */
    public List<T> getDataByCriteria(String entityPrefix, List<String> fields) throws IllegalAccessException, DatabaseException, InvocationTargetException {
        String fullClassname = entityClass.getName();
        String className = entityClass.getSimpleName();

        String selectedFields = "SELECT ";

        for (String field : fields) {
            selectedFields = selectedFields + ", " + entityPrefix + "." + field;
        }

        selectedFields = selectedFields + " FROM " + className + " " + entityPrefix;

        Query query = getEntityManager().createQuery(selectedFields);
        List<Object[]> objects = query.getResultList();

        List<T> results = NativeQueryResultsMapper.map(objects, fields, entityClass);

        return results;
    }

    /**
     * Find all the given fields of all the T objects in the database
     *
     * @param fields
     * @return objects
     * @throws IllegalAccessException
     * @throws DatabaseException
     * @throws InvocationTargetException
     */
    public List<T> getDataByCriteria(List<String> fields) throws IllegalAccessException, DatabaseException, InvocationTargetException {
        return getDataByCriteria(QUERY_PREFIX, fields);
    }

    /**
     * Find all the given fields of all the T objects in the database matching
     * the given criteria list, page and size
     *
     * @param criterias
     * @param entityPrefix
     * @param fields
     * @param page
     * @param size
     * @return objects
     * @throws IllegalAccessException
     * @throws DatabaseException
     * @throws InvocationTargetException
     */
    public List<T> getDataByCriteria(Criterias criterias, String entityPrefix, List<String> fields, int page, int size) throws IllegalAccessException, DatabaseException, InvocationTargetException {
        criterias.setEntityClass(entityClass);

        String request = criterias.getAsStringQuery(entityPrefix);
        String className = entityClass.getSimpleName();

        String selectedFields = "SELECT ";

        for (String field : fields) {
            selectedFields = selectedFields + ", " + entityPrefix + "." + field;
        }

        selectedFields = selectedFields + " FROM " + className + " " + entityPrefix + " WHERE " + request;

        Query query = getEntityManager().createQuery(selectedFields);
        query.setFirstResult(page);
        query.setMaxResults(size);
        List<Object[]> objects = query.getResultList();

        List<T> results = NativeQueryResultsMapper.map(objects, fields, entityClass);

        return results;
    }

    /**
     * Find all the given fields of all the T objects in the database matching
     * the given criteria list, page and size
     *
     * @param criterias
     * @param fields
     * @param page
     * @param size
     * @return objects
     * @throws IllegalAccessException
     * @throws DatabaseException
     * @throws InvocationTargetException
     */
    public List<T> getDataByCriteria(Criterias criterias, List<String> fields, int page, int size) throws IllegalAccessException, DatabaseException, InvocationTargetException {
        criterias.setEntityClass(entityClass);

        return getDataByCriteria(criterias, QUERY_PREFIX, fields, page, size);
    }

    /**
     * Get the repository entity class
     *
     * @return the repository entity class
     */
    public Class getEntityClass() {
        return entityClass;
    }

    /**
     * Set the repository entity class
     * @param entityClass the entity class to set
     */
    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Get the repository entity manager factory
     * @return the repository entity manager factory
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * Set the repository entity manager factory
     * @param emf the entity manager factory to set
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Set the repository entity manager
     * @param em the entity manager to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * Get the repository persistence unit name
     * @return the persistence unit name
     */
    public String getPersistUnit() {
        return persistUnit;
    }

}
