package src.Modules.CEOs;

import src.Modules.InterfacesEnums.IemployeeDetails;

public class ceo implements IemployeeDetails {

    private String Name;
    private String ID;
    private String PhoneNo;
    private String Qualification;
    private String Resignation;
    private String DutyTiming;
    private String Salary;
    private String CreditedOrNot;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public String getResignation() {
        return Resignation;
    }

    public void setResignation(String resignation) {
        Resignation = resignation;
    }

    public String getDutyTiming() {
        return DutyTiming;
    }

    public void setDutyTiming(String dutyTiming) {
        DutyTiming = dutyTiming;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getCreditedOrNot() {
        return CreditedOrNot;
    }

    public void setCreditedOrNot(String creditedOrNot) {
        CreditedOrNot = creditedOrNot;
    }

    public ceo() {

    }

    public ceo(String name, String iD, String phoneNo, String qualification, String resignation, String dutyTiming,
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

    public void displayEmployeeDetails() {
    }

    public void displayEmployeeSalaryDetails() {
    }

    public void displayFullEmployeeDetails() {
        System.out.printf("| %-12s | %-15s | %-12s | %-15s | %-14s | %-14s | %-8s | %-10s |\n" +
                "",
                getID(), getName(), getPhoneNo(), getQualification(), getResignation(),
                getDutyTiming(), getSalary(), getCreditedOrNot());
    }
}