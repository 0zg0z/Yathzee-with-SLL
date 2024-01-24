
import java.util.Scanner;

public class Yathzee {

	public void GameStart() {
		HighScoreTable high=new HighScoreTable(); 
		//for inputing players name
		Scanner myObj = new Scanner(System.in);
		System.out.println("Please enter the 1.Players name:");
		Player player1 = new Player(myObj.nextLine());
		System.out.println("Please enter the 2.Players name:");
		Player player2 = new Player(myObj.nextLine());
		
		for(int i = 1; i < 11; i++ ) {             //loops the turn 10 times
			System.out.println("Turn:" + i);
			
			//throw dice 3 times for 2 player
			for (int n = 0; n < 3; n++) {
			player1.addDice(throwDice());
			player2.addDice(throwDice());
			}
			//display the dice list
			System.out.print(player1.getName() + ":  ");
			player1.getDicesList().display();
			System.out.println("       Score:" + player1.getScore());
			
			System.out.print(player2.getName() + ":  ");
			player2.getDicesList().display();
			System.out.println("       Score:" + player2.getScore());
			
			//check for yathzee and large straight and if is exist deletes from list and display the dice list again
			if(checkForYathzee(player1.getDicesList(),player1) | checkForYathzee(player2.getDicesList(),player2) | checkForLargeStraigh(player1.getDicesList(),player1) |checkForLargeStraigh(player2.getDicesList(),player2)) {
				System.out.println();
				System.out.print(player1.getName() + ":  ");
				player1.getDicesList().display();
				System.out.println("       Score:" + player1.getScore());
				
				System.out.print(player2.getName() + ":  ");
				player2.getDicesList().display();
				System.out.println("       Score:" + player2.getScore());
				System.out.println();
			}
			
		}
		Player winner;
		high.ReadFile();
		if(player1.getScore() > player2.getScore()) 
			winner = player1;
		else if(player1.getScore() < player2.getScore())
			winner = player2;
		else
			winner = new Player(player1.getName() + " & " + player2.getName(), player1.getScore());
		
		System.out.println();
		System.out.println();
		System.out.println("--------CONGRATILATIONS-------");
		System.out.println("          " + winner.getName() + " IS WON");
		System.out.println();
		high.addPlayer(winner);
		high.writeToFile();

	
	}
	
	public int throwDice() {
		return ((int)(Math.random()*6) + 1);
	}
	
	public boolean checkForYathzee(SingleLinkList List,Player player) {
		boolean is_yathzee_exist = false; 
		//navigates throught the dice list and if a number exist 4 times, deletes the 4 and add score to player
		Node temp = List.head;
		while(temp != null) {
			int a = (int)temp.getData();
			Node temp1 = temp;
			int count = 1;
			while (temp1.getLink() != null) {
				temp1 = temp1.getLink();
				if ((int)temp1.getData() == a)
					count++;
				if (count == 4) {
					deleteYathzee(a,List);
					player.addScore(10);
					is_yathzee_exist = true;
					break;
				}
			}
			temp = temp.getLink();
		}
		return is_yathzee_exist;
	}
	
	//deletes the yathzee
	public void deleteYathzee(int a,SingleLinkList List) {
		for (int i = 0; i <4; i++)
			List.remove(a);
	}
	
	
	public boolean checkForLargeStraigh(SingleLinkList List,Player player) {
		//check 1,2,3,4,5,6 is exist in dices list
		for (int i = 1; i < 7; i++) {
			boolean is_number_found = false;
			Node temp = List.head;
			while(temp != null) {
				if ((int)temp.getData() == i) {
					is_number_found = true;
					break;
				}
				temp = temp.getLink();
			}
			if (is_number_found == false) { //is a number is not exist Large Straigh not exist so function returnes false  
				return false;
			}
			
		}
		//if all of them is exist, deletes thw Large straigh and add players score 30
		deleteLargeStraight(List);
		player.addScore(30);
		return true;
	}
	
	public void deleteLargeStraight(SingleLinkList List) {
		for (int i = 1; i <7; i++)
			List.remove(i);
	}
	
}
