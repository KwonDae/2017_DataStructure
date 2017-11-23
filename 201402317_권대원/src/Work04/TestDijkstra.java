package Work04;

public class TestDijkstra {

	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph();
		graph.dijkstra("A");
		graph.printpath("H");
}
}

