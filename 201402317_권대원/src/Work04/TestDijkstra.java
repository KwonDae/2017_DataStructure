package Work04;

public class TestDijkstra {

	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph();
		graph.dijkstra("A");
		
		for(int i =0; i < graph.size; i++) {
			graph.printpath(graph.vertices[i]);
		}
	}
}

