package src.Modules.Managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import src.Modules.Employees.Employee;
import src.Modules.Employees.EmployeeDisplay;
import src.Modules.HelperModules.Helper;
import src.Modules.HelperModules.IDGenerator;
import src.Modules.PreLoaderDB.Preloader;

public class ManagerDisplay extends EmployeeDisplay {

    // Managers Profile
    protected static void ManagerProfile(String OneTimeMngrID, ArrayList<Manager> mngrs) {
        for (Manager mg : mngrs) {
            if (mg.getM_ID().equals(OneTimeMngrID)) {
                System.out.println(
                        "     ============================================= Manager Profile =============================================");
                Preloader.printTableHeaderManagerDetails();
                mg.displayFullEmployeeDetails();
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------------\n");
            }
        }
    }

    // Edit Manager Profile
    protected static void EditManagerDetails(Scanner input, String OneTimeMngrID, ArrayList<Manager> Mngrs) {
        boolean editVerify = true;
        while (editVerify) {
            System.out.print("Enter your MngrID: ");
            String MngrID = input.nextLine();
            boolean found = false;
            for (Manager mg : Mngrs) {
                if (mg.getM_ID().equals(MngrID)) {
                    System.out.print("Enter Name: ");
                    String newName = input.nextLine();
                    System.out.print("Enter PhoneNo: ");
                    String newPhoneNo = input.nextLine();
                    System.out.print("Enter Qualification: ");
                    String newQualify = input.nextLine();
                    mg.setM_Name(newName);
                    mg.setM_PhoneNo(newPhoneNo);
                    mg.setM_Qualification(newQualify);
                    System.out.println(
                            "                                    =============== Profile Updated ===============");
                    ManagerProfile(OneTimeMngrID, Mngrs);
                    found = true;
                    editVerify = false;
                    break;
                }
            }
            if (!found)
                System.out.println("Invalid MngrID. Please try again.\n");
        }
    }

    // View All Employees
    protected static void EmployeeProfile(ArrayList<Employee> Emp) {
        System.out.println(
                "      ============================================= Employee Profiles =============================================");
        Preloader.printTableHeaderFullDetails();
        for (Employee em : Emp) {
            if (em.getID() != null) {
                em.displayFullEmployeeDetails();
                System.out.println(
                        "-------------------------------------------------------------------------------------------------------------------------");
            }
        }
        System.err.println();
    }

    // View All Managers Profiles
    protected static void ManagersProfiles(ArrayList<Manager> Mangs) {
        System.out.println(
                "     ============================================= Manager Profiles =============================================");
        Preloader.printTableHeaderManagerDetails();
        for (Manager mg : Mangs) {
            mg.displayFullEmployeeDetails();
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------");
        }
        System.out.println();
    }

    // Tasks assign to Employees
    protected static void AssignTasks(Scanner input, HashMap<String, List<String>> tasks, ArrayList<Employee> Emps) {
        System.out.println("---------------- Assign Task ----------------");
        System.out.print("Enter Employee ID   : ");
        boolean CheckEmployee = true;
        int EntryPoint = 1;
        while (CheckEmployee) {
            String EmpID = input.nextLine();
            if (IDGenerator.findEmployeeById(EmpID, Emps) != null) {
                System.out.print("Enter Task          : ");
                String task = input.nextLine();
                tasks.putIfAbsent(EmpID, new ArrayList<>());
                tasks.get(EmpID).add(task);
                System.out.println("  \nTask assigned successfully to: " + IDGenerator.EmpName + "\n");
                System.out.println("Returning to Manager Dashboard...\n");

                CheckEmployee = false;
            } else {
                EntryPoint++;
                if (EntryPoint <= 4) {
                    System.out.println("Employee Not Found\n");
                    System.out.print("Enter the EmpID : ");
                } else {
                    System.out.println("To many attempts, try again later");
                    CheckEmployee = false;
                }
            }
        }
    }

    // get Managers and Employees Details
    protected static void getDetails(Scanner input, String OneTimeMngrID, ArrayList<Manager> Mngrs,
            ArrayList<Employee> Emps, HashMap<String, List<String>> tasks) {

        boolean MangStatus = true;
        while (MangStatus) {
            Helper.ManagerHelper();
            System.out.print("Enter your choice: ");
            int MngrChoice = input.nextInt();
            System.out.println("\n");
            switch (MngrChoice) {
                case 1:
                    ManagerProfile(OneTimeMngrID, Mngrs);
                    break;
                case 2:
                    input.nextLine();
                    EditManagerDetails(input, OneTimeMngrID, Mngrs);
                    break;
                case 3:
                    ManagersProfiles(Mngrs);
                    System.out.println();
                    EmployeeProfile(Emps);
                    break;
                case 4:
                    input.nextLine();
                    AssignTasks(input, tasks, Emps);
                    break;
                case 5:
                    viewingMyTask(OneTimeMngrID, tasks);
                    int confirm = input.nextInt();
                    if (confirm == 1) {
                        System.out.println("\n");
                        break;
                    }
                case 6:
                    MangStatus = false;
                    System.out.println("============================ Thank you ============================\n");
                    break;
            }
        }
    }
}