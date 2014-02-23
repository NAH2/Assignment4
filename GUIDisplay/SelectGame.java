import javax.swing.*;
import java.io.IOException;

//public class SelectGame extends GUIDisplay {
public class SelectGame {
	private String[] game = {"Othello", "ConnectFour"};
	private String chosenGame;

	private boolean SetGame(String chosenGame) {
		this.chosenGame = chosenGame;
		return true;
	}

	public String GetGame() {
		return chosenGame;
	}
	
	public boolean draw() {	
		chosenGame = JOptionPane.showInputDialog(null,"GAME", "Choose a game to play", JOptionPane.INFORMATION_MESSAGE, null, game, game[0])+""; //return an object so add empty string
		try {
			if(chosenGame.equals("Othello")){
				GameBoard GB = new GameBoard(true);
				GB.setVisible(true);
				//Selection SE = new Selection(chosenGame);
			} else {
				GameBoard GB = new GameBoard(false);
				//Selection SE = new Selection(chosenGame);
			}
		} catch (IOException e) {}

		return true;
	}

	//public boolean clear() {
	//}

	public static void main(String[] args) {
		SelectGame a = new SelectGame();
		a.draw();
	}
}
