import javax.swing.*;

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
		return true;
	}

	//public boolean clear() {
	//}
	/*public static void main(String[] args) {
		SelectGame a = new SelectGame();
		a.draw();
		System.out.print
	}*/
}
