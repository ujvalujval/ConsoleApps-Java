package src.Modules.CEOs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import src.Modules.Employees.Employee;
import src.Modules.HelperModules.IDGenerator;
import src.Modules.Managers.Manager;

public class ceoLogin {

    public static void CEOLogin(Scanner input, ArrayList<Employee> Emps, ArrayList<Manager> Mngrs, ArrayList<ceo> ceos,
            HashMap<String, List<String>> tasks) {

        System.out.println("\n======================= Welcome =======================\n");
        System.out.println("Please enter your CEO credentials to continue.\n");

        boolean LoginVerify = true;
        int EnteringTimes = 0;

        while (LoginVerify) {

            System.out.print("CEO ID      : ");
            String CEOID = input.nextLine();

            if (IDGenerator.findCEOById(CEOID, ceos) != null)
                LoginVerify = false;
            else {
                EnteringTimes++;
                if (EnteringTimes <= 2)
                    System.out.println(
                            "Invalid CEO ID. Please try again.\n");
                else if (EnteringTimes == 3) {
                    System.out.println("\nInvalid CEO ID.");
                    System.out.println("Enter 1 to Retry");
                    System.out.println("Enter 2 to Exit");
                    System.out.println("Choice: ");
                    int moveforward = input.nextInt();
                    input.nextLine();
                    if (moveforward == 2) {
                        System.out.println("\n============================ Thank you ============================\n");
                        LoginVerify = false;
                    } else
                        EnteringTimes = 0;
                }
            }
            if (IDGenerator.findCEOById(CEOID, ceos) != null) {
                String password = IDGenerator.PasswordGenerator_C();
                System.out.print("Password    : ");
                String CEOPassword = input.nextLine();
                int PasswordVerify = 1;
                boolean check = true;
                while (!password.equalsIgnoreCase(CEOPassword)) {
                    PasswordVerify++;
                    System.out.println("Incorrect password. Please try again\n");
                    System.out.print("Enter your password : ");
                    CEOPassword = input.nextLine();
                    if (PasswordVerify == 3) {
                        System.out.println("Too many failed attempts. Please try again later.\n");
                        System.out.println("============================ Main Menu ============================\n");
                        check = false;
                        break;
                    }
                }
                if (check) {
                    System.out.println("\nLogin successful!");
                    System.out.println("Welcome, CEO " + IDGenerator.CEOName + "\n");
                    ceoDisplay.getDisplayDetails(input, Emps, Mngrs, ceos, tasks, CEOID);
                    break;
                }
            }
        }
    }
}