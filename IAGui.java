/*
This class is the start of the code. It calls upon the 
class MenuGui to set its windows and interactors, and 
therefore starting the program.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IAGui{
	
	public static void main(String[] args){
		//Creates an instance of the class Menu Gui
		MenuGui myMenuGui = new MenuGui();
		myMenuGui.setWindow();
		myMenuGui.Interactors();
	}
}