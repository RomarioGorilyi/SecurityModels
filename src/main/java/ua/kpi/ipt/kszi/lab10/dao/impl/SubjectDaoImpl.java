package ua.kpi.ipt.kszi.lab10.dao.impl;

import ua.kpi.ipt.kszi.lab10.dao.SubjectDao;
import ua.kpi.ipt.kszi.lab10.domain.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Roman Horilyi
 */
public class SubjectDaoImpl implements SubjectDao {

    private Connection connection;

    public SubjectDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Subject getSubject(String subjectName) {
        Subject subject = null;

        try {
            String query = "SELECT * FROM subjects WHERE username = ?";
            PreparedStatement select = connection.prepareStatement(query);
            select.setString(1, subjectName);
            ResultSet resultSet = select.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int level = resultSet.getInt("level");

                subject = new Subject(username, password, level);

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return subject;
    }

    @Override
    public void createSubject(Subject object) {
        try {
            String query = "INSERT INTO subjects (username, password, level) VALUES (?, ?, ?)";
            PreparedStatement insert = connection.prepareStatement(query);
            insert.setString(1, object.getUsername());
            insert.setString(2, object.getPassword());
            insert.setInt(3, object.getLevel());
            insert.executeQuery();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
