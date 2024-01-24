
public class SingleLinkList {
	Node head;
	
	public void add(Object data) {
		if (head == null) {
			Node newNode = new Node(data);
			head = newNode;
		}
		else {
			Node temp = head;
			while(temp.getLink() != null) {
				temp = temp.getLink();
			}
			Node newNode = new Node(data);
			temp.setLink(newNode);
		}
	}

	//for highscore table, while adding the player it sorts acording to score
	public void sortedAdd(Player data) {
		if (head == null) {
			Node newNode = new Node(data);
			head = newNode;
		}
		else {
			Player headplayer = (Player)head.getData();
			if (data.getScore() > headplayer.getScore() ) {
				Node temp = head;
				Node newNode = new Node(data);
				head = newNode;
				newNode.setLink(temp);
			}
			else {
				Node temp = head;
				while(temp.getLink() != null  && ((Player)temp.getLink().getData()).getScore() > data.getScore() ) {
					temp = temp.getLink();
				}
				Node newNode = new Node(data);
				newNode.setLink(temp.getLink());
				temp.setLink(newNode);
			}
		}
	}
	
	public int size() {
		if(head == null)
			return 0;
		else {
			int count = 0;
			
			Node temp = head;
			
			while (temp != null) {
				temp = temp.getLink();
				count++;
			}
			return count;
		}
	}
	
	public void display() {
		if (head == null) 
			System.out.println("List is empty!");
		else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getLink();
			}
		}
	}
	
	public void remove(Object dataTodelete) {
		if(head == null)
			System.out.println("linked list is empty");
		else {
			if((int)head.getData() == (int)dataTodelete) {
				head = head.getLink();
			}
			else {
				Node temp = head;
				Node previous = null;
				while(temp != null) {
					if((Integer)temp.getData() == (Integer)dataTodelete) {
						previous.setLink(temp.getLink());
						temp = previous;
						break;
					}
					previous = temp;
					temp = temp.getLink();
				}
			}
			
		}
	}
	



}
