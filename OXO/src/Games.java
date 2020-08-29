

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Games {
	public int games(int player) throws IOException {
		HashMap<String, Integer> correction_value = new HashMap<String, Integer>();
		
		switch(player){
		case 0:
			System.out.println("Player1 begins \r\n");
			correction_value.put("cv1", 0);
			correction_value.put("cv2", 1);
			break;
		default:
			System.out.println("Player2 begins \r\n");
			correction_value.put("cv1", -1);
			correction_value.put("cv2", 0);
		}
		
		int winner;
		String[] list = {"A1", "B1", "C1", "A2", "B2", "C2","A3", "B3", "C3"};
		Scanner s = new Scanner(System.in);
		ArrayList<String> arrlist = new ArrayList<String>(9);
		for(String c: list) {
			arrlist.add(c);
		}
		HashMap<String, String> coords = new HashMap<String, String>();
		for(String key: list) {
			coords.put(key, " ");
		}
		while(true){
			int whocheck = player + correction_value.get("cv1");
			if(whocheck > 0){
				switch(player%2) {
					case 1:
						System.out.println("It is player2's turn \r\n");
						break;
					default:
						System.out.println("It is player1's turn \r\n");

				}
			}
			String coordinate = s.nextLine();
			String type = s.nextLine();
			if(arrlist.contains(coordinate) && (type.equals("X") || type.equals("O") && coords.get(coordinate) == " ")) { 
				coords.put(coordinate, type);
			}
			else {
				throw new IOException("Incorrect inputs");
			}
			
			//System.out.println("\r\n");
			System.out.println("   _ _ _ _ _ _ _ _ _");
			System.out.println("  |     |     |     |");
			System.out.println("3 |  " + coords.get("A3") + "  |  " + coords.get("B3") + "  |  " + coords.get("C3") + "  |");
			System.out.println("  |_ _ _|_ _ _|_ _ _|");
			System.out.println("  |     |     |     |");
			System.out.println("2 |  " + coords.get("A2") + "  |  " + coords.get("B2") + "  |  " + coords.get("C2") + "  |");
			System.out.println("  |_ _ _|_ _ _|_ _ _|");
			System.out.println("  |     |     |     |");
			System.out.println("1 |  " + coords.get("A1") + "  |  " + coords.get("B1") + "  |  " + coords.get("C1") + "  |");
			System.out.println("  |_ _ _|_ _ _|_ _ _|");
			System.out.println("\r\n     A     B     C");
			System.out.println("\r\n");
			
			if((coords.get("B2").equals("X") && ((coords.get("A2").equals("O") && coords.get("C2").equals("O")) || (coords.get("B1").equals("O") && coords.get("B3").equals("O")) || (coords.get("A1").equals("O") && coords.get("C3").equals("O")) || (coords.get("A3").equals("O") && coords.get("C1").equals("O")))) || (coords.get("A1").equals("O") && ((coords.get("C1").equals("O") && coords.get("B1").equals("X")) || (coords.get("A3").equals("O") && coords.get("A2").equals("X")))) || (coords.get("C3").equals("O") && ((coords.get("A3").equals("O") && coords.get("B3").equals("X")) || (coords.get("C1").equals("O") && coords.get("C2").equals("X"))))){
				//if oxo, then....
				if(player%2 == 0) {
					System.out.println("Player1 wins");
					winner = 1;
				} else {
					System.out.println("Player2 wins");
					winner = 2;
				}
				break;
			}		
			
			if(++player + correction_value.get("cv1") >= 9) {
				System.out.println("It's a tie...");
				winner = 0;
				break;
			}
		}
		return winner;
	}
}
