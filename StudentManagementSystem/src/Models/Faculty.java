package Models;

import java.sql.*;
import DBConnection.DAO;
import HelperClasses.Helper;
import VerificationProcess.AthunticationProcess;
import java.util.Scanner;

public class Faculty {

	// Displaying Students Details
	public static void DisplayStudents(DAO dao) throws SQLException {
		
		String Query = "SELECT * FROM Student";
		Connection con = dao.getConnection();
		
			Statement pst = con.createStatement();
			ResultSet rs = pst.executeQuery(Query);
			System.out
					.println("\n                           ==================== Students Details ====================");
			System.out.println(
					"             +-------------------- B.Tech Infromation Technology 2022-26 --------------------+");
			System.out.printf(
					"+-----------+----------------+---------------------+------------+--------+-------------+---------+---------------------------+%n");
			System.out.printf(
					"| StudentID | RollNo         | Name                | Department | Batch  | DOB         | Gender  | Email                     |%n");
			System.out.printf(
					"+-----------+----------------+---------------------+------------+--------+-------------+---------+---------------------------+%n");
			while (rs.next()) {
				System.out.printf("| %-9d | %-14s | %-19s | %-10s | %-6d | %-11s | %-7s | %-25s |%n", rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6),
						rs.getString(7), rs.getString(8));
				System.out.printf(
						"+----------------------------------------------------------------------------------------------------------------------------+%n");
			}
		con.close();
	}

	// Add new Student
	public static void AddNewStudent(DAO dao, Scanner input) throws SQLException {

		String Query = "INSERT INTO Student (RollNo, Name, Department, Batch, DOB, Gender, Email,StudentID) "
				+ "VALUES (?,?, ?, ?, ?, ?, ?, ?)";

		Connection con = dao.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(Query);
			System.out.println("=========== Student Details ===========\n");
			System.out.print("Enter Roll Number: ");
			String rollNo = input.nextLine();
			System.out.print("Enter Name: ");
			String name = input.nextLine();
			System.out.print("Enter Department: ");
			String dept = input.nextLine();
			System.out.print("Enter Year: ");
			int year = input.nextInt();
			input.nextLine();
			System.out.print("Enter Date of Birth (dd/mm/yyyy): ");
			String dob = input.nextLine();
			System.out.print("Enter Gender: ");
			String gender = input.nextLine();
			System.out.print("Enter Email: ");
			String email = input.nextLine();
			String StudentID = rollNo.substring(9,12);
			pst.setString(1, rollNo);
			pst.setString(2, name);
			pst.setString(3, dept);
			pst.setInt(4, year);
			pst.setString(5, dob);
			pst.setString(6, gender);
			pst.setString(7, email);
			pst.setInt(8, Integer.parseInt(StudentID));
			int rows = pst.executeUpdate();
			System.out.println(rows + " row(s) affected");
			pst.close();
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		con.close();
	}

	// Remove Student
	public static void RemoveExistingStudent(DAO dao, Scanner input) throws SQLException {

		Connection con = dao.getConnection();

		String Query = "DELETE FROM Student WHERE StudentID = ?";

		try {
			PreparedStatement pst = con.prepareStatement(Query);
			int StudentID = input.nextInt();
			pst.setInt(1, StudentID);
			int rows = pst.executeUpdate();
			System.out.println(rows + "(s) affected");
			pst.close();
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		con.close();
	}

	// Update Student Details
	public static void UpdateStudent(DAO dao, Scanner input) throws SQLException {
		Connection con = dao.getConnection();
		try {
			String checkQuery = "SELECT COUNT(*) FROM Student WHERE StudentID = ?";
			PreparedStatement checkStmt = con.prepareStatement(checkQuery);
			System.out.print("Enter StudentID : ");
			int studentId = input.nextInt();
			checkStmt.setInt(1, studentId);
			ResultSet rs = checkStmt.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				System.out.println("Invalid Student ID: " + studentId);
				return;
			}
			System.out.println("Which column do you want to update?");
			System.out.println("1.RollNo");
			System.out.println("2. Name");
			System.out.println("3. Department");
			System.out.println("4. Batch");
			System.out.println("5. DOB");
			System.out.println("6. Gender");
			System.out.println("7. Email");
			System.out.print("Enter Column No : ");

			int choice = input.nextInt();
			input.nextLine();

			String column = null;
			switch (choice) {
			case 1:
				column = "RollNo";
				break;
			case 2:
				column = "Name";
				break;
			case 3:
				column = "Department";
				break;
			case 4:
				column = "Batch";
				break;
			case 5:
				column = "DOB";
				break;
			case 6:
				column = "Gender";
				break;
			case 7:
				column = "Email";
				break;
			default:
				System.out.println("Invalid choice!");
				return;
			}

			String query = "UPDATE Student SET " + column + " = ? WHERE StudentID = ?";
			PreparedStatement pst = con.prepareStatement(query);

			System.out.print("Enter New Value : ");
			String newValue = input.nextLine();
			if (choice == 3)
				pst.setInt(1, Integer.parseInt(newValue));
			else
				pst.setString(1, newValue);
			pst.setInt(2, studentId);
			int rows = pst.executeUpdate();
			if (rows > 0)
				System.out.println(rows + " row(s) affected");
			else
				System.out.println("Update failed!");
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		con.close();
	}

	// View Faculty Detail
	public static void ViewProfile(DAO dao) throws SQLException {
		Connection con = dao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String Query = "SELECT * FROM Faculty WHERE FacultyID = ?";
		pst = con.prepareStatement(Query);
		pst.setString(1, AthunticationProcess.FacultyID);
		rs = pst.executeQuery();
		rs.next();
		System.out.println(
				"+-----------------+----------------------+-----------------+-----------------+------------+--------+-----------------------------------+");
		System.out.println(
				"| FacultyID       | Name                 | Department      | Designation     | DOB        | Gender | Email                             |");
		System.out.println(
				"+-----------------+----------------------+-----------------+-----------------+------------+--------+-----------------------------------+");
		System.out.printf("| %-15d | %-20s | %-15s | %-15s | %-10s | %-6s | %-33s |\n", rs.getLong(2), rs.getString(3),
				rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
		System.out.println(
				"+--------------------------------------------------------------------------------------------------------------------------------------+");
	}

	// FacultyDashboard
	public static void FacultyDashboard(DAO dao , Scanner input) throws SQLException {

		boolean FacultyDashboard = true;
		while (FacultyDashboard) {
			Helper.FacultyDashBoard();
			System.out.print("Enter your Choice : ");
			int choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				ViewProfile(dao);
				break;
			case 2:
				DisplayStudents(dao);
				break;
			case 3:
				UpdateStudent(dao, input);
				break;
			case 4:
				AddNewStudent(dao, input);
				break;
			case 5:
				RemoveExistingStudent(dao, input);
				break;
			case 6:
				FacultyDashboard = false;
				break;
			}
		}

	}
}
