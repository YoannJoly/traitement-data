package fr.yoann.dal.jpa;

import fr.yoann.dal.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.logging.Level;

public class ObjectJpaImpl implements DAO<Object> {
    public void addObject(Object obj) {
        //java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("pu_data");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
