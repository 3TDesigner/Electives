/*
This class deletes a student in the database.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteStudentViewGui{
	//Declares instances variables
	private static final int textFieldSize = 20;
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JFrame deleteFrame = new JFrame("Delete View");
	private JLabel errorLabel;
	
	//Sets up window
	public void deleteShowFrame(int frameWidth, int frameHeight){
		deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		deleteFrame.setSize(frameWidth, frameHeight);
		deleteFrame.getContentPane().setBackground(new Color(142, 245, 255));
		deleteFrame.setLayout(new BorderLayout());
	}

	//Sets up interactors
	public void deleteInteractors(){
		//Declares variables 
		JPanel southPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JLabel firstNameLabel = new JLabel("First Name:");
		JPanel middlePanel = new JPanel();
		JLabel lastNameLabel = new JLabel("Last Name:");
		JButton deleteButton = new JButton("Delete");
		
		/*Panel*/
		southPanel.setLayout(new GridLayout(2, 1));
		southPanel.setBackground(new Color(142, 245, 255));

		/*Label and TextFields*/
		topPanel.setBackground(new Color(142, 245, 255));
		firstNameLabel.setFont(new Font("Courier new", Font.BOLD, 14));
		topPanel.add(firstNameLabel);
		
		firstNameTF = new JTextField(textFieldSize);
		topPanel.add(firstNameTF);
		
		middlePanel.setBackground(new Color(142, 245, 255));
		lastNameLabel.setFont(new Font("Courier new", Font.BOLD, 14));
		middlePanel.add(lastNameLabel);
		
		lastNameTF = new JTextField(textFieldSize);
		middlePanel.add(lastNameTF);
		
		errorLabel = new JLabel("", SwingConstants.CENTER);
		errorLabel.setFont(new Font("Courier new", Font.BOLD, 14));
		errorLabel.setForeground(Color.RED);
		southPanel.add(errorLabel);
		
		/*Button*/
		deleteButton.addActionListener(new EndingListener());
		southPanel.add(deleteButton);

		//Add Contents
		deleteFrame.add(topPanel, BorderLayout.NORTH);
		deleteFrame.add(middlePanel, BorderLayout.CENTER);
		deleteFrame.add(southPanel, BorderLayout.SOUTH);
		deleteFrame.setVisible(true);
	}

public class EndingListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		String buttonCommand =  e.getActionCommand();
		//Declares variables
		String firstName = firstNameTF.getText();
		String lastName = lastNameTF.getText();
		MyDataBase database = new MyDataBase();
		String fullName = firstName + " " + lastName;
		/*
		If statement takes the first and last names and
		compares them to first and last names in the database.
		If found in the database that student is deleted.
		*/
		if(buttonCommand.equals("Delete")){
			if(!(firstName.equals("") || lastName.equals(""))){
				if(database.returnName(fullName) == true){
					database.delete(fullName);
					deleteFrame.setVisible(false);
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