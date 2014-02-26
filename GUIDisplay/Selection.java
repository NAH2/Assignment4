/**
 * \@file -Selection.java
 * \@author -Thomas Letheby 659204 
 * \@date -25th Feb 14
 * 
 * \see SelectGame.java
 * \see something
 * 
 * \brief Selection class, used to allow the user to select opponent names, opponent types 
 * 
 * The class is a user interface to select name and opponent type
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Selection implements ActionListener {

    private String currentGameType;
    private String chosenGame;
    private int FRAME_WIDTH = 250;
    private int FRAME_HEIGHT = 250;
    private JFrame display;
    private JPanel btnPanel;
    private JPanel selectPanel;
    private String[] opponentList = {"Human", "AI"};
    private String opponentType = "Human";
    private String p1Text = "playerOne";
    private String p2Text = "playerTwo";
    private static String opponentOthello = "Othello";
    private static String opponentConnectFour = "ConnectFour";
    private JButton btn_cancel, btn_play;
    private JTextField playerOne, playerTwo;
    private JComboBox selectOpponent;

    /**
     * constructor of Selection, receives the type of game, ready for later.
     * @param chosenGame a String for the chosen game.
     */
    public Selection(String chosenGame) {
        this.chosenGame = chosenGame;
      }
 
    /**
     * Accessor method to set the current game type 
     * @param GameType a string for the current game type
     */
    private void setGameType(String GameType) {
        currentGameType = GameType;
    }
    
    /**
     * Accessor method to get the current game type
     * @return currentGameType a String of what the current game type is
     */    
    public String getGameType() {
        return currentGameType;
    }

    private void setPlayerNameOne(String playerName) {
        p1Text = playerName;
    }

    private void setPlayerNameTwo(String playerName){
    	p2Text=playerName;
    }
    
   
    public void draw() {
        display = new JFrame();

        display.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        display.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        display.setTitle("Select Players");

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel selectPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        selectOpponent = new JComboBox(opponentList);
        selectOpponent.setSelectedIndex(0);
        selectOpponent.addActionListener(this);
        selectPanel.add(selectOpponent);
        JLabel oppoLevel = new JLabel("Select Opponent Level");
        playerOne = new JTextField("player one name:", 20);
        playerTwo = new JTextField("player two name:", 20);
        playerOne.addActionListener(this);
        playerOne.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e){
        		playerOne.setText("");
        	}
        });
        
        playerTwo.addActionListener(this);
        playerTwo.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e){
        		playerTwo.setText("");
        	}
        });
        btn_cancel = new JButton("Cancel");
        btn_play = new JButton("Play");
        btn_cancel.addActionListener(this);
        btn_play.addActionListener(this);
        btnPanel.add(btn_cancel);
        btnPanel.add(btn_play);
        selectPanel.add(playerOne);
        selectPanel.add(playerTwo);

        display.add(btnPanel, BorderLayout.SOUTH);
        display.add(selectPanel);
        display.setVisible(true);

    }
    
    
public static void main(String args[]) {
		
		Selection selectClass = new Selection(opponentOthello); //test case
		selectClass.draw();
		}

@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource()== selectOpponent) {
		opponentType = (String) selectOpponent.getSelectedItem();
		System.out.println(opponentType);
	}
	if (e.getSource()== playerOne) {
		setPlayerNameOne(playerOne.getText());
		System.out.println(p1Text);
	}
	if (e.getSource()== playerTwo) {
		setPlayerNameTwo(playerTwo.getText());
		System.out.println(p2Text);
	}
	if (e.getSource()== btn_cancel) {
		display.dispose();
	}
	
	if (e.getSource()== btn_play) {
		GameController gameCont = new GameController();
		if (chosenGame.equalsIgnoreCase(opponentOthello)) {
			//HumanPlayer HuPlay = new HumanPlayer(p1Text,"black");
			if (opponentType.equals("Human")){
				//HumanPlayer HuPlayOpponent = new HumanPlayer(p2Text,"white");
				display.dispose();
				GameController gameCont = new GameController(opponentOthello, huPlay, huPlayOpponent);
			}
			else {
				JOptionPane.showMessageDialog(null, "AI not available in this version.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			}
		else if (chosenGame.equalsIgnoreCase(opponentConnectFour)) {
			//HumanPlayer HuPlay = new HumanPlayer(p1Text,"red");
			if (opponentType.equals("Human")){
				//HumanPlayer HuPlayOpponent = new HumanPlayer(p2Text,"yellow");
				display.dispose();
				GameController gameCont = new GameController(opponentConnectFour, huPlay, huPlayOpponent);
			}
			else {
				JOptionPane.showMessageDialog(null, "AI not available in this version.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			}
	}
	
	
	
}
		
		
}
		//jframe for options to be selected

