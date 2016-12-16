package ua.kpi.ipt.kszi.lab10.controller.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.kpi.ipt.kszi.lab10.dao.factory.DaoFactory;
import ua.kpi.ipt.kszi.lab10.domain.Subject;

/**
 * @author Roman Horilyi
 */
@Data
@AllArgsConstructor
public abstract class SecurityController {

    private DaoFactory daoFactory;

    public abstract String readObject(String objectName, Subject user);

    public abstract String updateObject(String objectName, String newName, Subject user);
}
