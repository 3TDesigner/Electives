/*
This class not only shows the students and they're electives, but allows
the user to pick a specific student.
*/
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class StudentViewGui{
	//Declares instance variables
	private static final int textFieldSize = 15;
	private JTextField nameTextField;
	private JFrame studentFrame = new JFrame("Student View");
	private MyDataBase database = new MyDataBase();
	private TableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private TableRowSorter<TableModel>sorter;
	private int red = 157;
	private int green = 255;
	private int blue = 0;
	
	//Displays Student View
	public void studentShowFrame(int frameWidth, int frameHeight){
		studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studentFrame.setSize(frameWidth, frameHeight);
		studentFrame.getContentPane().setBackground(new Color(157, 255, 0));
		studentFrame.setLayout(new BorderLayout());
	}

	//Interactors for student view
	public void studentInteractors(){
		//Declares variables 
		JPanel studentPanel = new JPanel();
		JLabel name = new JLabel("Student Name:");
		JButton enter = new JButton("Enter");
		JButton back = new JButton("Back");
		JPanel tablePanel = new JPanel();
		database.selectTable();
		Object[][] tableData = database.createTableData();
		String[] columnNames = {"First Name", "Last Name", "Grade", "Gender", "Q1", 
			"Q2", "Q3", "Q4", "T1", "T2", "T3"};
		
		/*Panel*/
		studentPanel.setLayout(new FlowLayout());
		studentPanel.setBackground(new Color(red, green, blue));
		
		/*Label*/
		studentPanel.add(name);
		
		/*Text Field*/
		nameTextField = new JTextField(textFieldSize);
		studentPanel.add(nameTextField);
		
		/*Button*/
		enter.addActionListener(new EndingListener());
		studentPanel.add(enter);
		
		back.setForeground(Color.RED);
		back.addActionListener(new EndingListener());
		studentPanel.add(back);
		
    /*Table*/
		tablePanel.setLayout(new FlowLayout());
		tablePanel.setBackground(new Color(red, green, blue));
		
		//Accessing Database  
    model = new DefaultTableModel(tableData, columnNames);
    table = new JTable(model);
    sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
		scrollPane = new JScrollPane(table);
		
		//Add Contents
		studentFrame.add(scrollPane, BorderLayout.CENTER);
		studentFrame.add(studentPanel, BorderLayout.NORTH);
		studentFrame.setVisible(true);
	}
	
	
public class EndingListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
		//Declares variables
		String buttonCommand =  e.getActionCommand();
		MenuGui backGui = new MenuGui();
		String name = nameTextField.getText();
		String[] fullName = name.split(" ");
		
		//Goes back to the Menu
		if(buttonCommand.equals("Back")){
			studentFrame.setVisible(false);
			backGui.setWindow();
			backGui.Interactors();
		}
		
		/*
		If statement takes the text from the text field and
		filters the table based on that text.
		*/
		else if(buttonCommand.equals("Enter") ){
			if(name.contains(" ")){
				String firstName = fullName[0];
				String lastName = fullName[1];
				if((firstName.length() == 0) || (lastName.length() == 0)){
					sorter.setRowFilter(null);
				}else if(database.returnFirstName(firstName) == true){
					sorter.setRowFilter(RowFilter.regexFilter(firstName));
				}else if(database.returnLastName(lastName) == true){
					sorter.setRowFilter(RowFilter.regexFilter(lastName));
				}
			}else{
				sorter.setRowFilter(RowFilter.regexFilter(name));
			}
		}
	}
}
}