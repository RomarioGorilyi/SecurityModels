package ua.kpi.ipt.kszi.lab10.dao;

import ua.kpi.ipt.kszi.lab10.domain.Subject;

/**
 * @author Roman Horilyi
 */
public interface SubjectDao {

    public Subject getSubject(String subjectName);

    public void createSubject(Subject subject);
}
