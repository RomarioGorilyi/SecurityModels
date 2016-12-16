package ua.kpi.ipt.kszi.lab10.dao.factory;

import ua.kpi.ipt.kszi.lab10.dao.ObjectDao;
import ua.kpi.ipt.kszi.lab10.dao.SubjectDao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Roman Horilyi
 */
public interface DaoFactory {

    Connection getConnection() throws SQLException;

    ObjectDao getObjectDao();

    SubjectDao getSubjectDao();
}
