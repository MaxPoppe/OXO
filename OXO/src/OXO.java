import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OXO {
	public static void main(String[]args)throws IOException{
		int winner;
		int wincount1 = 0;
		int wincount2 = 0;
		Games object = new Games();
		Scanner s = new Scanner(System.in);
		HashMap<String, Boolean> stop = new HashMap<String, Boolean>(); 
		stop.put("stop", true);
		int gamecount = 0;
		
		while(stop.get("stop")) {
			try {
				winner = object.games(gamecount++%2);
			} catch (IOException e) {
				throw new IOException("Incorrect inputs");
			}
			
			switch(winner) {
				case 1:
					++wincount1;
					break;
				case 2:
					++wincount2;
					break;
				default:
			}
			
			System.out.println("\r\n");
			System.out.println("Player1 wins: " + wincount1);
			System.out.println("Player2 wins: " + wincount2);
			System.out.println("\r\n");
			
			System.out.println("If you don't wanna play anymore type 'stop', otherwise press <Enter>");
			String checker = s.nextLine();
			if(checker.equals("stop")) {
				stop.put("stop", false);
			}
		}
	}
}
