package src.Modules.Employees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import src.Modules.HelperModules.Helper;
import src.Modules.HelperModules.IDGenerator;
import src.Modules.PreLoaderDB.Preloader;

public class EmployeeDisplay {

    // Employe Profile Editable
    protected static void EditEmployeeDetails(Scanner input, String OneTimeEmpID, ArrayList<Employee> Emp) {
        boolean editVerify = true;
        while (editVerify) {
            System.out.print("Enter your EmpID: ");
            String empID = input.nextLine();
            boolean found = false;
            for (Employee em : Emp) {
                if (em.getID().equals(empID)) {
                    System.out.print("Enter Name: ");
                    String newName = input.nextLine();
                    System.out.print("Enter PhoneNo: ");
                    String newPhoneNo = input.nextLine();
                    System.out.print("Enter Qualification: ");
                    String newQualify = input.nextLine();
                    em.setName(newName);
                    em.setPhoneNo(newPhoneNo);
                    em.setQualification(newQualify);
                    System.out.println(
                            "                                    =============== Profile Updated ===============");
                    EmployeeProfile(OneTimeEmpID, Emp);
                    found = true;
                    editVerify = false;
                    break;
                }
            }
            if (!found)
                System.out.println("Invalid EmpID. Please try again.\n");
        }
    }

    // Employee Display
    protected static void EmployeeProfile(String OneTimeEmpID, ArrayList<Employee> Emp) {
        for (Employee em : Emp) {
            if (em.getID().equals(OneTimeEmpID)) {
                System.out.println(
                        "      ============================================= Employee Profile =============================================");
                Preloader.printTableHeaderFullDetails();
                em.displayFullEmployeeDetails();
                System.out.println(
                        "+-----------------------------------------------------------------------------------------------------------------------+\n");
            }
        }
    }

    // View All Employee Profiles
    protected static void EmployeeProfile(ArrayList<Employee> Emp) {
        System.out.println(
                "        ==================== Employee Profiles ====================");
        Preloader.printTableHeaderDetails();
        for (Employee em : Emp) {
            if (em.getID() != null) {
                em.displayEmployeeDetails();
                System.out.println(
                        "+------------------------------------------------------------------------------+");
            }
        }
        System.err.println();
    }

    // Taks visiting
    protected static void viewingMyTask(String EmpID, HashMap<String, List<String>> tasks) {
        if (EmpID.startsWith("Em"))
            System.out.println("Employee: " + IDGenerator.EmpName);
        if (EmpID.startsWith("Mng"))
            System.out.println("Manager: " + IDGenerator.MngrName);

        System.out.println("\n \t\t\t==================== Your Task Box ====================");

        String line = "+-------+------------------------------------------------------------------------------------------------------+";
        List<String> listOfTasks = tasks.get(EmpID);

        if (listOfTasks != null && !listOfTasks.isEmpty()) {
            System.out.println(line);
            System.out.printf("| %-5s | %-100s |\n", "No.", "Task");
            System.out.println(line);
            int nums = 1;
            for (String val : listOfTasks) {
                System.out.printf("| %-5d | %-100s |\n", nums++, val);
            }
            System.out.println(line);
        } else {
            System.out.println(line);
            System.out.printf("| %-5s | %-100s |\n", "", "No Task Assigned");
            System.out.println(line);
        }
        System.out.print("Enter 1 to go-back: ");
    }

    // Employeee Details Display
    protected static void getEmployeeDetails(Scanner input, String OneTimeEmpID, ArrayList<Employee> Emp,
            HashMap<String, List<String>> tasks) {

        boolean EmpStatus = true;
        while (EmpStatus) {
            Helper.EmployeeHelper();
            System.out.print("Enter your choice: ");
            int EmpChoice = input.nextInt();
            System.out.println("\n");
            switch (EmpChoice) {
                case 1:
                    EmployeeProfile(OneTimeEmpID, Emp);
                    break;
                case 2:
                    input.nextLine();
                    EditEmployeeDetails(input, OneTimeEmpID, Emp);
                    break;
                case 3:
                    viewingMyTask(OneTimeEmpID, tasks);
                    int confirm = input.nextInt();
                    if (confirm == 1) {
                        System.out.println("\n");
                        break;
                    }
                case 4:
                    EmployeeProfile(Emp);
                    break;
                case 5:
                    EmpStatus = false;
                    System.out.println("============================ Thank you ============================\n");
                    break;
            }
        }
    }
}