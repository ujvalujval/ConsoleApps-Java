package src.Modules.HelperModules;

import java.util.ArrayList;

import src.Modules.CEOs.ceo;
import src.Modules.Employees.Employee;
import src.Modules.Managers.Manager;

public class IDGenerator {
    private static int EmployeeCount;
    private static int ManagerCount;

    public static int getEmployeeCount() {
        return ++EmployeeCount;
    }

    public static void setEmployeeCount(int n) {
        EmployeeCount = n;
    }

    public static int getManagerCount() {
        return ++ManagerCount;
    }

    public static void setManagerCount(int n) {
        ManagerCount = n;
    }

    // Employeee ID
    public static String IDGenerate_E() {
        if (EmployeeCount >= 9) {
            return "Emp" + getEmployeeCount();
        }
        return "Emp0" + getEmployeeCount();
    }

    // Employee Password
    public static String PasswordGenerator_E() {
        return "123@";
    }

    public static String EmpName, OriginalEmpID;

    // Seareching Employee
    public static String findEmployeeById(String empId, ArrayList<Employee> Emp) {
        for (Employee emp : Emp) {
            if (emp.getID().equals(empId)) {
                EmpName = emp.getName();
                OriginalEmpID = empId;
                return empId;
            }
        }
        return null;
    }

    // Manager ID
    public static String IDGenerate_M() {
        if (ManagerCount >= 9) {
            return "Mngr" + getManagerCount();
        }
        return "Mngr0" + getManagerCount();
    }

    // Manager Password
    public static String PasswordGenerator_M() {
        return "@123";
    }

    public static String MngrName, OriginalMngrID;

    // Searching Manager
    public static String findManagerById(String MngrID, ArrayList<Manager> MNgrs) {
        for (Manager Mng : MNgrs) {
            if (Mng.getM_ID().equals(MngrID)) {
                MngrName = Mng.getM_Name();
                OriginalMngrID = MngrID;
                return MngrID;
            }
        }
        return null;
    }

    // CEO ID
    public static String IDGenerate_C() {
        return "Texes@CEO01";
    }

    // CEO Password
    public static String PasswordGenerator_C() {
        return "Texes@123";
    }

    public static String CEOName, OriginalCEOID;

    // Searching CEO
    public static String findCEOById(String CEOID, ArrayList<ceo> ceos) {
        for (ceo c : ceos) {
            if (c.getID().equals(CEOID)) {
                CEOName = c.getName();
                OriginalCEOID = CEOID;
                return CEOID;
            }
        }
        return null;
    }
}