package ua.kpi.ipt.kszi.lab10.controller.security;

import ua.kpi.ipt.kszi.lab10.dao.ObjectDao;
import ua.kpi.ipt.kszi.lab10.dao.factory.DaoFactory;
import ua.kpi.ipt.kszi.lab10.domain.Object;
import ua.kpi.ipt.kszi.lab10.domain.Subject;

/**
 * @author Roman Horilyi
 */
public class BellaLaPadulaController extends SecurityController {

    public BellaLaPadulaController(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public String readObject(String objectName, Subject user) {
        ObjectDao objectDao = getDaoFactory().getObjectDao();
        Object object = objectDao.getObject(objectName);

        if (user.getLevel() >= object.getLevel()) {
            return "Successful read.";
        } else {
            return "Can't read this object.";
        }
    }

    @Override
    public String updateObject(String objectName, String newName, Subject user) {
        ObjectDao objectDao = getDaoFactory().getObjectDao();
        Object object = objectDao.getObject(objectName);

        if (user.getLevel() <= object.getLevel()) {
            objectDao.updateObjectByName(objectName, newName);
            return "Successful update.";
        } else {
            return "Can't update this object.";
        }
    }
}
