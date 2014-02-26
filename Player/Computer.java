
public abstract class Computer extends Player {
	
	public abstract void setPlayer(String playerType);
	public abstract void placePiece(int[][] inCoord);
	public abstract int[][] getAvailableMoves();
	public abstract int[][] calculateMove(int[][] availableMove);   
}
