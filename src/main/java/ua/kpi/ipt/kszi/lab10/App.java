package ua.kpi.ipt.kszi.lab10;

import ua.kpi.ipt.kszi.lab10.controller.security.BellaLaPadulaController;
import ua.kpi.ipt.kszi.lab10.controller.security.BibaController;
import ua.kpi.ipt.kszi.lab10.controller.security.LatticeController;
import ua.kpi.ipt.kszi.lab10.dao.factory.MySqlDaoFactory;
import ua.kpi.ipt.kszi.lab10.domain.Subject;
import ua.kpi.ipt.kszi.lab10.representation.Representation;

import java.util.Scanner;

/**
 * @author Roman Horilyi
 */
public class App {

    public static void main(String[] args) {
        Representation representation = new Representation();

        MySqlDaoFactory.makeConnection();

        Subject user = representation.authenticateUser();

        int counter;
        do {
            System.out.print("Enter 1 if you want to work with objects (BellaLaPadula): ");
            Scanner sc = new Scanner(System.in);
            counter = 0;
            if (Integer.parseInt(sc.next()) == 1) {
                representation.manipulateObjects(user, new BellaLaPadulaController(MySqlDaoFactory.getInstance()));
                counter++;
            }
        } while (counter > 0);

        do {
            System.out.print("Enter 1 if you want to work with objects (Biba): ");
            Scanner sc = new Scanner(System.in);
            counter = 0;
            if (Integer.parseInt(sc.next()) == 1) {
                representation.manipulateObjects(user, new BibaController(MySqlDaoFactory.getInstance()));
                counter++;
            }
        } while (counter > 0);

        do {
            System.out.print("Enter 1 if you want to work with objects (Lattice): ");
            Scanner sc = new Scanner(System.in);
            counter = 0;
            if (Integer.parseInt(sc.next()) == 1) {
                representation.manipulateObjects(user, new LatticeController(MySqlDaoFactory.getInstance()));
                counter++;
            }
        } while (counter > 0);

        MySqlDaoFactory.disconnect();
    }
}
