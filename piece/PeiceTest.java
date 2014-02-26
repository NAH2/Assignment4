import javax.swing.Icon;
import javax.swing.ImageIcon;

class PeiceTest {
	
	String yellowImageURL = "yellow.png";
	
	ImageIcon testIcon = new ImageIcon("yellow.png");
	
	private static void validConnectFour(){
		ConnectFourPiece("yellow");
		
		Icon icon = new Icon(ConnectFourPiece.getIcon);
		
		if (icon.equal(testIcon)){
			System.out.println("test 1: pass:");
		} else{
			System.out.println("test 1: fail:");
		}
	}
	
	public static void main(String[] args) {
		validConnectFour();
	}
}