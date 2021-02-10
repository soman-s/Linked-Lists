
public class doubleyLinkedList{

	class Node{
		public int value;
		public Node next;
		public Node previous;
	}

	private Node head = null;
	private Node tail = null;
	Node prev = null;

	
	public void insert(int newValue){
		
		Node newNode = new Node();	
		newNode.value = newValue;

		if (head == null){
			head = newNode;
			tail = newNode;
		}
		else if(newNode.value < head.value){
			newNode.next = head;
			newNode.previous = null;
			head = newNode;
		}
		else{
			Node current = head;
			Node prev = null;

			while (newNode.value > current.value){
				prev = current;
				current = current.next;

				if (current.next == null){
					break;
				}
			}

			if (current.next != null){
				newNode.next = current;
				newNode.previous = prev;
				prev.next = newNode;
			}

			if (current.next == null){
				current.next = newNode;
				newNode.previous = current;
				newNode.next = null;
			}
		}
	}

    public String toString(){
		String result = "[ ";

		Node current = head;

		while (current != null){
			result += current.value + " ";
			current = current.next;
		}

		return result + "]";
	}


    public static void main(String[] args){
        doubleyLinkedList numbers = new doubleyLinkedList();

        numbers.insert(8);
		numbers.insert(4);
        numbers.insert(11);
        numbers.insert(18);
        numbers.insert(7);
        numbers.insert(0);
        numbers.insert(2);
		numbers.insert(1);
		numbers.insert(5);
		
        System.out.println(numbers);
    }
}