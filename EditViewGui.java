import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditViewGui{
	//Declares instances variables
	private static final int width = 600;
	private static final int height = 400;
	private JFrame editFrame = new JFrame("Edit View");
	
	//Sets up the initial window of the class
	public void editShowFrame(int frameWidth, int frameHeight){
		editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		editFrame.setSize(frameWidth, frameHeight);
		editFrame.getContentPane().setBackground(Color.WHITE);
		editFrame.setLayout(new BorderLayout());
	}

	//Sets up interactors
	public void editInteractors(){
		//Declare variables
		JPanel editPanel = new JPanel();
		JButton addButton = new JButton("Add Student");
		JButton delete = new JButton("Delete Student");
		JButton update = new JButton("Update Student");
		JButton back = new JButton("Back");
		JLabel imageLabel = new JLabel(new ImageIcon("editpic.jpg"));
		
		/*Panel*/
		editPanel.setLayout(new FlowLayout());

		/*Button*/
		addButton.addActionListener(new EndingListener());
		editPanel.add(addButton);
		
		delete.addActionListener(new EndingListener());
		editPanel.add(delete);
		
		update.addActionListener(new EndingListener());
		editPanel.add(update);
		
		back.setForeground(Color.RED);
		back.addActionListener(new EndingListener());
		editPanel.add(back);
		
		//Add Contents
		editFrame.add(editPanel, BorderLayout.NORTH);
		editFrame.add(imageLabel, BorderLayout.CENTER);
		editFrame.setVisible(true);
	}
	
/*
This class responds to the interactions in the GUI. For this 
class each button calls upon a different class and opens up 
it windows and interactors.
*/
public class EndingListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
		//Declares variables
		String buttonCommand =  e.getActionCommand();
		MenuGui backGui = new MenuGui();
		AddStudentViewGui addGui = new AddStudentViewGui();
		DeleteStudentViewGui deleteGui = new DeleteStudentViewGui();
		UpdateStudentViewGui updateGui = new UpdateStudentViewGui();
		
		//Goes back to the Menu
		if(buttonCommand.equals("Back")){
			editFrame.setVisible(false);
			backGui.setWindow();
			backGui.Interactors();
		}
		else if(buttonCommand.equals("Add Student")){
			addGui.addShowFrame(width, height);
			addGui.addInteractors();
		}
		else if(buttonCommand.equals("Delete Student")){
			deleteGui.deleteShowFrame(width, height);
			deleteGui.deleteInteractors();
		}
		else if(buttonCommand.equals("Update Student")){
			updateGui.updateShowFrame(width, height);
			updateGui.updateInteractors();
		}
	}
}
}