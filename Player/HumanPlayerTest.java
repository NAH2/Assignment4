class HumanPlayerTest {
	
	public static void validHumanTest(){
		
		System.out.println("HumanPlayer.Java - Valid Data Test");
		
		HumanPlayer humanPlayer = new HumanPlayer("Player","yellow");		
		if ((humanPlayer.GetPlayerName()).equals("Player")){
			System.out.println("test 1: pass: "+humanPlayer.GetPlayerName());
		} else {
			System.out.println("test 1: fail: "+humanPlayer.GetPlayerName());
		}
		
		if ((humanPlayer.GetPiece()).equals("yellow")){
			System.out.println("test 2: pass: "+humanPlayer.GetPiece());
		} else {
			System.out.println("test 2: fail: "+humanPlayer.GetPiece());
		}
		
		humanPlayer.SetPlayerName("Steve");
		humanPlayer.SetPieceColor("red");
		
		if ((humanPlayer.GetPlayerName()).equals("Steve")){
			System.out.println("test 3: pass: "+humanPlayer.GetPlayerName());
		} else  {
			System.out.println("test 3: fail: "+humanPlayer.GetPlayerName());
		}
		
		if ((humanPlayer.GetPiece()).equals("red")){
			System.out.println("test 4: pass: "+humanPlayer.GetPiece());
		} else  {
			System.out.println("test 4: fail: "+humanPlayer.GetPiece());
		}
	}
	
	public static void main(String[] args) {
		
		validHumanTest();
		
	}
}