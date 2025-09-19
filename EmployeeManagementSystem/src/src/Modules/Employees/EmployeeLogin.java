package src.Modules.Employees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import src.Modules.HelperModules.IDGenerator;

public class EmployeeLogin {

    public static void EmpLogin(Scanner input, ArrayList<Employee> Employees, HashMap<String, List<String>> tasks) {
        System.out.println("\n======================= Welcome =======================\n");
        System.out.println("Please enter your credentials to continue.\n");

        boolean LoginVerify = true;
        int EnteringTimes = 0;

        while (LoginVerify) {

            System.out.print("Employee ID   : ");
            String EmpID = input.nextLine();

            if (IDGenerator.findEmployeeById(EmpID, Employees) != null)
                LoginVerify = false;
            else {
                EnteringTimes++;
                if (EnteringTimes <= 2)
                    System.out.println(
                            "Employee not found. Please try again.\n");

                else if (EnteringTimes == 3) {
                    System.out.println("Employee not found.\n");
                    System.out.println("Would you like to try again?");
                    System.out.println("1 - Retry");
                    System.out.println("2 - Exit");
                    System.out.print("Choice : ");
                    int moveforward = input.nextInt();
                    input.nextLine();
                    if (moveforward == 2) {
                        System.out.println("============================ Thank you ============================\n");
                        LoginVerify = false;
                    } else
                    EnteringTimes = 0;
                }
            }
            if (IDGenerator.findEmployeeById(EmpID, Employees) != null) {
                String password = IDGenerator.PasswordGenerator_E() + EmpID;
                boolean verify = true;
                System.out.print("Password      : ");
                String EmpPassword = input.nextLine();
                int PasswordVerify = 1;
                while (!password.equalsIgnoreCase(EmpPassword)) {
                    PasswordVerify++;
                    System.out.println("Incorrect Password\n");
                    System.out.print("Password      : ");
                    EmpPassword = input.nextLine();
                    if (PasswordVerify == 3) {
                        System.out.println("To many attempts, try again later..\n");
                        System.out.println("============================ Main Menu ============================\n");
                        verify = false;
                        break;
                    }
                }
                if (verify) {
                    System.out.println("\nLogin, Succesful!");
                    System.out.println("Welcome, " + IDGenerator.EmpName + "\n");
                    EmployeeDisplay.getEmployeeDetails(input, IDGenerator.OriginalEmpID, Employees, tasks);
                    break;
                }
            }
        }
    }
}