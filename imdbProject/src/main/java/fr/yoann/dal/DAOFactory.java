package fr.yoann.dal;

import fr.yoann.dal.jpa.ObjectJpaImpl;

public class DAOFactory {
    public static DAO<Object> getObjectDAO() {
        return new ObjectJpaImpl();
    }
}
