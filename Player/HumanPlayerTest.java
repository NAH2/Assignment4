class HumanPlayerTest {
	
	public static void validHumanTest(){
		
		HumanPlayer test = test = new HumanPlayer("Player","yellow");
		
		System.out.println("HumanPlayer.Java - Valid Data Test");
		
		System.out.println("test 1: pass: ");
			
		try{	
			if ((test.GetPlayerName()).equals("Player")){
				System.out.println("test 2: pass: ");
			} else {
				System.out.println("test 2: fail: Data not what is expected ");
			}
		} catch(Exception e){
			System.out.println("test 2: fail: Code provided exception");
		}
		
		try{
			if ((test.GetPiece()).equals("yellow")){
				System.out.println("test 3: pass: ");
			} else {
				System.out.println("test 3: fail: Data not what is expected ");
			}
		} catch(Exception e){
			System.out.println("test 3: fail: Code provided exception");
		}
			
		try{
			test.SetPlayerName("Steve"); 
			System.out.println("test 4: pass: ");
		}catch(Exception e){
			System.out.println("test 4: fail: Code provided exception");
		}
		
		try{
			test.SetPieceColor("red");
			System.out.println("test 5: pass: ");
		}catch(Exception e){
			System.out.println("test 5: fail: Code provided exception");
		}
		
		try{
			if ((test.GetPlayerName()).equals("Steve")){
				System.out.println("test 6: pass: ");
			} else  {
				System.out.println("test 6: fail: Data not what is expected");
			}
		}catch(Exception e){
			System.out.println("test 6: fail: Code provided exception");
		}
		
		try{
			if ((test.GetPiece()).equals("red")){
				System.out.println("test 7: pass: ");
			} else  {
				System.out.println("test 7: fail: Data not what is expected");
			}
		
		}catch(Exception e){
				System.out.println("test 7: fail: Code provided exception");
			}
	}
	
	public static void invalidHumanTest(){
			
			HumanPlayer test = test = new HumanPlayer("Player","yellow");
			
			System.out.println("HumanPlayer.Java - Invalid Data Test");
			
			try{
				HumanPlayer test2 = new HumanPlayer("Player","Green");
				System.out.println("test 1: pass:");
			} catch(Exception e){
				System.out.println("test 1: fail: Code could not run ");
			}
			
			try{
				 test.SetPieceColor("Blue");
				System.out.println("test 2: pass:");
			} catch(Exception e){
				System.out.println("test 2: fail: Code could not run ");
			}
			
			try{
				if ((test.GetPiece()).equals("Blue")){
					System.out.println("test 3: fail:");
				}else {
					System.out.println("test 3: pass:");
				}
			} catch(Exception e){
				System.out.println("test 3: fail: Code could not run ");
			}	
			
		}

	public static void main(String[] args) {
		try {
			validHumanTest();
		}catch(Exception e){
			System.out.println("Valid data Human Player test fail");
		}
		
		try {
			invalidHumanTest();
		} catch(Exception e) {
			System.out.println("invalid data Human Player test fail");
		}
	}
}