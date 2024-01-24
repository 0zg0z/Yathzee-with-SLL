
public class Player {
	private SingleLinkList DicesList = new SingleLinkList();
	private int Score;
	private String name;
	
	Player(String Name) {
		Score = 0;
		this.name = Name;
	}
	
	Player(String Name, int score){
		this.name = Name;
		this.Score = score;
	}

	public SingleLinkList getDicesList() {
		return DicesList;
	}

	public void addDice(int dice) {
		DicesList.add(dice);
	}

	public int getScore() {
		return Score;
	}

	public void addScore(int score) {
		Score += score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
