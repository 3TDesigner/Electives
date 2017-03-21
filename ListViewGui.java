/*
This class not only shows the students and they're electives, but allows
the user to pick which grade level and grading period they want to see.
*/
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class ListViewGui{
	//Declares instance variables
	private JFrame listFrame = new JFrame("List View");
	private MyDataBase database = new MyDataBase();
	private JTable table;
	private JTable tableQ1;
	private JTable tableQ2;
	private JTable tableQ3;
	private JTable tableQ4;
	private JTable tableT1;
	private JTable tableT2;
	private JTable tableT3;
	private TableRowSorter<TableModel>sorter;
	private TableRowSorter<TableModel>sorterQ1;
	private TableRowSorter<TableModel>sorterQ2;
	private TableRowSorter<TableModel>sorterQ3;
	private TableRowSorter<TableModel>sorterQ4;
	private TableRowSorter<TableModel>sorterT1;
	private TableRowSorter<TableModel>sorterT2;
	private TableRowSorter<TableModel>sorterT3;
	private JScrollPane scrollPane;
	private int red = 157;
	private int green = 255;
	private int blue = 0;
	
	//Creates Frame
	public void listShowFrame(int frameWidth, int frameHeight){
		listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listFrame.setSize(frameWidth, frameHeight);
		listFrame.getContentPane().setBackground(new Color(red, green, blue));
		listFrame.setLayout(new BorderLayout());
	}

	//Sets up interactors
	public void listInteractors(){
		//Declares variables 
		JPanel listPanel = new JPanel();
		JButton back = new JButton("Back");
		JMenuBar listBar = new JMenuBar();
		JMenu gradeLevel = new JMenu("Grade Level");
		JMenu gradePeriod = new JMenu("Grading Period");
		JRadioButtonMenuItem sixthGradeButton = new JRadioButtonMenuItem("6th Grade");
		JRadioButtonMenuItem seventhGradeButton = new JRadioButtonMenuItem("7th Grade");
		JRadioButtonMenuItem eighthGradeButton = new JRadioButtonMenuItem("8th Grade");
		JRadioButtonMenuItem allGradesButton = new JRadioButtonMenuItem("All Grades");
		JRadioButtonMenuItem firstQuarter = new JRadioButtonMenuItem("Q1");
		JRadioButtonMenuItem secondQuarter = new JRadioButtonMenuItem("Q2");
		JRadioButtonMenuItem thirdQuarter = new JRadioButtonMenuItem("Q3");
		JRadioButtonMenuItem fourthQuarter = new JRadioButtonMenuItem("Q4");
		JRadioButtonMenuItem firstTrimester = new JRadioButtonMenuItem("T1");
		JRadioButtonMenuItem secondTrimester = new JRadioButtonMenuItem("T2");
		JRadioButtonMenuItem thirdTrimester = new JRadioButtonMenuItem("T3");
		JRadioButtonMenuItem all = new JRadioButtonMenuItem("All");
		ButtonGroup gradeGroup = new ButtonGroup();
		ButtonGroup gradePeriodGroup = new ButtonGroup();
		database.selectTable();
		Object[][] tableData = database.createTableData();
		database.selectQ1();
		Object[][] dataQ1 = database.createQ1Data();
		database.selectQ2();
		Object[][] dataQ2 = database.createQ2Data();
		database.selectQ3();
		Object[][] dataQ3 = database.createQ3Data(); 
		database.selectQ4();
		Object[][] dataQ4 = database.createQ4Data();
		database.selectT1();
		Object[][] dataT1 = database.createT1Data(); 
		database.selectT2();
		Object[][] dataT2 = database.createT2Data();
		database.selectT3();
		Object[][] dataT3 = database.createT3Data();
		String[] columnNames = {"First Name", "Last Name", "Grade", "Gender", "Q1", 
			"Q2", "Q3", "Q4", "T1", "T2", "T3"};
		String[] columnNamesQ1 = {"First Name", "Last Name", "Grade", "Q1"};
		String[] columnNamesQ2 = {"First Name", "Last Name", "Grade", "Q2"};
		String[] columnNamesQ3 = {"First Name", "Last Name", "Grade", "Q3"};
		String[] columnNamesQ4 = {"First Name", "Last Name", "Grade", "Q4"};
		String[] columnNamesT1 = {"First Name", "Last Name", "Grade", "T1"};
		String[] columnNamesT2 = {"First Name", "Last Name", "Grade", "T2"};
		String[] columnNamesT3 = {"First Name", "Last Name", "Grade", "T3"};
		TableModel model = new DefaultTableModel(tableData, columnNames);
		TableModel modelQ1 = new DefaultTableModel(dataQ1, columnNamesQ1);
		TableModel modelQ2 = new DefaultTableModel(dataQ2, columnNamesQ2);
		TableModel modelQ3 = new DefaultTableModel(dataQ3, columnNamesQ3);
		TableModel modelQ4 = new DefaultTableModel(dataQ4, columnNamesQ4);
		TableModel modelT1 = new DefaultTableModel(dataT1, columnNamesT1);
		TableModel modelT2 = new DefaultTableModel(dataT2, columnNamesT2);
		TableModel modelT3 = new DefaultTableModel(dataT3, columnNamesT3);
			
		//Sets up panel
		listPanel.setBackground(new Color(red, green, blue));
		
		//Back Button
		back.setForeground(Color.RED);
		back.addActionListener(new EndingListener());
		listPanel.add(back);
		
		//Radio buttons for the grade level
		sixthGradeButton.addActionListener(new EndingListener());
		gradeLevel.add(sixthGradeButton);
	
		seventhGradeButton.addActionListener(new EndingListener());
		gradeLevel.add(seventhGradeButton);
		
		eighthGradeButton.addActionListener(new EndingListener());
		gradeLevel.add(eighthGradeButton);
		
		allGradesButton.addActionListener(new EndingListener());
		gradeLevel.add(allGradesButton);
		
		//Places the radio buttons in a group
		gradeGroup.add(sixthGradeButton);
		gradeGroup.add(seventhGradeButton);
		gradeGroup.add(eighthGradeButton);
		gradeGroup.add(allGradesButton);
		
		//Radio buttons for the grade period
		firstQuarter.addActionListener(new EndingListener());
		gradePeriod.add(firstQuarter);
		
		secondQuarter.addActionListener(new EndingListener());
		gradePeriod.add(secondQuarter);

		thirdQuarter.addActionListener(new EndingListener());
		gradePeriod.add(thirdQuarter);
		
		fourthQuarter.addActionListener(new EndingListener());
		gradePeriod.add(fourthQuarter);
		
		firstTrimester.addActionListener(new EndingListener());
		gradePeriod.add(firstTrimester);
		
		secondTrimester.addActionListener(new EndingListener());
		gradePeriod.add(secondTrimester);
		
		thirdTrimester.addActionListener(new EndingListener());
		gradePeriod.add(thirdTrimester);
		
		all.addActionListener(new EndingListener());
		gradePeriod.add(all);
		
		//Button group for grade period
		gradePeriodGroup.add(firstQuarter);
		gradePeriodGroup.add(secondQuarter);
		gradePeriodGroup.add(thirdQuarter);
		gradePeriodGroup.add(fourthQuarter);
		gradePeriodGroup.add(firstTrimester);
		gradePeriodGroup.add(secondTrimester);
		gradePeriodGroup.add(thirdTrimester);
		gradePeriodGroup.add(all);
		
		//Places items in menu bar
		listBar.add(gradeLevel);
		listBar.add(gradePeriod);
		
		/*Table*/
		//Creates the entire table
    table = new JTable(model);
    sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
		scrollPane = new JScrollPane(table);
		
		//Creates the table for quarter 1 
		tableQ1 = new JTable(modelQ1);
		sorterQ1 = new TableRowSorter<TableModel>(modelQ1);
		tableQ1.setRowSorter(sorterQ1);
		
		//Creates the table for quarter 2
		tableQ2 = new JTable(modelQ2);
		sorterQ2 = new TableRowSorter<TableModel>(modelQ2);
		tableQ2.setRowSorter(sorterQ2);
		
		//Creates the table for quarter 3
		tableQ3 = new JTable(modelQ3);
		sorterQ3 = new TableRowSorter<TableModel>(modelQ3);
		tableQ3.setRowSorter(sorterQ3);
		
		//Creates the table for quarter 4
		tableQ4 = new JTable(modelQ4);
		sorterQ4 = new TableRowSorter<TableModel>(modelQ4);
		tableQ4.setRowSorter(sorterQ4);
		
		//Creates the table for trimester 1
		tableT1 = new JTable(modelT1);
		sorterT1 = new TableRowSorter<TableModel>(modelT1);
		tableT1.setRowSorter(sorterT1);
		
		//Creates the table for trimester 2
		tableT2 = new JTable(modelT2);
		sorterT2 = new TableRowSorter<TableModel>(modelT2);
		tableT2.setRowSorter(sorterT2);
		
		//Creates the table for trimester 3
		tableT3 = new JTable(modelT3);
		sorterT3 = new TableRowSorter<TableModel>(modelT3);
		tableT3.setRowSorter(sorterT3);
		
		//Add Contents
		listFrame.setJMenuBar(listBar);
		listFrame.add(scrollPane, BorderLayout.CENTER);
		listFrame.add(listPanel, BorderLayout.NORTH);
		listFrame.setVisible(true);
	}
	
//This class helps filter the data in the database
public class EndingListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//Declares variables
		String buttonCommand =  e.getActionCommand();
		MenuGui backGui = new MenuGui();
		
		//Goes back to the Menu
		if(buttonCommand.equals("Back")){
			listFrame.setVisible(false);
			backGui.setWindow();
			backGui.Interactors();
		}
		//Filters the JTable so that only certain grade levels or periods show up
		else if(buttonCommand.equals("6th Grade")){
			sorter.setRowFilter(RowFilter.regexFilter("6"));
			sorterQ1.setRowFilter(RowFilter.regexFilter("6"));
			sorterQ2.setRowFilter(RowFilter.regexFilter("6"));
			sorterQ3.setRowFilter(RowFilter.regexFilter("6"));
			sorterQ4.setRowFilter(RowFilter.regexFilter("6"));
			sorterT1.setRowFilter(RowFilter.regexFilter("6"));
			sorterT2.setRowFilter(RowFilter.regexFilter("6"));
			sorterT3.setRowFilter(RowFilter.regexFilter("6"));
		}
		else if(buttonCommand.equals("7th Grade")){
			sorter.setRowFilter(RowFilter.regexFilter("7"));
			sorterQ1.setRowFilter(RowFilter.regexFilter("7"));
			sorterQ2.setRowFilter(RowFilter.regexFilter("7"));
			sorterQ3.setRowFilter(RowFilter.regexFilter("7"));
			sorterQ4.setRowFilter(RowFilter.regexFilter("7"));
			sorterT1.setRowFilter(RowFilter.regexFilter("7"));
			sorterT2.setRowFilter(RowFilter.regexFilter("7"));
			sorterT3.setRowFilter(RowFilter.regexFilter("7"));
		}
		else if(buttonCommand.equals("8th Grade")){
			sorter.setRowFilter(RowFilter.regexFilter("8"));
			sorterQ1.setRowFilter(RowFilter.regexFilter("8"));
			sorterQ2.setRowFilter(RowFilter.regexFilter("6"));
			sorterQ3.setRowFilter(RowFilter.regexFilter("8"));
			sorterQ4.setRowFilter(RowFilter.regexFilter("8"));
			sorterT1.setRowFilter(RowFilter.regexFilter("8"));
			sorterT2.setRowFilter(RowFilter.regexFilter("8"));
			sorterT3.setRowFilter(RowFilter.regexFilter("8"));
		}
		else if(buttonCommand.equals("All Grades")){
			sorter.setRowFilter(null);
			sorterQ1.setRowFilter(null);
			sorterQ2.setRowFilter(null);
			sorterQ3.setRowFilter(null);
			sorterQ4.setRowFilter(null);
			sorterT1.setRowFilter(null);
			sorterT2.setRowFilter(null);
			sorterT3.setRowFilter(null);
		}
		else if(buttonCommand.equals("Q1")){
			scrollPane.getViewport().remove(table);
			scrollPane.getViewport().remove(tableQ1);
			scrollPane.getViewport().remove(tableQ2);
			scrollPane.getViewport().remove(tableQ3);
			scrollPane.getViewport().remove(tableQ4);
			scrollPane.getViewport().remove(tableT1);
			scrollPane.getViewport().remove(tableT2);
			scrollPane.getViewport().remove(tableT3);
			scrollPane.getViewport().add(tableQ1);
		}
		else if(buttonCommand.equals("Q2")){
			scrollPane.getViewport().remove(table);
			scrollPane.getViewport().remove(tableQ1);
			scrollPane.getViewport().remove(tableQ2);
			scrollPane.getViewport().remove(tableQ3);
			scrollPane.getViewport().remove(tableQ4);
			scrollPane.getViewport().remove(tableT1);
			scrollPane.getViewport().remove(tableT2);
			scrollPane.getViewport().remove(tableT3);
			scrollPane.getViewport().add(tableQ2);
		}
		else if(buttonCommand.equals("Q3")){
			scrollPane.getViewport().remove(table);
			scrollPane.getViewport().remove(tableQ1);
			scrollPane.getViewport().remove(tableQ2);
			scrollPane.getViewport().remove(tableQ3);
			scrollPane.getViewport().remove(tableQ4);
			scrollPane.getViewport().remove(tableT1);
			scrollPane.getViewport().remove(tableT2);
			scrollPane.getViewport().remove(tableT3);
			scrollPane.getViewport().add(tableQ3);
		}
		else if(buttonCommand.equals("Q4")){
			scrollPane.getViewport().remove(table);
			scrollPane.getViewport().remove(tableQ1);
			scrollPane.getViewport().remove(tableQ2);
			scrollPane.getViewport().remove(tableQ3);
			scrollPane.getViewport().remove(tableQ4);
			scrollPane.getViewport().remove(tableT1);
			scrollPane.getViewport().remove(tableT2);
			scrollPane.getViewport().remove(tableT3);
			scrollPane.getViewport().add(tableQ4);
		}
		else if(buttonCommand.equals("T1")){
			scrollPane.getViewport().remove(table);
			scrollPane.getViewport().remove(tableQ1);
			scrollPane.getViewport().remove(tableQ2);
			scrollPane.getViewport().remove(tableQ3);
			scrollPane.getViewport().remove(tableQ4);
			scrollPane.getViewport().remove(tableT1);
			scrollPane.getViewport().remove(tableT2);
			scrollPane.getViewport().remove(tableT3);
			scrollPane.getViewport().add(tableT1);
		}
		else if(buttonCommand.equals("T2")){
			scrollPane.getViewport().remove(table);
			scrollPane.getViewport().remove(tableQ1);
			scrollPane.getViewport().remove(tableQ2);
			scrollPane.getViewport().remove(tableQ3);
			scrollPane.getViewport().remove(tableQ4);
			scrollPane.getViewport().remove(tableT1);
			scrollPane.getViewport().remove(tableT2);
			scrollPane.getViewport().remove(tableT3);
			scrollPane.getViewport().add(tableT2);
		}
		else if(buttonCommand.equals("T3")){
			scrollPane.getViewport().remove(table);
			scrollPane.getViewport().remove(tableQ1);
			scrollPane.getViewport().remove(tableQ2);
			scrollPane.getViewport().remove(tableQ3);
			scrollPane.getViewport().remove(tableQ4);
			scrollPane.getViewport().remove(tableT1);
			scrollPane.getViewport().remove(tableT2);
			scrollPane.getViewport().remove(tableT3);
			scrollPane.getViewport().add(tableT3);
		}
		else if(buttonCommand.equals("All")){
			scrollPane.getViewport().remove(table);
			scrollPane.getViewport().remove(tableQ1);
			scrollPane.getViewport().remove(tableQ2);
			scrollPane.getViewport().remove(tableQ3);
			scrollPane.getViewport().remove(tableQ4);
			scrollPane.getViewport().remove(tableT1);
			scrollPane.getViewport().remove(tableT2);
			scrollPane.getViewport().remove(tableT3);
			scrollPane.getViewport().add(table);
		}
	}
}
}