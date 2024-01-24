import java.io.File;   
// Importing FileNotFoundException class for handling errors  
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
// Importing the Scanner class for reading text files  
import java.util.Scanner;   

public class HighScoreTable {
	static SingleLinkList HighScoreData = new SingleLinkList(); //highscoretable in sll form
	
	public void ReadFile() {  
        try {  
            // Create f1 object of the file to read data  
            File f1 = new File("./src/highscores.txt");    
            Scanner dataReader = new Scanner(f1);  
            int count = 0;    
            String playerName = "";
            int playerScore = 0;
            while (dataReader.hasNextLine()) {  
                String fileData = dataReader.nextLine();  //reads the line 
                count++;
                if (count%2 != 0) {    //if line count is a odd number that means line contains player name
                	playerName = fileData;
                }
                else {                 //if line count is a even number that means line contains players score
                	playerScore =Integer.valueOf(fileData);
                	//since players name and score is know a player can be created and added to highScoreData
                	Player newPlayer = new Player(playerName, playerScore);
                	HighScoreData.sortedAdd(newPlayer);
                }
            }  
            dataReader.close();
        } catch (FileNotFoundException exception) {  
            System.out.println("Unexcpected error occurred!");  
            exception.printStackTrace();  
        }  
    }  
	
	
	//for adding  a player in highscore tale
	public void addPlayer(Player player) {
		HighScoreData.sortedAdd(player);
	}
	
	//writes highscore table in a textfile
	public void writeToFile() {
		  try {  
		        FileWriter fwrite = new FileWriter("./src/highscoretable.txt");  
		        fwrite.write("     ---- HIGHSCORE TABLE------  \n");  
		        //writes the context of highscoredata to file
		    	Node temp = HighScoreData.head;
				for(int i = 1; i < 11; i++) {
					Player current = (Player) temp.getData();
					fwrite.write(i + ".   "+ current.getName() + "   " + current.getScore() + "\n");
					temp = temp.getLink();
				}
		        // Closing the stream  
		        fwrite.close();   
		        System.out.println("HighScore table is successfully wrote to the file.");  
		    } catch (IOException e) {  
		        System.out.println("Unexpected error occurred");  
		        e.printStackTrace();  
		    }  
	}
	
	
}
