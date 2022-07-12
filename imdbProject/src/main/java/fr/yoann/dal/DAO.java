package fr.yoann.dal;

public interface DAO<T> {
    void addObject(T t) throws DALException;
}
