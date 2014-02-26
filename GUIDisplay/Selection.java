/**
 * \@file -Selection.java
 * \@author -Thomas Letheby 659204 
 * \@date -25th Feb 14
 * 
 * \see SelectGame.java
 * \see GameController.java
 * \see HumanPlayer.java
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
    private int FIELD_SIZE = 10;
    private int FIELD_SIZE2 = 10;
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
     * Constructor of Selection, receives the type of game, ready for later.
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
    public String GetGameType() {
        return currentGameType;
    }

    /**
     * Accessor method to set the player ones name
     * @param playerName a String for the players name
     */
    private void setPlayerNameOne(String playerName) {
        p1Text = playerName;
    }

    /**
     * Accessor method to set the player twos name
     * @param playerName a String for the players name
     */
    private void setPlayerNameTwo(String playerName){
    	p2Text = playerName;
    }
    
   
    /**
     * The method that sets up and draws the JFrame and its corresponding elements
     */
    public void Draw() {
        ///sets up JFrame
    	display = new JFrame();
        display.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        display.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        display.setTitle("Select Players");
        
        /// Sets up the JPanels within the JFrame and set their flow layout to center
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel selectPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        /// Sets up a JComboBox and adds it to the selectPanel JPanel, also adds the action listener
        selectOpponent = new JComboBox(opponentList);
        selectOpponent.setSelectedIndex(0);
        selectOpponent.addActionListener(this);
        selectPanel.add(selectOpponent);
        
        ///sets up the players one and two JTextFields and adds the action listener + mouse listener to both
        playerOne = new JTextField("player one name:", FIELD_SIZE);
        playerTwo = new JTextField("player two name:", FIELD_SIZE2);
        playerOne.addActionListener(this);
        playerOne.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e){
        		playerOne.setText("");
        	}
        }
        );        
        playerTwo.addActionListener(this);
        playerTwo.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e){
        		playerTwo.setText("");
        	}
        }
        );        
        ///Adds the JButtons "Cancel" and "play" and adds the action listeners to both
        btn_cancel = new JButton("Cancel");
        btn_play = new JButton("Play");
        btn_cancel.addActionListener(this);
        btn_play.addActionListener(this);
        
        ///Adds the JButtons "cancel" and "play" to the JPanel btnPanel.
        btnPanel.add(btn_cancel);
        btnPanel.add(btn_play);
        
        ///Adds the JTextFields for player one and player two to the JPanel selectPanel.
        selectPanel.add(playerOne);
        selectPanel.add(playerTwo);
        
        ///adds the btnPanel to the JFrame and aligns it to the lower part of the frame
        display.add(btnPanel, BorderLayout.SOUTH);
        ///adds the selectPanel to the JFrame and sets the JFrame to be visible
        display.add(selectPanel);
        display.setVisible(true);
    	}
    
    ///Will be used for testing
    	public static void main(String args[]) {
		
		Selection selectClass = new Selection(opponentOthello); //TEST CASE
		selectClass.Draw();
		}
    	
@Override
		/**
		* Sets up the action listeners for the objects needed for Listeners
		*/	
		public void actionPerformed(ActionEvent e) {
		///This if statement implements a action listener for the JComboBox
		if (e.getSource()== selectOpponent) {
		///Setting opponent type to Human or AI 
		opponentType = (String) selectOpponent.getSelectedItem();
		}
	
		///This if statement implements a action listener for the first JTextField for player one
		if (e.getSource()== playerOne) {
		///setting the Player one name to what is typed into the text field
		setPlayerNameOne(playerOne.getText());
		}
	
		///This if statement implements a action listener for the second JTextField for player two
		if (e.getSource()== playerTwo) {
		//////setting the Player two name to what is typed into the text field
		setPlayerNameTwo(playerTwo.getText());
		}
	
		///this if statement implements a action listener for the JButton btn_cancel
		if (e.getSource()== btn_cancel) {
		///Closes the JFrame completely when button is performed
		display.dispose();
		}
	
		///The if statement implements a action listener for the JButton btn_play
		if (e.getSource()== btn_play) {
		
		///this if statement checks if the chosenGame is Othello
		if (chosenGame.equalsIgnoreCase(opponentOthello)) {
			///then the first human player is set to the piece colour black 
			HumanPlayer HuPlay = new HumanPlayer(p1Text,"black");
			
			///this if statement checks if the opponentType is a Human player
			if (opponentType.equals("Human")){
				///then the second human player is set to the piece colour white
				HumanPlayer HuPlayOpponent = new HumanPlayer(p2Text,"white");
				///closes the JFrame display entirely
				display.dispose();
				///creates a new gameController object
				GameController gameCont = new GameController(opponentOthello, huPlay, huPlayOpponent);
			}
			
			else {
				///displays a error message dialog box, explaining that AI can't be played in current version
				JOptionPane.showMessageDialog(null, "AI not available in this version.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			}
		
			///this else if statement checks whether the chosen game is Connect Four
			else if (chosenGame.equalsIgnoreCase(opponentConnectFour)) {
				///then the first human player is set to the piece colour red
				HumanPlayer HuPlay = new HumanPlayer(p1Text,"red");
			
				///this if statement checks if the opponentType is a human player
				if (opponentType.equals("Human")){
				///then the second human player is set to the piece colour yellow
				HumanPlayer HuPlayOpponent = new HumanPlayer(p2Text,"yellow");
				///closes the JFrame display entirely
				display.dispose();
				///creates a new gameController object
				GameController gameCont = new GameController(opponentConnectFour, huPlay, huPlayOpponent);
				}
				else {
				///displays a error message dialog box, explaining that AI can't be played in current version
				JOptionPane.showMessageDialog(null, "AI not available in this version.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}	
	}				
}
		

