/*
	Author Tyrone Lee Bramwell
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class SelectGame {

	JFrame display;
	JButton othello_Button;	
	JButton connectFour_Button;
	JPanel content;
	JLabel title_Label;
	JLabel blank_Label;
	
	Font fontSettings = new Font ("Dialog", Font.PLAIN, 15);
	
	public void draw() {	
		
		display = new JFrame ("Select Game");
	

		display.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		othello_Button = new JButton("Othello");
		
		connectFour_Button = new JButton("Connect Four");
		
		content = new JPanel (new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		title_Label= new JLabel ("Please Select a Game");
		blank_Label= new JLabel("");// Blank label used to fill empty space on gridlayout.
		
		title_Label.setFont(fontSettings);
		
		content.add(title_Label);
		
		c.gridwidth=2;
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 0;
		c.gridy = 0;
		content.add(title_Label, c);
		c.gridwidth=1;
		c.gridx = 0;
		c.gridy = 1;
		content.add(othello_Button, c);
		
		c.gridx = 1;
		c.gridy = 1;
		content.add(connectFour_Button, c);
		
		
		GUIEventHandler handler = new GUIEventHandler();
		
		othello_Button.addActionListener(handler);
		connectFour_Button.addActionListener(handler);
		display.add(content);

		display.pack();	
		display.setVisible(true);
	}
	
	private class GUIEventHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			Selection s = new Selection(); 
			
			if (event.getSource()==othello_Button){
				s.setGameType("othello");
				display.dispose();
			}
			
			if (event.getSource()==connectFour_Button){
				s.setGameType("connectFour");
				display.dispose();
			}
		}
	}

	public static void main(String[] args) {
		SelectGame sg = new SelectGame();
		sg.draw();
	}
}
