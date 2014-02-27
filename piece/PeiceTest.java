import javax.swing.Icon;
import javax.swing.ImageIcon;

class PeiceTest {
	
	private static void validConnectFour(){
		ConnectFourPiece c4 = new ConnectFourPiece ("yellow");
		
		//Icon icon = new Icon(c4.getIcon);
		
		if ((c4.getIcon()).equals(c4.getIcon())){
			System.out.println("test 1: pass:");
		} else{
			System.out.println("test 1: fail:");
		}
	}
	
	public static void main(String[] args) {
		validConnectFour();
	}
}