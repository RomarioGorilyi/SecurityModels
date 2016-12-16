package ua.kpi.ipt.kszi.lab10.representation;

import ua.kpi.ipt.kszi.lab10.controller.authentication.AuthenticationController;
import ua.kpi.ipt.kszi.lab10.controller.security.SecurityController;
import ua.kpi.ipt.kszi.lab10.dao.factory.MySqlDaoFactory;
import ua.kpi.ipt.kszi.lab10.domain.Subject;

import java.util.Scanner;

/**
 * @author Roman Horilyi
 */
public class Representation {

    public Subject authenticateUser() {
        AuthenticationController controller = new AuthenticationController(MySqlDaoFactory.getInstance());

        System.out.println("* Sign in - 1");
        System.out.println("* Register - 2");

        System.out.print("Enter the number of command > ");
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        while (!command.matches("^[1-2]$")) {
            System.out.println("\nError. You inserted invalid number.");
            System.out.print("Please, try again > ");
            command = sc.next();
        }
        int commandNumber = Integer.parseInt(command);

        switch (commandNumber) {
            case 1:
                System.out.println("Username: ");
                String username = sc.next();
                System.out.println("Password: ");
                String password = sc.next();
                return controller.signInUser(username, password);
            case 2:
                System.out.println("Username: ");
                username = sc.next();
                System.out.println("Password: ");
                password = sc.next();
                System.out.println("Level: ");
                int level = Integer.parseInt(sc.next());
                return controller.createNewUser(username, password, level);
            default:
                return null;
        }
    }

    public void manipulateObjects(Subject user, SecurityController controller) {
        System.out.println("* Read object - 1");
        System.out.println("* Update object - 2");

        System.out.print("Enter the number of command > ");
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        while (!command.matches("^[1-2]$")) {
            System.out.println("\nError. You inserted invalid number.");
            System.out.print("Please, try again > ");
            command = sc.next();
        }
        int commandNumber = Integer.parseInt(command);

        switch (commandNumber) {
            case 1:
                System.out.println("Object name: ");
                String objectName = sc.next();
                System.out.println(controller.readObject(objectName, user));
                break;
            case 2:
                System.out.println("Object name: ");
                objectName = sc.next();
                System.out.println("New name: ");
                String newName = sc.next();
                System.out.println(controller.updateObject(objectName, newName, user));
                break;
            default:
                break;
        }
    }
}
