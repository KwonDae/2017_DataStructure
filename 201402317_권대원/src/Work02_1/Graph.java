package Work02_1;

public class Graph {
	private int size;
	private String[] vertices; 
	private Node[] a; 

	public Graph(String[] args) {
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new Node[size];
		
		for (int i = 0; i < size; i++)
			a[i] = new Node(index(vertices[i]), null);
	}

	public void add(String v, String w) {
		a[index(v)].next = new Node(index(w), a[index(v)].next);
		a[index(w)].next = new Node(index(v), a[index(w)].next);
	}

	public int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return a.length;
	}

	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{");
		for (int i = 0; i < size - 1; i++) {
			buf.append(vertices[i] + ":");
			for (Node p = a[i].next; p != null; p = p.next) {
				buf.append(vertices[p.to]);
			}
			buf.append(", ");
		}
		buf.append(vertices[size - 1] + ":");
		for (Node p = a[size - 1].next; p != null; p = p.next)
			buf.append(vertices[p.to]);
		return buf + "}";
	}

	public void calc_degree() {
		int count = 0;
		System.out.println();
		System.out.println("정점" + "   인접한 정점의 갯수");
		for (int i = 0; i < size; i++) {
			for (Node p = a[i].next; p != null; p = p.next) {
				count++;
			}
			System.out.println(vertices[i] + "      " + count);
			count = 0;
		}
	}

	private class Node {
		int to;
		private Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}
}
