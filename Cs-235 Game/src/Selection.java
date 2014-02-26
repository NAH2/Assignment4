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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Player.HumanPlayer;

import java.awt.event.*;
import java.awt.*;
import java.util.EventObject;

public class Selection implements ActionListener {


	/**
	 * Constructor of Selection, receives the type of game, ready for later. 
	 * @param chosenGame a String for the chosen game.
	 */
	public Selection(String chosenGame) {
		setGameType(chosenGame);
		draw();
	}

	/**
	 * Accessor method to set the current game type
	 * @param GameType a string for the current game type
	 */
	private void setGameType(String GameType) {
		m_currentGameType = GameType;
	}

	/**
	 * Accessor method to get the current game type
	 * @return currentGameType a String of what the current game type is
	 */
	public String GetGameType() {
		return m_currentGameType;
	}

	/**
	 * Accessor method to set the player ones name
	 * @param playerName a String for the players name
	 */
	private void setPlayerNameOne(String playerName) {
		m_p1Text = playerName;
	}

	/**
	 * Accessor method to set the player twos name
	 * @param playerName a String for the players name
	 */
	private void setPlayerNameTwo(String playerName) {
		m_p2Text = playerName;
	}

	/** The method that sets up and draws the JFrame and its corresponding elements*/
	public void draw() {
		/** sets up JFrame*/
		displaySelection = new JFrame();
		displaySelection.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		displaySelection.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		displaySelection.setTitle("Select Players");

		/**  Sets up the JPanels within the JFrame and set their flow layout to centre*/
		btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		selectPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		comboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		/** Sets up a JComboBox and adds it to the selectPanel JPanel, also adds the action listener*/
		selectOpponent = new JComboBox(opponentList);
		selectOpponent.setSelectedIndex(0);
		selectOpponent.addActionListener(this);
		comboPanel.add(selectOpponent);

		/**sets up the players one and two JTextFields and adds the actionlistener + mouse listener to both, clears contents currently in JTextField*/
		playerOne = new JTextField("Player One Name:", FIELD_SIZE);
		playerTwo = new JTextField("Player Two Name:", FIELD_SIZE);
		playerOne.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				playerOne.setText("");
			}
		});
		playerTwo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				playerTwo.setText("");
			}
		});
		/** Adds the JButtons "Cancel" and "play" and adds the action listeners to both*/
		btn_cancel = new JButton("Cancel");
		btn_play = new JButton("Play");
		btn_cancel.addActionListener(this);
		btn_play.addActionListener(this);

		/** Adds the JButtons "cancel" and "play" to the JPanel btnPanel.*/
		btnPanel.add(btn_cancel);
		btnPanel.add(btn_play);

		/*** Adds the JTextFields for player one and player two to the JPanel selectPanel.*/
		selectPanel.add(playerOne);
		selectPanel.add(playerTwo);

		displaySelection.add(comboPanel, BorderLayout.NORTH);
		/** adds the btnPanel to the JFrame and aligns it to SOUTH of frame*/
		displaySelection.add(btnPanel, BorderLayout.SOUTH);
		/** adds the selectPanel to the JFrame and sets the JFrame to be visible*/
		displaySelection.add(selectPanel, BorderLayout.CENTER);
		/** sets the displaySelection JFrame displaySelection to be visible, so that it can't be resized and to centre the JFrame*/
		displaySelection.setVisible(true);
		displaySelection.setResizable(false);
		displaySelection.setLocationRelativeTo(null);
	}

	/** Sets up the action listeners for the objects needed for Listeners */
	public void actionPerformed(ActionEvent e) {
	     if (e.getSource() == btn_cancel) {
            /**Closes the JFrame completely when button is performed*/
	         displaySelection.dispose();
        }
	    
		/**This if statement implements a action listener for the JComboBox */
		if (e.getSource() == selectOpponent) {
			/**Setting opponent type to Human or AI*/
			m_opponentType = (String) selectOpponent.getSelectedItem();
		}

		/**The if statement implements a action listener for the JButton btn_play*/
		if (e.getSource() == btn_play) {
			/**setting the Player one name to what is typed into the text field*/
			setPlayerNameOne(playerOne.getText());
			/**setting the Player two name to what is typed into the text field*/
			setPlayerNameTwo(playerTwo.getText());
			/**this if statement checks if the chosenGame is Othello*/
			if (m_currentGameType.equalsIgnoreCase(opponentOthello)) {
				/**then the first human player is set to the piece colour black*/
				HumanPlayer HuPlay = new HumanPlayer(m_p1Text, m_black);

				/**this if statement checks if the opponentType is a Human player*/
				if (m_opponentType.equals("Human")) {
					/**then the second human player is set to the piece colour white*/
					HumanPlayer HuPlayOpponent = new HumanPlayer(m_p2Text,m_white);
					/**closes the JFrame displaySelection entirely*/
					
					/**creates a new gameController object*/
					GameController gameCont = new GameController(opponentOthello, HuPlay, HuPlayOpponent);
	                System.out.println("Othello BOOM");
	                displaySelection.dispose();
	                }
				else {
					/**displaySelections a error message dialog box, explaining that AI can't be played in current version*/
					JOptionPane.showMessageDialog(null,"AI not available in this version.", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}

			/**this else if statement checks whether the chosen game is Connect Four*/
			else if (m_currentGameType.equalsIgnoreCase(opponentConnectFour)) {
				/**then the first human player is set to the piece colour red*/
				HumanPlayer HuPlay = new HumanPlayer(m_p1Text, m_red);

				/**this if statement checks if the opponentType is a human player*/
				if (m_opponentType.equals("Human")) {
					/**then the second human player is set to the piece colour yellow*/
					HumanPlayer HuPlayOpponent = new HumanPlayer(m_p2Text,m_yellow);
					/**closes the JFrame displaySelection entirely*/
					displaySelection.dispose();
					/**creates a new gameController object*/
					GameController gameCont = new GameController(opponentConnectFour, HuPlay, HuPlayOpponent);
					System.out.println("create c4");
				} else {
					/**displaySelections a error message dialog box, explaining that AI can't be played in current version*/
					JOptionPane.showMessageDialog(null,	"AI not available in this version.", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	public static void main(String args[]){
		Selection select = new Selection(opponentOthello);
	}

	
	/**The JFrame name for displaying.*/
    private JFrame displaySelection;
	/**value for the display frame width*/
	private final int FRAME_WIDTH = 300;
	/**value for the display frame Height*/
	private final int FRAME_HEIGHT = 125;
	
	/**The Panels to keep all elements on in the JFrame*/
	private JPanel btnPanel,selectPanel, comboPanel;
	
	/**The JComboBox */
	private JComboBox selectOpponent;
	/**The list of values for the JComboBox*/
	private String[] opponentList = { "Human", "AI" };
	/**Initialising the opponent type in case the player doesn's select an option from the JComboBox */
	private String m_opponentType = "Human";
	
	
	/**The String of the black piece stored*/
	private String m_black = "black";
	/**The String of the white piece stored*/
	private String m_white = "white";
	/**The String of the yellow piece stored*/
	private String m_yellow = "yellow";
	/**The String of the red piece stored*/
	private String m_red = "red";
	
	/**The JButtons used in the display*/
	private JButton btn_cancel, btn_play;
	/**The JTextFields used in the display */
	private JTextField playerOne, playerTwo;
	
	
	/**Number of character spaces in JTextField*/
	private final int FIELD_SIZE = 10;
	/**Initialising text to pass as parameter if user doesn't change the value in JTextField*/
	private String m_p1Text = "playerOne";
	/**Initialising text to pass as parameter if user doesn't change the value in JTextField*/
	private String m_p2Text = "playerTwo";
	
	/**Stores the game type that is passed through from SelectGame.java*/
	private String m_currentGameType;
	/**The Othello String used throughout the class*/
	private static String opponentOthello = "Othello";
	/**The Connect Four String used throughout the class*/
	private static String opponentConnectFour = "ConnectFour";
}
