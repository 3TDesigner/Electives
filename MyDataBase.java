import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.util.*;

public class MyDataBase
{
	//Declares instance variables
	private String dbName = "electiveDB2";
	private String connectionURL = "jdbc:derby:" + dbName + ";create = true";
	private String connectURL = "jdbc:derby:" + dbName;
	private Connection conn = null;
	private ResultSet rs = null;
	private Statement state;
	private int classSize = 24;
	
	//Creates the SQL database
	public void createDatabase(){
		try{
			conn = DriverManager.getConnection(connectionURL);
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Creates the table for the database
	public void createTable(){
		try{
			
			Statement s = conn.createStatement();
			state = s;
			state.execute("CREATE TABLE students (name varchar(50), grade int, gender varchar(50), quarter1 varchar(50),"
			+ "quarter2 varchar(50), quarter3 varchar(50), quarter4 varchar(50), tri1 varchar(50)," +
			"tri2 varchar(50), tri3 varchar(50))");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	
	//Inserts information into the database
	public void insertIntoTable(String myName, int myGrade, String myGender, String quarter1,
		String quarter2, String quarter3, String quarter4, String tri1, 
		String tri2, String tri3){

		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			state.execute("INSERT INTO students VALUES(" + "'" + myName + "'," +
				myGrade + ","  + "'" + myGender + "'," + "'" + quarter1 +"'," + "'" + quarter2 +"'," + "'" + quarter3 + "',"
				+ "'" + quarter4 + "'," + "'" + tri1 + "'," + "'" + tri2 + "'," + "'" + tri3 + "')");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Deletes a student from the database
	public void delete(String myName){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			state.execute("DELETE FROM students WHERE name = '" + myName + "'");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Updates the grade
	public void updateGrade(String myName,int myGrade){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			state.execute("UPDATE students SET grade = " + myGrade + " WHERE name = "
				+ "'"+myName+"'");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Updates the gender
	public void updateGender(String myName,String myGender){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			state.execute("UPDATE students SET gender = " + "'"+myGender +"'"+ " WHERE name = "
				+ "'"+myName+"'");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Updates Quarter 1
	public void updateQ1(String myName,String myQuarter1){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			state.execute("UPDATE students SET quarter1 = " +"'"+myQuarter1+"'" 
				+ " WHERE name = " + "'"+myName+"'");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Updates Quarter 2
	public void updateQ2(String myName,String myQuarter2){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			state.execute("UPDATE students SET quarter2 = " + "'"+myQuarter2+"'" 
				+ " WHERE name = " + "'"+myName+"'");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Updates Quarter 3
	public void updateQ3(String myName,String myQuarter3){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			state.execute("UPDATE students SET quarter3 = " +"'"+myQuarter3+"'" 
				+ " WHERE name = " + "'"+myName+"'");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Updates Quarter 4
	public void updateQ4(String myName,String myQuarter4){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			state.execute("UPDATE students SET quarter4 = " + "'"+myQuarter4+"'" 
				+ " WHERE name = " + "'"+myName+"'");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Updates Trimester 1
	public void updateT1(String myName,String myTri1){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			state.execute("UPDATE students SET tri1 = " + "'"+myTri1+"'" 
				+ " WHERE name = " + "'"+myName+"'");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Updates Trimester 2
	public void updateT2(String myName,String myTri2){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			state.execute("UPDATE students SET tri2 = " + "'"+myTri2+"'" 
				+ " WHERE name = " + "'"+myName+"'");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Updates Trimester 3
	public void updateT3(String myName,String myTri3){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			state.execute("UPDATE students SET tri3 = " + "'"+myTri3+"'" 
				+ " WHERE name = " + "'"+myName+"'");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Selects all information from the table
	public void selectTable(){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT * FROM students");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Selects the name, grade, and Quarter 1 team time from the student
	public void selectQ1(){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT name,grade,quarter1 FROM students");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Selects the name, grade, and Quarter 2 team time from the student
	public void selectQ2(){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT name,grade,quarter2 FROM students");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Selects the name, grade, and Quarter 3 team time from the student
	public void selectQ3(){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT name,grade,quarter3 FROM students");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Selects the name, grade, and Quarter 4 team time from the student
	public void selectQ4(){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT name,grade,quarter4 FROM students");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Selects the name, grade, and Trimester 1 elective from the student
	public void selectT1(){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT name,grade,tri1 FROM students");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Selects the name, grade, and Trimester 2 elective from the student
	public void selectT2(){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT name,grade,tri2 FROM students");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Selects the name, grade, and Trimester 3 elective from the student
	public void selectT3(){
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT name,grade,tri3 FROM students");
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Checks if the full name of the student is in the database
	public boolean returnName(String fullName){
		try{
			
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT * FROM students");
			while(rs.next()){
					String name = rs.getString("name");
					if(name.equals(fullName)){
						return true;
					}
			}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		return false;
	}
	
	//Checks if the first name of the student is in the database
	public boolean returnFirstName(String myFirstName){
		try{
			
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT * FROM students");
			while(rs.next()){
				String name = rs.getString("name");
				String[] fullName = name.split(" ");
				String firstName = fullName[0];
					if(firstName.equals(myFirstName)){
						return true;
					}
			}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		return false;
	}
	
	//Checks if the last name of the student is in the database
	public boolean returnLastName(String myLastName){
		try{
			
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT * FROM students");
			while(rs.next()){
				String name = rs.getString("name");
				String[] fullName = name.split(" ");
				String lastName = fullName[1];
					if(lastName.equals(myLastName)){
						return true;
					}
			}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		return false;
	}
	
	//Returns the grade of the student inserted
	public int returnGrade(String fullName){
		int grade = 0;
		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT * FROM students");
			while(rs.next()){
					String name = rs.getString("name");
					if(name.equals(fullName)){
						grade = rs.getInt("grade");	
					}
			}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		return grade;
	}
	
	//Prints everything in the table (Mainly used to check info if needed)
	public void printTable(){
		try{
			while(rs.next())
				{
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					String gender = rs.getString("gender");
					String quarter1 = rs.getString("quarter1");
					String quarter2 = rs.getString("quarter2");
					String quarter3 = rs.getString("quarter3");
					String quarter4 = rs.getString("quarter4");
					String tri1 = rs.getString("tri1");
					String tri2 = rs.getString("tri2");
					String tri3 = rs.getString("tri3");
			
					System.out.println("Result of Select Query");
					System.out.println(" | Name = " + name + " | Grade = " + grade
						+ " | Gender = " + gender + " | Q1 = " + quarter1 
						+ " | Q2 = " + quarter2 + " | Q3 = " + quarter3
						+ " | Q4 = " + quarter4 + " | T1 = " + tri1 
						+ " | T2 = " + tri2 + " | T3 = " + tri3);
				}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}

	//Closes the connection to the database
	public void closeConnection(){
		try{
			rs.close();
			conn.close();
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	//Finds the number of rows in the database
	public int findRow(){
		int rowNumber = 0;
		
		try{
			rs = state.executeQuery("SELECT * FROM students");
			
			while(rs.next())
				{
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					String gender = rs.getString("gender");
					String quarter1 = rs.getString("quarter1");
					String quarter2 = rs.getString("quarter2");
					String quarter3 = rs.getString("quarter3");
					String quarter4 = rs.getString("quarter4");
					String tri1 = rs.getString("tri1");
					String tri2 = rs.getString("tri2");
					String tri3 = rs.getString("tri3");
	
					rowNumber++;
					}
				}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		return rowNumber;	
	}
		
	//Creates the data for the JTable to use from the entire database
	public Object[][] createTableData(){
		int count = 0;
		int COL_LENGTH = 11;
		int row = findRow();
		Object[][] data = new Object[row][COL_LENGTH];
		
		try{
		rs = state.executeQuery("SELECT * FROM students");
		
			while(rs.next())
				{
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					String gender = rs.getString("gender");
					String quarter1 = rs.getString("quarter1");
					String quarter2 = rs.getString("quarter2");
					String quarter3 = rs.getString("quarter3");
					String quarter4 = rs.getString("quarter4");
					String tri1 = rs.getString("tri1");
					String tri2 = rs.getString("tri2");
					String tri3 = rs.getString("tri3");
	
					String[] fullName = name.split(" ");
					String firstName = fullName[0];
					String lastName = fullName[1];
			
					for(int i = 0; i < COL_LENGTH; i++){
						if(i == 0)
							data[count][i] = firstName;
						if(i == 1)
							data[count][i] = lastName;
						if(i == 2)
							data[count][i] = grade;
						if(i == 3)
							data[count][i] = gender;
						if(i == 4)
							data[count][i] = quarter1;
						if(i == 5)
							data[count][i] = quarter2;
						if(i == 6)
							data[count][i] = quarter3;
						if(i == 7)
							data[count][i] = quarter4;
						if(i == 8)
							data[count][i] = tri1;
						if(i == 9)
							data[count][i] = tri2;
						if(i == 10)
							data[count][i] = tri3;
					}
					count++;
				}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		//System.out.println(Arrays.deepToString(data));
		return data;
	}
	
	//Creates the data for the JTable to use from Quarter 1
	public Object[][] createQ1Data(){
		int count = 0;
		int COL_LENGTH = 10;
		int row = findRow();
		Object[][] data = new Object[row][COL_LENGTH];
		
		try{
		rs = state.executeQuery("SELECT name,grade,quarter1 FROM students");
		
			while(rs.next())
				{
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					String quarter1 = rs.getString("quarter1");
	
					String[] fullName = name.split(" ");
					String firstName = fullName[0];
					String lastName = fullName[1];
			
					for(int i = 0; i < COL_LENGTH; i++){
						if(i == 0)
							data[count][i] = firstName;
						if(i == 1)
							data[count][i] = lastName;
						if(i == 2)
							data[count][i] = grade;
						if(i == 3)
							data[count][i] = quarter1;
					}
					count++;
				}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		//System.out.println(Arrays.deepToString(data));
		return data;
	}
	
	//Creates the data for the JTable to use from Quarter 2
	public Object[][] createQ2Data(){
		int count = 0;
		int COL_LENGTH = 10;
		int row = findRow();
		Object[][] data = new Object[row][COL_LENGTH];
		
		try{
		rs = state.executeQuery("SELECT name,grade,quarter2 FROM students");
		
			while(rs.next())
				{
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					String quarter2 = rs.getString("quarter2");
	
					String[] fullName = name.split(" ");
					String firstName = fullName[0];
					String lastName = fullName[1];
			
					for(int i = 0; i < COL_LENGTH; i++){
						if(i == 0)
							data[count][i] = firstName;
						if(i == 1)
							data[count][i] = lastName;
						if(i == 2)
							data[count][i] = grade;
						if(i == 3)
							data[count][i] = quarter2;
					}
					count++;
				}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		//System.out.println(Arrays.deepToString(data));
		return data;
	}
	
	//Creates the data for the JTable to use from Quarter 3
	public Object[][] createQ3Data(){
		int count = 0;
		int COL_LENGTH = 10;
		int row = findRow();
		Object[][] data = new Object[row][COL_LENGTH];
		
		try{
		rs = state.executeQuery("SELECT name,grade,quarter3 FROM students");
		
			while(rs.next())
				{
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					String quarter3 = rs.getString("quarter3");
	
					String[] fullName = name.split(" ");
					String firstName = fullName[0];
					String lastName = fullName[1];
			
					for(int i = 0; i < COL_LENGTH; i++){
						if(i == 0)
							data[count][i] = firstName;
						if(i == 1)
							data[count][i] = lastName;
						if(i == 2)
							data[count][i] = grade;
						if(i == 3)
							data[count][i] = quarter3;
					}
					count++;
				}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		//System.out.println(Arrays.deepToString(data));
		return data;
	}
	
	//Creates the data for the JTable to use from Quarter 4
	public Object[][] createQ4Data(){
		int count = 0;
		int COL_LENGTH = 10;
		int row = findRow();
		Object[][] data = new Object[row][COL_LENGTH];
		
		try{
		rs = state.executeQuery("SELECT name,grade,quarter4 FROM students");
		
			while(rs.next())
				{
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					String quarter4 = rs.getString("quarter4");
	
					String[] fullName = name.split(" ");
					String firstName = fullName[0];
					String lastName = fullName[1];
			
					for(int i = 0; i < COL_LENGTH; i++){
						if(i == 0)
							data[count][i] = firstName;
						if(i == 1)
							data[count][i] = lastName;
						if(i == 2)
							data[count][i] = grade;
						if(i == 3)
							data[count][i] = quarter4;
					}
					count++;
				}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		//System.out.println(Arrays.deepToString(data));
		return data;
	}
	
	//Creates the data for the JTable to use from Trimester 1
	public Object[][] createT1Data(){
		int count = 0;
		int COL_LENGTH = 10;
		int row = findRow();
		Object[][] data = new Object[row][COL_LENGTH];
		
		try{
		rs = state.executeQuery("SELECT name,grade,tri1 FROM students");
		
			while(rs.next())
				{
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					String tri1 = rs.getString("tri1");
	
					String[] fullName = name.split(" ");
					String firstName = fullName[0];
					String lastName = fullName[1];
			
					for(int i = 0; i < COL_LENGTH; i++){
						if(i == 0)
							data[count][i] = firstName;
						if(i == 1)
							data[count][i] = lastName;
						if(i == 2)
							data[count][i] = grade;
						if(i == 3)
							data[count][i] = tri1;
					}
					count++;
				}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		//System.out.println(Arrays.deepToString(data));
		return data;
	}
	
	//Creates the data for the JTable to use from Trimester 2
	public Object[][] createT2Data(){
		int count = 0;
		int COL_LENGTH = 10;
		int row = findRow();
		Object[][] data = new Object[row][COL_LENGTH];
		
		try{
		rs = state.executeQuery("SELECT name,grade,tri2 FROM students");
		
			while(rs.next())
				{
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					String tri2 = rs.getString("tri2");
	
					String[] fullName = name.split(" ");
					String firstName = fullName[0];
					String lastName = fullName[1];
			
					for(int i = 0; i < COL_LENGTH; i++){
						if(i == 0)
							data[count][i] = firstName;
						if(i == 1)
							data[count][i] = lastName;
						if(i == 2)
							data[count][i] = grade;
						if(i == 3)
							data[count][i] = tri2;
					}
					count++;
				}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		//System.out.println(Arrays.deepToString(data));
		return data;
	}
	
	//Creates the data for the JTable to use from Trimester 3
	public Object[][] createT3Data(){
		int count = 0;
		int COL_LENGTH = 10;
		int row = findRow();
		Object[][] data = new Object[row][COL_LENGTH];
		
		try{
		rs = state.executeQuery("SELECT name,grade,tri3 FROM students");
		
			while(rs.next())
				{
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					String tri3 = rs.getString("tri3");
	
					String[] fullName = name.split(" ");
					String firstName = fullName[0];
					String lastName = fullName[1];
			
					for(int i = 0; i < COL_LENGTH; i++){
						if(i == 0)
							data[count][i] = firstName;
						if(i == 1)
							data[count][i] = lastName;
						if(i == 2)
							data[count][i] = grade;
						if(i == 3)
							data[count][i] = tri3;
					}
					count++;
				}
		}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		//System.out.println(Arrays.deepToString(data));
		return data;
	}
	
	/*
	All the methods below check whether an elective or team time choice is valid
	to be given to student based on class size. Acts a "first come first serve" method.
	*/
	public boolean checkQ1(String check){
		int countRobotics = 0;
		int countQuizBowl = 0;
		int countArt = 0;
		int countSpeech = 0;
		int countNewspaper = 0;
		int countContestMath = 0;
		int countDebate = 0;
		int countGeography = 0;
		boolean answer = false;

		try{
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			rs = state.executeQuery("SELECT * FROM students");
			
			while(rs.next())
				{
					String quarter1 = rs.getString("quarter1");
				
					//Checks how many students are in the class
					if(quarter1.equals("Robotics")){
						countRobotics++;
					}
					if(quarter1.equals("Quiz Bowl")){
						countQuizBowl++;
					}
					if(quarter1.equals("Art")){
						countArt++;
					}
					if(quarter1.equals("Speech")){
						countRobotics++;
					}
					if(quarter1.equals("Newspaper")){
						countQuizBowl++;
					}
					if(quarter1.equals("Contest Math")){
						countArt++;
					}
					if(quarter1.equals("Debate")){
						countRobotics++;
					}
					if(quarter1.equals("Geography")){
						countQuizBowl++;
					}
					
					
					if(check.equals("Robotics") && countRobotics <= classSize){
						answer = true;
					}else if(check.equals("Robotics") && countRobotics > classSize){
						answer = false;
					}
					
					if(check.equals("Quiz Bowl") && countQuizBowl <= classSize){
						answer = true;
					}else if(check.equals("Quiz Bowl") && countQuizBowl > classSize){
						answer = false;
					}
					
					if(check.equals("Art") && countArt <= classSize){
						answer = true;
					}else if(check.equals("Art") && countArt > classSize){
						answer = false;
					}
					
					if(check.equals("Speech") && countSpeech <= classSize){
						answer = true;
					}else if(check.equals("Speech") && countSpeech > classSize){
						answer = false;
					}
					
					if(check.equals("Newspaper") && countNewspaper <= classSize){
						answer = true;
					}else if(check.equals("Newspaper") && countNewspaper > classSize){
						answer = false;
					}
					
					if(check.equals("Contest Math") && countContestMath <= classSize){
						answer = true;
					}else if(check.equals("Contest Math") && countContestMath > classSize){
						answer = false;
					}
					
					if(check.equals("Debate") && countDebate <= classSize){
						answer = true;
					}else if(check.equals("Debate") && countDebate > classSize){
						answer = false;
					}
					
					if(check.equals("Geography") && countGeography <= classSize){
						answer = true;
					}else if(check.equals("Geography") && countGeography > classSize){
						answer = false;
					}
				}
			}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		return answer;
	}
	
	public boolean checkQ2(String check){
		int countRobotics = 0;
		int countQuizBowl = 0;
		int countArt = 0;
		int countSpeech = 0;
		int countNewspaper = 0;
		int countContestMath = 0;
		int countDebate = 0;
		int countGeography = 0;
		boolean answer = false;

		try{
			rs = state.executeQuery("SELECT * FROM students");
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			while(rs.next())
				{
					String quarter2 = rs.getString("quarter2");
				
					//Checks how many students are in the class
					if(quarter2.equals("Robotics")){
						countRobotics++;
					}
					if(quarter2.equals("Quiz Bowl")){
						countQuizBowl++;
					}
					if(quarter2.equals("Art")){
						countArt++;
					}
					if(quarter2.equals("Speech")){
						countRobotics++;
					}
					if(quarter2.equals("Newspaper")){
						countQuizBowl++;
					}
					if(quarter2.equals("Contest Math")){
						countArt++;
					}
					if(quarter2.equals("Debate")){
						countRobotics++;
					}
					if(quarter2.equals("Geography")){
						countQuizBowl++;
					}
					
					
					if(check.equals("Robotics") && countRobotics <= classSize){
						answer = true;
					}else if(check.equals("Robotics") && countRobotics > classSize){
						answer = false;
					}
					
					if(check.equals("Quiz Bowl") && countQuizBowl <= classSize){
						answer = true;
					}else if(check.equals("Quiz Bowl") && countQuizBowl > classSize){
						answer = false;
					}
					
					if(check.equals("Art") && countArt <= classSize){
						answer = true;
					}else if(check.equals("Art") && countArt > classSize){
						answer = false;
					}
					
					if(check.equals("Speech") && countSpeech <= classSize){
						answer = true;
					}else if(check.equals("Speech") && countSpeech > classSize){
						answer = false;
					}
					
					if(check.equals("Newspaper") && countNewspaper <= classSize){
						answer = true;
					}else if(check.equals("Newspaper") && countNewspaper > classSize){
						answer = false;
					}
					
					if(check.equals("Contest Math") && countContestMath <= classSize){
						answer = true;
					}else if(check.equals("Contest Math") && countContestMath > classSize){
						answer = false;
					}
					
					if(check.equals("Debate") && countDebate <= classSize){
						answer = true;
					}else if(check.equals("Debate") && countDebate > classSize){
						answer = false;
					}
					
					if(check.equals("Geography") && countGeography <= classSize){
						answer = true;
					}else if(check.equals("Geography") && countGeography > classSize){
						answer = false;
					}
				}
			}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}	
		return answer;
	}
	
	public boolean checkQ3(String check){
		int countRobotics = 0;
		int countQuizBowl = 0;
		int countArt = 0;
		int countSpeech = 0;
		int countNewspaper = 0;
		int countContestMath = 0;
		int countDebate = 0;
		int countGeography = 0;
		boolean answer = false;

		try{
			rs = state.executeQuery("SELECT * FROM students");
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			
			while(rs.next())
				{
					String quarter3 = rs.getString("quarter3");
				
					//Checks how many students are in the class
					if(quarter3.equals("Robotics")){
						countRobotics++;
					}
					if(quarter3.equals("Quiz Bowl")){
						countQuizBowl++;
					}
					if(quarter3.equals("Art")){
						countArt++;
					}
					if(quarter3.equals("Speech")){
						countRobotics++;
					}
					if(quarter3.equals("Newspaper")){
						countQuizBowl++;
					}
					if(quarter3.equals("Contest Math")){
						countArt++;
					}
					if(quarter3.equals("Debate")){
						countRobotics++;
					}
					if(quarter3.equals("Geography")){
						countQuizBowl++;
					}
					
					
					if(check.equals("Robotics") && countRobotics <= classSize){
						answer = true;
					}else if(check.equals("Robotics") && countRobotics > classSize){
						answer = false;
					}
					
					if(check.equals("Quiz Bowl") && countQuizBowl <= classSize){
						answer = true;
					}else if(check.equals("Quiz Bowl") && countQuizBowl > classSize){
						answer = false;
					}
					
					if(check.equals("Art") && countArt <= classSize){
						answer = true;
					}else if(check.equals("Art") && countArt > classSize){
						answer = false;
					}
					
					if(check.equals("Speech") && countSpeech <= classSize){
						answer = true;
					}else if(check.equals("Speech") && countSpeech > classSize){
						answer = false;
					}
					
					if(check.equals("Newspaper") && countNewspaper <= classSize){
						answer = true;
					}else if(check.equals("Newspaper") && countNewspaper > classSize){
						answer = false;
					}
					
					if(check.equals("Contest Math") && countContestMath <= classSize){
						answer = true;
					}else if(check.equals("Contest Math") && countContestMath > classSize){
						answer = false;
					}
					
					if(check.equals("Debate") && countDebate <= classSize){
						answer = true;
					}else if(check.equals("Debate") && countDebate > classSize){
						answer = false;
					}
					
					if(check.equals("Geography") && countGeography <= classSize){
						answer = true;
					}else if(check.equals("Geography") && countGeography > classSize){
						answer = false;
					}
				}
			}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		return answer;
	}
	
	public boolean checkQ4(String check){
		int countRobotics = 0;
		int countQuizBowl = 0;
		int countArt = 0;
		int countSpeech = 0;
		int countNewspaper = 0;
		int countContestMath = 0;
		int countDebate = 0;
		int countGeography = 0;
		boolean answer = false;

		try{
			rs = state.executeQuery("SELECT * FROM students");
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			
			while(rs.next())
				{
					String quarter4 = rs.getString("quarter4");
				
					//Checks how many students are in the class
					if(quarter4.equals("Robotics")){
						countRobotics++;
					}
					if(quarter4.equals("Quiz Bowl")){
						countQuizBowl++;
					}
					if(quarter4.equals("Art")){
						countArt++;
					}
					if(quarter4.equals("Speech")){
						countRobotics++;
					}
					if(quarter4.equals("Newspaper")){
						countQuizBowl++;
					}
					if(quarter4.equals("Contest Math")){
						countArt++;
					}
					if(quarter4.equals("Debate")){
						countRobotics++;
					}
					if(quarter4.equals("Geography")){
						countQuizBowl++;
					}
					
					
					if(check.equals("Robotics") && countRobotics <= classSize){
						answer = true;
					}else if(check.equals("Robotics") && countRobotics > classSize){
						answer = false;
					}
					
					if(check.equals("Quiz Bowl") && countQuizBowl <= classSize){
						answer = true;
					}else if(check.equals("Quiz Bowl") && countQuizBowl > classSize){
						answer = false;
					}
					
					if(check.equals("Art") && countArt <= classSize){
						answer = true;
					}else if(check.equals("Art") && countArt > classSize){
						answer = false;
					}
					
					if(check.equals("Speech") && countSpeech <= classSize){
						answer = true;
					}else if(check.equals("Speech") && countSpeech > classSize){
						answer = false;
					}
					
					if(check.equals("Newspaper") && countNewspaper <= classSize){
						answer = true;
					}else if(check.equals("Newspaper") && countNewspaper > classSize){
						answer = false;
					}
					
					if(check.equals("Contest Math") && countContestMath <= classSize){
						answer = true;
					}else if(check.equals("Contest Math") && countContestMath > classSize){
						answer = false;
					}
					
					if(check.equals("Debate") && countDebate <= classSize){
						answer = true;
					}else if(check.equals("Debate") && countDebate > classSize){
						answer = false;
					}
					
					if(check.equals("Geography") && countGeography <= classSize){
						answer = true;
					}else if(check.equals("Geography") && countGeography > classSize){
						answer = false;
					}
				}
			}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		return answer;
	}
	
		public boolean checkT1(String check){
		int countVillageYoutubeClub = 0;
		int countBEATS = 0;
		int countChessClub = 0;
		int countEdibleMath = 0;
		int countMUN = 0;
		int countJournalism = 0;
		int countGreenhouse = 0;
		boolean answer = false;

		try{
			rs = state.executeQuery("SELECT * FROM students");
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			
			while(rs.next())
				{
					String trimester1 = rs.getString("tri1");
				
					//Checks how many students are in the class
					if(trimester1.equals("Village Youtube Club")){
						countVillageYoutubeClub++;
					}
					if(trimester1.equals("B.E.A.T.S")){
						countBEATS++;
					}
					if(trimester1.equals("Chess Club")){
						countChessClub++;
					}
					if(trimester1.equals("Edible Math")){
						countEdibleMath++;
					}
					if(trimester1.equals("MUN")){
						countMUN++;
					}
					if(trimester1.equals("Journalism")){
						countJournalism++;
					}
					if(trimester1.equals("Greenhouse")){
						countGreenhouse++;
					}
					
					
					if(check.equals("Village Youtube Club") && countVillageYoutubeClub <= classSize){
						answer = true;
					}else if(check.equals("Village Youtube Club") && countVillageYoutubeClub <= classSize){
						answer = false;
					}
					
					if(check.equals("B.E.A.T.S") && countBEATS <= classSize){
						answer = true;
					}else if(check.equals("B.E.A.T.S") && countBEATS > classSize){
						answer = false;
					}
					
					if(check.equals("Chess Club") && countChessClub <= classSize){
						answer = true;
					}else if(check.equals("Chess Club") && countChessClub > classSize){
						answer = false;
					}
					
					if(check.equals("Edible Math") && countEdibleMath <= classSize){
						answer = true;
					}else if(check.equals("Edible Math") && countEdibleMath > classSize){
						answer = false;
					}
					
					if(check.equals("MUN") && countMUN <= classSize){
						answer = true;
					}else if(check.equals("MUN") && countMUN > classSize){
						answer = false;
					}
					
					if(check.equals("Journalism") && countJournalism <= classSize){
						answer = true;
					}else if(check.equals("Journalism") && countJournalism > classSize){
						answer = false;
					}
					
					if(check.equals("Greenhouse") && countGreenhouse <= classSize){
						answer = true;
					}else if(check.equals("Greenhouse") && countGreenhouse > classSize){
						answer = false;
					}
				}
			}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		return answer;
	}
	
	public boolean checkT2(String check){
		int countVillageYoutubeClub = 0;
		int countBEATS = 0;
		int countChessClub = 0;
		int countEdibleMath = 0;
		int countMUN = 0;
		int countJournalism = 0;
		int countGreenhouse = 0;
		boolean answer = false;

		try{
			rs = state.executeQuery("SELECT * FROM students");
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			
			while(rs.next())
				{
					String trimester2 = rs.getString("tri2");
				
					//Checks how many students are in the class
					if(trimester2.equals("Village Youtube Club")){
						countVillageYoutubeClub++;
					}
					if(trimester2.equals("B.E.A.T.S")){
						countBEATS++;
					}
					if(trimester2.equals("Chess Club")){
						countChessClub++;
					}
					if(trimester2.equals("Edible Math")){
						countEdibleMath++;
					}
					if(trimester2.equals("MUN")){
						countMUN++;
					}
					if(trimester2.equals("Journalism")){
						countJournalism++;
					}
					if(trimester2.equals("Greenhouse")){
						countGreenhouse++;
					}
					
					
					if(check.equals("Village Youtube Club") && countVillageYoutubeClub <= classSize){
						answer = true;
					}else if(check.equals("Village Youtube Club") && countVillageYoutubeClub <= classSize){
						answer = false;
					}
					
					if(check.equals("B.E.A.T.S") && countBEATS <= classSize){
						answer = true;
					}else if(check.equals("B.E.A.T.S") && countBEATS > classSize){
						answer = false;
					}
					
					if(check.equals("Chess Club") && countChessClub <= classSize){
						answer = true;
					}else if(check.equals("Chess Club") && countChessClub > classSize){
						answer = false;
					}
					
					if(check.equals("Edible Math") && countEdibleMath <= classSize){
						answer = true;
					}else if(check.equals("Edible Math") && countEdibleMath > classSize){
						answer = false;
					}
					
					if(check.equals("MUN") && countMUN <= classSize){
						answer = true;
					}else if(check.equals("MUN") && countMUN > classSize){
						answer = false;
					}
					
					if(check.equals("Journalism") && countJournalism <= classSize){
						answer = true;
					}else if(check.equals("Journalism") && countJournalism > classSize){
						answer = false;
					}
					
					if(check.equals("Greenhouse") && countGreenhouse <= classSize){
						answer = true;
					}else if(check.equals("Greenhouse") && countGreenhouse > classSize){
						answer = false;
					}
				}
			}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		return answer;
	}
	
	public boolean checkT3(String check){
		int countVillageYoutubeClub = 0;
		int countBEATS = 0;
		int countChessClub = 0;
		int countEdibleMath = 0;
		int countMUN = 0;
		int countJournalism = 0;
		int countGreenhouse = 0;
		boolean answer = false;

		try{
			rs = state.executeQuery("SELECT * FROM students");
			conn = DriverManager.getConnection(connectURL);
			state = conn.createStatement();
			
			while(rs.next())
				{
					String trimester3 = rs.getString("tri3");
				
					//Checks how many students are in the class
					if(trimester3.equals("Village Youtube Club")){
						countVillageYoutubeClub++;
					}
					if(trimester3.equals("B.E.A.T.S")){
						countBEATS++;
					}
					if(trimester3.equals("Chess Club")){
						countChessClub++;
					}
					if(trimester3.equals("Edible Math")){
						countEdibleMath++;
					}
					if(trimester3.equals("MUN")){
						countMUN++;
					}
					if(trimester3.equals("Journalism")){
						countJournalism++;
					}
					if(trimester3.equals("Greenhouse")){
						countGreenhouse++;
					}
					
					
					if(check.equals("Village Youtube Club") && countVillageYoutubeClub <= classSize){
						answer = true;
					}else if(check.equals("Village Youtube Club") && countVillageYoutubeClub <= classSize){
						answer = false;
					}
					
					if(check.equals("B.E.A.T.S") && countBEATS <= classSize){
						answer = true;
					}else if(check.equals("B.E.A.T.S") && countBEATS > classSize){
						answer = false;
					}
					
					if(check.equals("Chess Club") && countChessClub <= classSize){
						answer = true;
					}else if(check.equals("Chess Club") && countChessClub > classSize){
						answer = false;
					}
					
					if(check.equals("Edible Math") && countEdibleMath <= classSize){
						answer = true;
					}else if(check.equals("Edible Math") && countEdibleMath > classSize){
						answer = false;
					}
					
					if(check.equals("MUN") && countMUN <= classSize){
						answer = true;
					}else if(check.equals("MUN") && countMUN > classSize){
						answer = false;
					}
					
					if(check.equals("Journalism") && countJournalism <= classSize){
						answer = true;
					}else if(check.equals("Journalism") && countJournalism > classSize){
						answer = false;
					}
					
					if(check.equals("Greenhouse") && countGreenhouse <= classSize){
						answer = true;
					}else if(check.equals("Greenhouse") && countGreenhouse > classSize){
						answer = false;
					}
				}
			}
		catch(SQLException err){
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		return answer;
	}
}

	
