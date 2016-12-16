package ua.kpi.ipt.kszi.lab10.dao;

import ua.kpi.ipt.kszi.lab10.domain.Object;

/**
 * @author Roman Horilyi
 */
public interface ObjectDao {

    public Object getObject(String objectName);

    public void updateObjectByName(String objectName, String newName);
}
