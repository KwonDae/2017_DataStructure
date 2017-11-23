package Work03;

public class TestGraph {

	public static void main(String[] args) {
		Graph recu = new Graph(new String[] {"A","B","C","D","E","F","G","H"});
		recu.add("A", "B");
		recu.add("A", "E");
		recu.add("B", "C");
		recu.add("B", "F");
		recu.add("C", "D");
		recu.add("C", "H");
		recu.add("D", "H");
		recu.add("E", "F");
		recu.add("F", "G");
		
		System.out.print("recu_dfs: ");
		recu.recu_dfs("A");
		System.out.println();
		
		Graph nonrecu = new Graph(new String[] {"A","B","C","D","E","F","G","H"});
		nonrecu.add("A", "B");
		nonrecu.add("A", "E");
		nonrecu.add("B", "C");
		nonrecu.add("B", "F");
		nonrecu.add("C", "D");
		nonrecu.add("C", "H");
		nonrecu.add("D", "H");
		nonrecu.add("E", "F");
		nonrecu.add("F", "G");
		System.out.print("nonrecu_dfs: ");
		nonrecu.nonrecu_dfs("A");
		}

	}


