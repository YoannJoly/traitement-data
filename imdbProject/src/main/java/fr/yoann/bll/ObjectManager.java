package fr.yoann.bll;

import fr.yoann.dal.DAO;
import fr.yoann.dal.DAOFactory;

public class ObjectManager {
    private static volatile ObjectManager instance;
    private static DAO<Object> ObjectImpl;

    private ObjectManager() {
        ObjectImpl = DAOFactory.getObjectDAO();
    }

    public static ObjectManager getInstance() {
        if (instance == null) {
            synchronized (ObjectManager.class) {
                if (instance == null) {
                    instance = new ObjectManager();
                }
            }
        }
        return instance;
    }

    public void addObject(Object obj) throws BLLException {
        try {
            ObjectImpl.addObject(obj);
        } catch (Exception e) {
            throw new BLLException(e);
        }
    }
}
