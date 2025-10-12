package VerificationProcess;
import java.sql.*;
import java.util.Scanner;
import DBConnection.DAO;
import Models.Faculty;

public class AthunticationProcess {
	
	public static String FacultyID;

	public static void Forfaculty(DAO dao, Scanner input) throws SQLException  {
		
		Connection con = dao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String Query = "SELECT * FROM Faculty WHERE FacultyID = ? AND FacultyPass = ?;";
		pst = con.prepareStatement(Query);
		System.out.println("\nPlease enter your credentials to continue\n");
		System.out.print("Enter ID         : ");
		FacultyID = input.nextLine();
		pst.setString(1, FacultyID);
		System.out.print("Enter Password   : ");
		String FacultyPass = input.nextLine();
		pst.setString(2, FacultyPass);
		
		rs = pst.executeQuery();
		rs.next();
		
		System.out.println("\nWelcome "+rs.getString(3)+" ("+rs.getString(5)+")\n");
		Faculty.FacultyDashboard(dao, input);
	}
}
