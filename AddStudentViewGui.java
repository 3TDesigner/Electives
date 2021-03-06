import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentViewGui{
	//Declares instance variables
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JTextField gradeTF;
	private JTextField genderTF;
	private JTextField firstQuarterChoiceTF;
	private JTextField secondQuarterChoiceTF;
	private JTextField thirdQuarterChoiceTF;
	private JTextField fourthQuarterChoiceTF;
	private JTextField fifthQuarterChoiceTF;
	private JTextField sixthQuarterChoiceTF;
	private JTextField firstTrimesterChoiceTF;
	private JTextField secondTrimesterChoiceTF;
	private JTextField thirdTrimesterChoiceTF;
	private JTextField fourthTrimesterChoiceTF;
	private JTextField fifthTrimesterChoiceTF;
	private JLabel errorLabel;
	private static final int textFieldSize = 20;
	private JFrame addFrame = new JFrame("Add Student View");
	
	//Displays the frame
	public void addShowFrame(int frameWidth, int frameHeight){
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addFrame.setSize(frameWidth, frameHeight);
		addFrame.getContentPane().setBackground(new Color(142, 245, 255));
		addFrame.setLayout(new BorderLayout());
	}

	//Displays interactors
	public void addInteractors(){
		//Declares variables
		JPanel addPanel = new JPanel();
		JLabel firstName = new JLabel("First Name:");
		JLabel lastName = new JLabel("Last Name:");
		JLabel grade = new JLabel("Grade:");
		JLabel gender = new JLabel("Gender:");
		JLabel firstQuarterChoice = new JLabel("First Quarter Choice:");
		JLabel secondQuarterChoice = new JLabel("Second Quarter Choice:");
		JLabel thirdQuarterChoice = new JLabel("Third Quarter Choice:");
		JLabel fourthQuarterChoice = new JLabel("Fourth Quarter Choice:");
		JLabel fifthQuarterChoice = new JLabel("Fifth Quarter Choice:");
		JLabel sixthQuarterChoice = new JLabel("Sixth Quarter Choice:");
		JLabel firstTrimesterChoice = new JLabel("First Trimester Choice:");
		JLabel secondTrimesterChoice = new JLabel("Second Trimester Choice:");
		JLabel thirdTrimesterChoice = new JLabel("Third Trimester Choice:");
		JLabel fourthTrimesterChoice = new JLabel("Fourth Trimester Choice:");
		JLabel fifthTrimesterChoice = new JLabel("Fifth Trimester Choice:");
		
		/*Labels and Textfields*/
		addPanel.setLayout(new GridLayout(15, 2));
		addPanel.setBackground(new Color(142, 245, 255));
		
		//First Name
		firstName.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(firstName);
		firstNameTF = new JTextField(textFieldSize);
		addPanel.add(firstNameTF);
		
		//Last Name
		lastName.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(lastName);
		lastNameTF = new JTextField(textFieldSize);
		addPanel.add(lastNameTF);
		
		//Grade
		grade.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(grade);
		gradeTF = new JTextField(textFieldSize);
		addPanel.add(gradeTF);
		
		//Gender
		gender.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(gender);
		genderTF = new JTextField(textFieldSize);
		addPanel.add(genderTF);
		
		//First Quarter Choice
		firstQuarterChoice.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(firstQuarterChoice);
		firstQuarterChoiceTF = new JTextField(textFieldSize);
		addPanel.add(firstQuarterChoiceTF);
		
		//Second Quarter Choice
		secondQuarterChoice.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(secondQuarterChoice);
		secondQuarterChoiceTF = new JTextField(textFieldSize);
		addPanel.add(secondQuarterChoiceTF);
		
		//Third Quarter Choice
		thirdQuarterChoice.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(thirdQuarterChoice);
		thirdQuarterChoiceTF = new JTextField(textFieldSize);
		addPanel.add(thirdQuarterChoiceTF);
		
		//Fourth Quarter Choice
		fourthQuarterChoice.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(fourthQuarterChoice);
		fourthQuarterChoiceTF = new JTextField(textFieldSize);
		addPanel.add(fourthQuarterChoiceTF);
		
		//Fifth Quarter Choice
		fifthQuarterChoice.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(fifthQuarterChoice);
		fifthQuarterChoiceTF = new JTextField(textFieldSize);
		addPanel.add(fifthQuarterChoiceTF);
		
		//Sixth Quarter Choice
		sixthQuarterChoice.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(sixthQuarterChoice);
		sixthQuarterChoiceTF = new JTextField(textFieldSize);
		addPanel.add(sixthQuarterChoiceTF);
		
		//First Trimester Choice
		firstTrimesterChoice.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(firstTrimesterChoice);
		firstTrimesterChoiceTF = new JTextField(textFieldSize);
		addPanel.add(firstTrimesterChoiceTF);
		
		//Second Trimester Choice
		secondTrimesterChoice.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(secondTrimesterChoice);
		secondTrimesterChoiceTF = new JTextField(textFieldSize);
		addPanel.add(secondTrimesterChoiceTF);
		
		//Third Trimester Choice
		thirdTrimesterChoice.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(thirdTrimesterChoice);
		thirdTrimesterChoiceTF = new JTextField(textFieldSize);
		addPanel.add(thirdTrimesterChoiceTF);
		
		//Fourth Trimester Choice
		fourthTrimesterChoice.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(fourthTrimesterChoice);
		fourthTrimesterChoiceTF = new JTextField(textFieldSize);
		addPanel.add(fourthTrimesterChoiceTF);
		
		//Fifth Trimester Choice
		fifthTrimesterChoice.setFont(new Font("Courier new", Font.BOLD, 14));
		addPanel.add(fifthTrimesterChoice);
		fifthTrimesterChoiceTF = new JTextField(textFieldSize);
		addPanel.add(fifthTrimesterChoiceTF);
		
		//Error Label
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(2, 1));
		southPanel.setBackground(new Color(142, 245, 255));
		errorLabel = new JLabel("", SwingConstants.CENTER);
		errorLabel.setFont(new Font("Courier new", Font.BOLD, 14));
		errorLabel.setForeground(Color.RED);
		southPanel.add(errorLabel);
		
		/*Button*/
		JButton submit = new JButton("Submit");
		submit.addActionListener(new EndingListener());
		southPanel.add(submit);

		//Add Contents
		addFrame.add(addPanel, BorderLayout.CENTER);
		addFrame.add(southPanel, BorderLayout.SOUTH);
		addFrame.setVisible(true);
	}
	
	
public class EndingListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
		String buttonCommand =  e.getActionCommand();
		String myFirstName;
		String myLastName;
		int myGrade;
		String myGender;
		String myStringGrade;
		String myFirstQuarterChoice;
		String mySecondQuarterChoice;
		String myThirdQuarterChoice;
		String myFourthQuarterChoice;
		String myFifthQuarterChoice;
		String mySixthQuarterChoice;
		String myFirstTrimesterChoice;
		String mySecondTrimesterChoice;
		String myThirdTrimesterChoice;
		String myFourthTrimesterChoice;
		String myFifthTrimesterChoice;
		MyDataBase database = new MyDataBase();
		
		if(buttonCommand.equals("Submit")){
			myFirstName = firstNameTF.getText();
			myLastName = lastNameTF.getText();
			myStringGrade = gradeTF.getText();
			myGender = genderTF.getText();
			myFirstQuarterChoice = firstQuarterChoiceTF.getText();
			mySecondQuarterChoice = secondQuarterChoiceTF.getText();
			myThirdQuarterChoice = thirdQuarterChoiceTF.getText();
			myFourthQuarterChoice = fourthQuarterChoiceTF.getText();
			myFifthQuarterChoice = fifthQuarterChoiceTF.getText();
			mySixthQuarterChoice = sixthQuarterChoiceTF.getText();
			myFirstTrimesterChoice = firstTrimesterChoiceTF.getText();
			mySecondTrimesterChoice = secondTrimesterChoiceTF.getText();
			myThirdTrimesterChoice = thirdTrimesterChoiceTF.getText();
			myFourthTrimesterChoice = fourthTrimesterChoiceTF.getText();
			myFifthTrimesterChoice = fifthTrimesterChoiceTF.getText();
			String fullName = myFirstName + " " + myLastName;
			
			if(myStringGrade.matches("[6-8]+")){
				myGrade = Integer.parseInt(gradeTF.getText());
				if(!(myFirstName.equals("") || myLastName.equals("") || myStringGrade.equals("") ||
					myGender.equals("") || myFirstQuarterChoice.equals("") || mySecondQuarterChoice.equals("") ||
					myThirdQuarterChoice.equals("") || myFourthQuarterChoice.equals("") ||
					myFifthQuarterChoice.equals("") || mySixthQuarterChoice.equals("") ||
					myFirstTrimesterChoice.equals("") || mySecondTrimesterChoice.equals("") ||
					myThirdTrimesterChoice.equals("") || myFourthTrimesterChoice.equals("") ||
					myFifthTrimesterChoice.equals(""))){
					//arrangeElectives(myFirstName, myLastName, myGrade, myGender, myFirstQuarterChoice,
						//mySecondQuarterChoice, myThirdQuarterChoice, myFourthQuarterChoice,
						//myFifthQuarterChoice, mySixthQuarterChoice, myFirstTrimesterChoice,
						//mySecondTrimesterChoice, myThirdTrimesterChoice, myFourthTrimesterChoice, myFifthTrimesterChoice);
						database.insertIntoTable(fullName, myGrade, myGender, myFirstQuarterChoice, mySecondQuarterChoice,
			myThirdQuarterChoice, myFourthQuarterChoice, myFirstTrimesterChoice, mySecondTrimesterChoice, myThirdTrimesterChoice);
					addFrame.setVisible(false);
				}else{
					errorLabel.setText("Please input all the data");
				}
			}else{
				errorLabel.setText("Please input a grade between 6 through 8");
			}
		}
	}
	
	/*
	This method enacts the algotrithm that acts as first come first serve. It checks
	whether the class if full or not by checking the database and then attempts to place
	the student in the class of their choice if it hasn't been inputted already.
	*/
	
	/*
	private void arrangeElectives(String arrFirstName, String arrLastName, int arrGrade, String arrGender,
		String arrFirstQuarter, String arrSecondQuarter, String arrThirdQuarter, String arrFourthQuarter,
		String arrFifthQuarter, String arrSixthQuarter, String arrFirstTrimester, String arrSecondTrimester,
		String arrThirdTrimester, String arrFourthTrimester, String arrFifthTrimester){
	
		String finalQ1 = "";
		String finalQ2 = "";
		String finalQ3 = "";
		String finalQ4 = "";
		String finalT1 = "";
		String finalT2 = "";
		String finalT3 = "";
		
		ArrayList<String> quarterChoices = new ArrayList<String>();
		ArrayList<String> trimesterChoices = new ArrayList<String>();
		
		String fullName = arrFirstName + " " + arrLastName;
		
		MyDataBase database = new MyDataBase();
		
		quarterChoices.add(arrFirstQuarter);
		quarterChoices.add(arrSecondQuarter);
		quarterChoices.add(arrThirdQuarter);
		quarterChoices.add(arrFourthQuarter);
		quarterChoices.add(arrFifthQuarter);
		quarterChoices.add(arrSixthQuarter);
		
		trimesterChoices.add(arrFirstTrimester);
		trimesterChoices.add(arrSecondTrimester);
		trimesterChoices.add(arrThirdTrimester);
		trimesterChoices.add(arrFourthTrimester);
		trimesterChoices.add(arrFifthTrimester);
		

		//Checks if class is full for each of the choices. If the 
		//choice can be used then that choice is deleted from the array.

		
		if(database.checkQ1(arrFirstQuarter) == true){
			finalQ1 = arrFirstQuarter;
			quarterChoices.remove(arrFirstQuarter);
		} else if(database.checkQ1(arrSecondQuarter) == true){
			finalQ1 = arrSecondQuarter;
			quarterChoices.remove(arrSecondQuarter);
		} else if(database.checkQ1(arrThirdQuarter) == true){
			finalQ1 = arrThirdQuarter;
			quarterChoices.remove(arrThirdQuarter);
		} else if(database.checkQ1(arrFourthQuarter) == true){
			finalQ1 = arrFourthQuarter;
			quarterChoices.remove(arrFourthQuarter);
		} else if(database.checkQ1(arrFifthQuarter) == true){
			finalQ1 = arrFifthQuarter;
			quarterChoices.remove(arrFifthQuarter);
		} else if(database.checkQ1(arrSixthQuarter) == true){
			finalQ1 = arrSixthQuarter;
			quarterChoices.remove(arrSixthQuarter);
		}
		
		if(database.checkQ2(arrFirstQuarter) == true 
			&& quarterChoices.contains(arrFirstQuarter)){
			finalQ2 = arrFirstQuarter;
			quarterChoices.remove(arrFirstQuarter);
		} else if(database.checkQ2(arrSecondQuarter) == true
			&& quarterChoices.contains(arrSecondQuarter)){
			finalQ2 = arrSecondQuarter;
			quarterChoices.remove(arrSecondQuarter);
		} else if(database.checkQ2(arrThirdQuarter) == true
			&& quarterChoices.contains(arrThirdQuarter)){
			finalQ2 = arrThirdQuarter;
			quarterChoices.remove(arrThirdQuarter);
		} else if(database.checkQ2(arrFourthQuarter) == true
			&& quarterChoices.contains(arrFourthQuarter)){
			finalQ2 = arrFourthQuarter;
			quarterChoices.remove(arrFourthQuarter);
		} else if(database.checkQ2(arrFifthQuarter) == true
			&& quarterChoices.contains(arrFifthQuarter)){
			finalQ2 = arrFifthQuarter;
			quarterChoices.remove(arrFifthQuarter);
		} else if(database.checkQ2(arrSixthQuarter) == true
			&& quarterChoices.contains(arrSixthQuarter)){
			finalQ2 = arrSixthQuarter;
			quarterChoices.remove(arrSixthQuarter);
		}
		
		if(database.checkQ3(arrFirstQuarter) == true 
			&& quarterChoices.contains(arrFirstQuarter)){
			finalQ3 = arrFirstQuarter;
			quarterChoices.remove(arrFirstQuarter);
		} else if(database.checkQ3(arrSecondQuarter) == true
			&& quarterChoices.contains(arrSecondQuarter)){
			finalQ3 = arrSecondQuarter;
			quarterChoices.remove(arrSecondQuarter);
		} else if(database.checkQ3(arrThirdQuarter) == true
			&& quarterChoices.contains(arrThirdQuarter)){
			finalQ3 = arrThirdQuarter;
			quarterChoices.remove(arrThirdQuarter);
		} else if(database.checkQ3(arrFourthQuarter) == true
			&& quarterChoices.contains(arrFourthQuarter)){
			finalQ3 = arrFourthQuarter;
			quarterChoices.remove(arrFourthQuarter);
		} else if(database.checkQ3(arrFifthQuarter) == true
			&& quarterChoices.contains(arrFifthQuarter)){
			finalQ3 = arrFifthQuarter;
			quarterChoices.remove(arrFifthQuarter);
		} else if(database.checkQ3(arrSixthQuarter) == true
			&& quarterChoices.contains(arrSixthQuarter)){
			finalQ3 = arrSixthQuarter;
			quarterChoices.remove(arrSixthQuarter);
		}
		
		if(database.checkQ4(arrFirstQuarter) == true 
			&& quarterChoices.contains(arrFirstQuarter)){
			finalQ4 = arrFirstQuarter;
		} else if(database.checkQ4(arrSecondQuarter) == true
			&& quarterChoices.contains(arrSecondQuarter)){
			finalQ4 = arrSecondQuarter;
		} else if(database.checkQ4(arrThirdQuarter) == true
			&& quarterChoices.contains(arrThirdQuarter)){
			finalQ4 = arrThirdQuarter;
		} else if(database.checkQ4(arrFourthQuarter) == true
			&& quarterChoices.contains(arrFourthQuarter)){
			finalQ4 = arrFourthQuarter;
		} else if(database.checkQ4(arrFifthQuarter) == true
			&& quarterChoices.contains(arrFifthQuarter)){
			finalQ4 = arrFifthQuarter;
		} else if(database.checkQ4(arrSixthQuarter) == true
			&& quarterChoices.contains(arrSixthQuarter)){
			finalQ4 = arrSixthQuarter;
		}
		
		if(database.checkT1(arrFirstTrimester) == true){
			finalT1 = arrFirstTrimester;
			trimesterChoices.remove(arrFirstTrimester);
		} else if(database.checkT1(arrSecondTrimester) == true){
			finalT1 = arrSecondTrimester;
			trimesterChoices.remove(arrSecondTrimester);
		} else if(database.checkT1(arrThirdTrimester) == true){
			finalT1 = arrThirdTrimester;
			trimesterChoices.remove(arrThirdTrimester);
		} else if(database.checkT1(arrFourthTrimester) == true){
			finalT1 = arrFourthTrimester;
			trimesterChoices.remove(arrFourthTrimester);
		} else if(database.checkT1(arrFifthTrimester) == true){
			finalT1 = arrFifthTrimester;
			trimesterChoices.remove(arrFifthTrimester);
		} 
		
		if(database.checkT2(arrFirstTrimester) == true
			&& trimesterChoices.contains(arrFirstTrimester)){
			finalT2 = arrFirstTrimester;
			trimesterChoices.remove(arrFirstTrimester);
		} else if(database.checkT2(arrSecondTrimester) == true
			&& trimesterChoices.contains(arrSecondTrimester)){
			finalT2 = arrSecondTrimester;
			trimesterChoices.remove(arrSecondTrimester);
		} else if(database.checkT2(arrThirdTrimester) == true
			&& trimesterChoices.contains(arrThirdTrimester)){
			finalT2 = arrThirdTrimester;
			trimesterChoices.remove(arrThirdTrimester);
		} else if(database.checkT2(arrFourthTrimester) == true
			&& trimesterChoices.contains(arrFourthTrimester)){
			finalT2 = arrFourthTrimester;
			trimesterChoices.remove(arrFourthTrimester);
		} else if(database.checkT2(arrFifthTrimester) == true
			&& trimesterChoices.contains(arrFifthTrimester)){
			finalT2 = arrFifthTrimester;
			trimesterChoices.remove(arrFifthTrimester);
		} 
		
		if(database.checkT3(arrFirstTrimester) == true
			&& trimesterChoices.contains(arrFirstTrimester)){
			finalT3 = arrFirstTrimester;
		} else if(database.checkT3(arrSecondTrimester) == true
			&& trimesterChoices.contains(arrSecondTrimester)){
			finalT3 = arrSecondTrimester;
		} else if(database.checkT3(arrThirdTrimester) == true
			&& trimesterChoices.contains(arrThirdTrimester)){
			finalT3 = arrThirdTrimester;
		} else if(database.checkT3(arrFourthTrimester) == true
			&& trimesterChoices.contains(arrFourthTrimester)){
			finalT3 = arrFourthTrimester;
		} else if(database.checkT3(arrFifthTrimester) == true
			&& trimesterChoices.contains(arrFifthTrimester)){
			finalT3 = arrFifthTrimester;
		} 
		
		database.insertIntoTable(fullName, arrGrade, arrGender, finalQ1, finalQ2,
			finalQ3, finalQ4, finalT1, finalT2, finalT3);
	}
	*/
}
}