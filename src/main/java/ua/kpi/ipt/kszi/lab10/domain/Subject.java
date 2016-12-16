package ua.kpi.ipt.kszi.lab10.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Roman Horilyi
 */
@Data
@AllArgsConstructor
public class Subject {

    private String username;
    private String password;
    private int level;
}
