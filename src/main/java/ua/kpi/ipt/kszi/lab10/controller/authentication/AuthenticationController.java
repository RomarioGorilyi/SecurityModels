package ua.kpi.ipt.kszi.lab10.controller.authentication;

import ua.kpi.ipt.kszi.lab10.dao.SubjectDao;
import ua.kpi.ipt.kszi.lab10.dao.factory.DaoFactory;
import ua.kpi.ipt.kszi.lab10.domain.Subject;

import java.util.Optional;

/**
 * @author Roman Horilyi
 */
public class AuthenticationController {

    private DaoFactory daoFactory;

    public AuthenticationController(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Subject signInUser(String username, String password) {
        SubjectDao subjectDao = daoFactory.getSubjectDao();
        Subject user = subjectDao.getSubject(username);

        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    public Subject createNewUser(String username, String password, int level) {
        SubjectDao subjectDao = daoFactory.getSubjectDao();
        Optional<Subject> user = Optional.ofNullable(subjectDao.getSubject(username));

        Subject newUser = new Subject(username, password, level);
        if (!user.isPresent()) {
            subjectDao.createSubject(newUser);
            return newUser;
        } else {
            return null;
        }
    }
}

