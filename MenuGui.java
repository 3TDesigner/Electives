/*
This class acts as the menu or hub of the GUI. From here
one can press the three main buttons that have their own
seperate functions for the program.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuGui{
	//Declares instances variables
	private static final int width = 800;
	private static final int height = 500;
	private static final int editWidth = 800;
	private static final int editHeight = 300;
	private static final int red = 252;
	private static final int green = 142;
	private static final int blue = 40;
	private JFrame menuFrame = new JFrame("VMS Database");
	
	//Sets up the initial window of the class
	public void setWindow(){
		//Decalres consants for spacing
		final int FRAME_SPACING = 140;
		
		//EXIT_ON_CLOSE closes the program when the "x" button is clicked
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(width, height);
		menuFrame.getContentPane().setBackground(new Color(red, green, blue));
		menuFrame.setLayout(new BorderLayout(0, FRAME_SPACING));
	}
	
	//Sets up everything that can be interacted with
	public void Interactors(){
		//Declares constants for font
		final String FONT_NAME = "Courier";
		final int FONT_SIZE = 36;
		
		//Sets up variables
		JLabel electiveLabel = new JLabel("Welcome to Elective Organizer!", SwingConstants.CENTER);
		JLabel electiveImageLabel = new JLabel(new ImageIcon("rsz_electives-logo.jpg"));
		JPanel buttonPanel = new JPanel();
		JButton listView = new JButton("List View");
		JButton studentView = new JButton("Student View");
		JButton editView = new JButton("Edit View");
		
		//Creates font for label
		electiveLabel.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
		
		//Panel for buttons
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(new Color(red, green, blue));
		
		listView.addActionListener(new EndingListener());
		buttonPanel.add(listView);
		
		studentView.addActionListener(new EndingListener());
		buttonPanel.add(studentView);
		
		editView.addActionListener(new EndingListener());
		buttonPanel.add(editView);
		
		//Add contents
		menuFrame.add(electiveLabel, BorderLayout.NORTH);
		menuFrame.add(buttonPanel, BorderLayout.CENTER);
		menuFrame.add(electiveImageLabel, BorderLayout.SOUTH);
		menuFrame.setVisible(true);
	}
	
/*
This class responds to the interactions in the GUI. For this 
class each button calls upon a different class and opens up 
it windows and interactors while also setting the Menu GUI to be invisible.
*/	
public class EndingListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//Declares variables
		String buttonCommand =  e.getActionCommand();
		ListViewGui listGui = new ListViewGui();
		StudentViewGui studentGui = new StudentViewGui();
		EditViewGui editGui = new EditViewGui();
		
		if(buttonCommand.equals("List View")){
			menuFrame.setVisible(false);
			listGui.listShowFrame(width, height);
			listGui.listInteractors();
		}
		else if(buttonCommand.equals("Student View")){
			menuFrame.setVisible(false);
			studentGui.studentShowFrame(width, height);
			studentGui.studentInteractors();
		}
		else if(buttonCommand.equals("Edit View")){
			menuFrame.setVisible(false);
			editGui.editShowFrame(editWidth, editHeight);
			editGui.editInteractors();
		}
	}
}
}