package src.Modules.Managers;

import src.Modules.InterfacesEnums.IemployeeDetails;

public class Manager implements IemployeeDetails {

    private String Name;
    private String ID;
    private String PhoneNo;
    private String Qualification;
    private String Resignation;
    private String DutyTiming;
    private String Salary;
    private String CreditedOrNot;

    public String getM_Name() {
        return Name;
    }

    public Manager(String name, String iD, String phoneNo, String qualification, String resignation, String dutyTiming,
            String salary, String creditedOrNot) {
        Name = name;
        ID = iD;
        PhoneNo = phoneNo;
        Qualification = qualification;
        Resignation = resignation;
        DutyTiming = dutyTiming;
        Salary = salary;
        CreditedOrNot = creditedOrNot;
    }

    public Manager() {
    }

    public void setM_Name(String name) {
        Name = name;
    }

    public String getM_ID() {
        return ID;
    }

    public void setM_ID(String iD) {
        ID = iD;
    }

    public String getM_PhoneNo() {
        return PhoneNo;
    }

    public void setM_PhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getM_Qualification() {
        return Qualification;
    }

    public void setM_Qualification(String qualification) {
        Qualification = qualification;
    }

    public String getM_Resignation() {
        return Resignation;
    }

    public void setM_Resignation(String resignation) {
        Resignation = resignation;
    }

    public String getM_DutyTiming() {
        return DutyTiming;
    }

    public void setM_DutyTiming(String dutyTiming) {
        DutyTiming = dutyTiming;
    }

    public String getM_Salary() {
        return Salary;
    }

    public void setM_Salary(String salary) {
        Salary = salary;
    }

    public String getM_CreditedOrNot() {
        return CreditedOrNot;
    }

    public void setM_CreditedOrNot(String creditedOrNot) {
        CreditedOrNot = creditedOrNot;
    }

    public void displayEmployeeDetails() {

    }

    public void displayEmployeeSalaryDetails() {

    }

    // Manager Details
    public void displayFullEmployeeDetails() {
        System.out.printf("| %-8s | %-15s | %-12s | %-15s | %-19s | %-14s | %-8s | %-10s |\n" +
                "",
                getM_ID(), getM_Name(), getM_PhoneNo(), getM_Qualification(), getM_Resignation(),
                getM_DutyTiming(), getM_Salary(), getM_CreditedOrNot());
    }
}
