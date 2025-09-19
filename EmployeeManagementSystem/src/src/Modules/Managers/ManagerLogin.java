package src.Modules.Managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import src.Modules.Employees.Employee;
import src.Modules.HelperModules.IDGenerator;

public class ManagerLogin {

    public static void MngrLogin(Scanner input, ArrayList<Manager> Mngrs, ArrayList<Employee> Emps,
            HashMap<String, List<String>> tasks) {
        System.out.println("\n======================= Welcome =======================\n");
        System.out.println("Please enter your manager credentials to continue.");

        boolean LoginVerify = true;
        int EnteringTimes = 0;

        while (LoginVerify) {

            System.out.print("Manager ID   : ");
            String MngrID = input.nextLine();

            if (IDGenerator.findManagerById(MngrID, Mngrs) != null)
                LoginVerify = false;
            else {
                EnteringTimes++;
                if (EnteringTimes <= 2)
                    System.out.println(
                            "Invalid Manager ID. Please try again.\n");
                else if (EnteringTimes == 3) {
                    System.out.println("Invalid Manager ID.\n");
                    System.out.println("Enter 1 to Retry");
                    System.out.println("Enter 2 to Exit");
                    System.out.print("Choice : ");
                    int moveforward = input.nextInt();
                    input.nextLine();
                    if (moveforward == 2) {
                        System.out.println("============================ Thank you ============================");
                        LoginVerify = false;
                    } else
                        EnteringTimes = 0;
                }
            }
            if (IDGenerator.findManagerById(MngrID, Mngrs) != null) {
                String password = MngrID + IDGenerator.PasswordGenerator_M();
                System.out.print("Password     : ");
                String MngrPassword = input.nextLine();
                int PasswordVerify = 1;
                boolean check = true;
                while (!password.equalsIgnoreCase(MngrPassword)) {
                    PasswordVerify++;
                    System.out.println("PassWord incorrect! try again\n");
                    System.out.print("Enter your password : ");
                    MngrPassword = input.nextLine();
                    if (PasswordVerify == 3) {
                        System.out.println("To many attempts, try again later..\n");
                        System.out.println("============================ Main Menu ============================\n");
                        check = false;
                        break;
                    }
                }
                if (check) {
                    System.out.println("\nLogin successful!");
                    System.out.println("Welcome, Manager " + IDGenerator.MngrName + "\n");
                    ManagerDisplay.getDetails(input, IDGenerator.OriginalMngrID, Mngrs, Emps, tasks);
                    break;
                }
            }
        }
    }
}