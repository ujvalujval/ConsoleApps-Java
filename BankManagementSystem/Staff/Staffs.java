package Staff;

public class Staffs {
    
    private String UserID;
    private String staffName;
    private String Password;

    public String getUserID() {
        return UserID;
    }
    public void setUserID(String userID) {
        UserID = userID;
    }
    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }

    public Staffs(String userID, String staffName, String password) {
        UserID = userID;
        this.staffName = staffName;
        Password = password;
    }
}