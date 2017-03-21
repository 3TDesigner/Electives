import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStudentViewGui{
	//Declares instances variables
	private static final int textFieldSize = 20;
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JTextField updateTF;
	private int fontSize = 14;
	private int red = 142;
	private int green = 245;
	private int blue = 255;
	private String fontName = "Courier new";
	private JFrame updateFrame = new JFrame("Update View");
	private MyDataBase database = new MyDataBase();
	private JRadioButton gradeButton;
	private JRadioButton genderButton;
	private JRadioButton firstQuarterButton;
	private JRadioButton secondQuarterButton;
	private JRadioButton thirdQuarterButton;
	private JRadioButton fourthQuarterButton;
	private JRadioButton firstTrimesterButton;
	private JRadioButton secondTrimesterButton;
	private JRadioButton thirdTrimesterButton;
	private JLabel errorLabel;
	
	//Sets up window
	public void updateShowFrame(int frameWidth, int frameHeight){
		updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updateFrame.setSize(frameWidth, frameHeight);
		updateFrame.getContentPane().setBackground(new Color(red, green, blue));
		updateFrame.setLayout(new BorderLayout());
	}

	//Sets up interactors
	public void updateInteractors(){
		/*Top Panel*/
		JPanel updatePanel = new JPanel();
		updatePanel.setLayout(new GridLayout(2, 2));
		updatePanel.setBackground(new Color(red, green, blue));

		/*Label and TextFields*/
		JLabel firstNamelabel = new JLabel("First Name:");
		firstNamelabel.setFont(new Font("Courier new", Font.BOLD, fontSize));
		updatePanel.add(firstNamelabel);
		
		firstNameTF = new JTextField(textFieldSize);
		updatePanel.add(firstNameTF);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("Courier new", Font.BOLD, fontSize));
		updatePanel.add(lastNameLabel);
		
		lastNameTF = new JTextField(textFieldSize);
		updatePanel.add(lastNameTF);
		
		/*Middle Panel*/
		/*Course Label and Buttons*/
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(12, 1));
		buttonPanel.setBackground(new Color(red, green, blue));
		
		JLabel course = new JLabel("Update Options:");
		course.setFont(new Font(fontName, Font.BOLD, fontSize));
		buttonPanel.add(course);
		
		gradeButton = new JRadioButton("Grade");
		gradeButton.setSelected(true);
		buttonPanel.add(gradeButton);
		genderButton = new JRadioButton("Gender");
		buttonPanel.add(genderButton);
		firstQuarterButton = new JRadioButton("Q1");
		buttonPanel.add(firstQuarterButton);
		secondQuarterButton = new JRadioButton("Q2");
		buttonPanel.add(secondQuarterButton);
		thirdQuarterButton = new JRadioButton("Q3");
		buttonPanel.add(thirdQuarterButton);
		fourthQuarterButton = new JRadioButton("Q4");
		buttonPanel.add(fourthQuarterButton);
		firstTrimesterButton = new JRadioButton("T1");
		buttonPanel.add(firstTrimesterButton);
		secondTrimesterButton = new JRadioButton("T2");
		buttonPanel.add(secondTrimesterButton);
		thirdTrimesterButton = new JRadioButton("T3");
		buttonPanel.add(thirdTrimesterButton);
		
		ButtonGroup courseGroup = new ButtonGroup();
		courseGroup.add(gradeButton);
		courseGroup.add(genderButton);
		courseGroup.add(firstQuarterButton);
		courseGroup.add(secondQuarterButton);
		courseGroup.add(thirdQuarterButton);
		courseGroup.add(fourthQuarterButton);
		courseGroup.add(firstTrimesterButton);
		courseGroup.add(secondTrimesterButton);
		courseGroup.add(thirdTrimesterButton);
		
		//Error Label
		errorLabel = new JLabel("", SwingConstants.CENTER);
		errorLabel.setFont(new Font("Courier new", Font.BOLD, fontSize));
		errorLabel.setForeground(Color.RED);
		buttonPanel.add(errorLabel);
		
		/*Bottom Panel*/
		JPanel updateLabelPanel = new JPanel();
		JLabel updatelabel = new JLabel("Update:");
		updatelabel.setFont(new Font("Courier new", Font.BOLD, fontSize));
		updateLabelPanel.add(updatelabel);
		
		updateTF = new JTextField(textFieldSize);
		updateLabelPanel.add(updateTF);
		
		JButton enter = new JButton("Enter");
		enter.addActionListener(new EndingListener());
		updateLabelPanel.add(enter);

		//Add Contents
		updateFrame.add(updatePanel, BorderLayout.NORTH);
		updateFrame.add(buttonPanel, BorderLayout.CENTER);
		updateFrame.add(updateLabelPanel, BorderLayout.SOUTH);
		updateFrame.setVisible(true);
	}
	
public class EndingListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//Declares variables
		String buttonCommand =  e.getActionCommand();
		String firstName = firstNameTF.getText();
		String lastName = lastNameTF.getText();
		String updateText = updateTF.getText();
		String fullName = firstName + " " + lastName;
		/*
		If statements takes the first and last names and
		compares them to first and last names in the database.
		If found in the database that student is updated.
		*/
		if(gradeButton.isSelected() && buttonCommand.equals("Enter")){		
			//Checks if the grade inputted is suitable
			if(updateText.matches("[6-8]+")){
				int grade = Integer.parseInt(updateText);
			
				if(!(firstName.equals("") || lastName.equals(""))){
					if(database.returnName(fullName) == true){
						database.updateGrade(fullName, grade);
						updateFrame.setVisible(false);
					}else{
						errorLabel.setText("That student does not exist");
					}	
				}else{
					errorLabel.setText("Please input all the data");
				}
			}else{
				errorLabel.setText("Please input a grade between 6 through 8");
			}
		}
		
		else if(genderButton.isSelected() && buttonCommand.equals("Enter")){		
			if(updateText.matches("M") || updateText.matches("F")){
				if(!(firstName.equals("") || lastName.equals(""))){
					if(database.returnName(fullName) == true){
						database.updateGender(fullName, updateText);
						updateFrame.setVisible(false);
					}else{
						errorLabel.setText("That student does not exist");
					}	
				}else{
					errorLabel.setText("Please input all the data");
				}
			}else{
				errorLabel.setText("Please input a gender that is either M or F");
			}
		}
		
		else if(firstQuarterButton.isSelected() && buttonCommand.equals("Enter")){
				if(!(firstName.equals("") || lastName.equals(""))){
					if(database.returnName(fullName) == true){
						database.updateQ1(fullName, updateText);
						updateFrame.setVisible(false);
					}else{
						errorLabel.setText("That student does not exist");
					}	
				}else{
					errorLabel.setText("Please input all the data");
				}
		}
		else if(secondQuarterButton.isSelected() && buttonCommand.equals("Enter")){
			if(!(firstName.equals("") || lastName.equals(""))){
					if(database.returnName(fullName) == true){
						database.updateQ2(fullName, updateText);
						updateFrame.setVisible(false);
					}else{
						errorLabel.setText("That student does not exist");
					}	
				}else{
					errorLabel.setText("Please input all the data");
				}
		}
		else if(thirdQuarterButton.isSelected() && buttonCommand.equals("Enter")){
			if(!(firstName.equals("") || lastName.equals(""))){
					if(database.returnName(fullName) == true){
						database.updateQ3(fullName, updateText);
						updateFrame.setVisible(false);
					}else{
						errorLabel.setText("That student does not exist");
					}	
				}else{
					errorLabel.setText("Please input all the data");
				}
		}
		else if(fourthQuarterButton.isSelected() && buttonCommand.equals("Enter")){
			if(!(firstName.equals("") || lastName.equals(""))){
					if(database.returnName(fullName) == true){
						database.updateQ4(fullName, updateText);
						updateFrame.setVisible(false);
					}else{
						errorLabel.setText("That student does not exist");
					}	
				}else{
					errorLabel.setText("Please input all the data");
				}
		}
		else if(firstTrimesterButton.isSelected() && buttonCommand.equals("Enter")){
			if(!(firstName.equals("") || lastName.equals(""))){
					if(database.returnName(fullName) == true){
						database.updateT1(fullName, updateText);
						updateFrame.setVisible(false);
					}else{
						errorLabel.setText("That student does not exist");
					}	
				}else{
					errorLabel.setText("Please input all the data");
				}
		}
		else if(secondTrimesterButton.isSelected() && buttonCommand.equals("Enter")){
			if(!(firstName.equals("") || lastName.equals(""))){
					if(database.returnName(fullName) == true){
						database.updateT2(fullName, updateText);
						updateFrame.setVisible(false);
					}else{
						errorLabel.setText("That student does not exist");
					}	
				}else{
					errorLabel.setText("Please input all the data");
				}
		}
		else if(thirdTrimesterButton.isSelected() && buttonCommand.equals("Enter")){
			if(!(firstName.equals("") || lastName.equals(""))){
					if(database.returnName(fullName) == true){
						database.updateT3(fullName, updateText);
						updateFrame.setVisible(false);
					}else{
						errorLabel.setText("That student does not exist");
					}	
				}else{
					errorLabel.setText("Please input all the data");
				}
		}
	}
}
}