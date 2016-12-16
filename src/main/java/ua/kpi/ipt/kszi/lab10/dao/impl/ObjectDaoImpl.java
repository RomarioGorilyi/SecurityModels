package ua.kpi.ipt.kszi.lab10.dao.impl;

import ua.kpi.ipt.kszi.lab10.dao.ObjectDao;
import ua.kpi.ipt.kszi.lab10.domain.Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Roman Horilyi
 */
public class ObjectDaoImpl implements ObjectDao {

    private Connection connection;

    public ObjectDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object getObject(String objectName) {
        Object object = null;

        try {
            String query = "SELECT * FROM objects WHERE NAME = ?";
            PreparedStatement select = connection.prepareStatement(query);
            select.setString(1, objectName);
            ResultSet resultSet = select.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int level = resultSet.getInt("level");

                object = new Object(name, level);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return object;
    }

    @Override
    public void updateObjectByName(String objectName, String newName) {
        try {
            String query = "UPDATE objects SET NAME = ? WHERE NAME = ?";
            PreparedStatement update = connection.prepareStatement(query);
            update.setString(1, newName);
            update.setString(2, objectName);

            update.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
