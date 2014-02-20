import java.awt.event.MouseEvent;

int[][] gameboard;

public class HumanPlayer extends Player {
	
	public static void main(String args[]){
		HumanPlayer hP = new HumanPlayer();
	}

	public void setPlayer(String playerType){}
	
	public void setPlayerText(String name){}
	
	public void placePiece(int[][] inCoord){
		
		if(validMove(inCoord) == true){
			
		}
		
	}
	
	public boolean validMove(int[][] inCoord){
		boolean bool = false;
		return bool;
	}
	
	public int[][] mouseReleased(MouseEvent e){
		int[][] position = null;
		return position;
	}
	
	public int[][] lastPiecePlaced(){
		int[][] position =null;
		return position;
	}
	
	public void updateLastPiece(int[][] coord){}
}
