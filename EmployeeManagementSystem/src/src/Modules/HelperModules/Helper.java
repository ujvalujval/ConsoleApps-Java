package src.Modules.HelperModules;

public class Helper {

    // Start Helper
    public static void StartHelper() {
        System.out.println("Select your Role:");
        System.out.println("1 - Employee");
        System.out.println("2 - Manager");
        System.out.println("3 - CEO");
        System.out.println("4 - Exit\n");
    }

    // Employe DashBoard
    public static void EmployeeHelper() {
         System.out.println("========== Employee Dashboard ==========");
        System.out.println("1 - View Profile");
        System.out.println("2 - Edit Profile");
        System.out.println("3 - View Assigned Tasks");
        System.out.println("4 - View All Employees");
        System.out.println("5 - Logout\n");
    }

    // Manager DashBoard
    public static void ManagerHelper() {
        System.out.println("========== Manager Dashboard ==========");
        System.out.println("1 - View profile");
        System.out.println("2 - Edit Profile");
        System.out.println("3 - View All Employees");
        System.out.println("4 - Assign Tasks to Employees");
        System.out.println("5 - View Your Tasks");
        System.out.println("6 - Logout\n");
    }

    // CEO DashBoard
    public static void CEOHelper() {
        System.out.println(" =========== CEO Dashboard ===========");
        System.out.println("1 - View Profile");
        System.out.println("2 - Edit Profile");
        System.out.println("3 - View All Employees");
        System.out.println("4 - Hire / Fire Employee");
        System.out.println("5 - Assign Tasks to Employees");
        System.out.println("6 - Logout\n");
    }

    // Employee Management
    public static void EmployeeManagement() {
        System.out.println("1 - Add a new Employee");
        System.out.println("2 - Remove a existing Employee\n");
    }
}