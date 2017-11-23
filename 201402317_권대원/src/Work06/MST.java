package Work06;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MST {

	private int parent[]; // weightedUnion 과 collapsiongFind를 위한 배열
	private int size, e_size; // 정점의 수
	private int minCost = 0; // 최소비용
	Edge[] e;
	int edge_count = 0;

	public MST(int n) {
		this.size = n;	
		this.parent = new int[size];
		Arrays.fill(parent, -1);
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("C://input.txt")));
			// String line=br.readLine();
			// "C:\\Users\\goodd\\Desktop\\input.txt"
			String line = br.readLine();
			String[] start = line.split(" ");
			this.e_size = Integer.parseInt(start[1]); //간선개수
			e = new Edge[e_size];  // e 배열 선언
			int x = 0;
			while ((line = br.readLine()) != null) {
				String[] result = line.split(" ");
				e[x] = new Edge(Integer.parseInt(result[0]), Integer.parseInt(result[1]), Integer.parseInt(result[2]),
						false);  // e 배열 정보 넣고 초기화
				x++;
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	public void weightedUnion(int i, int j) {
		if (parent[collapsingFind(i)] < parent[collapsingFind(j)]) {
			parent[collapsingFind(i)] += parent[collapsingFind(j)];
			parent[collapsingFind(j)] = i;
		} else if (parent[collapsingFind(i)] >= parent[collapsingFind(j)]) {
			parent[collapsingFind(j)] += parent[collapsingFind(i)];
			parent[collapsingFind(i)] = j;
		}

	}

	public int collapsingFind(int i) {
		int r;
		for (r = i; parent[r] >= 0; r = parent[r])
			;
		while (i != r) {
			int s = parent[i];
			parent[i] = r;
			i = s;
		}
		return r;
	}

	public void kruskal() {
		for (int i = 0; i < e_size; i++) {
			for (int j = i + 1; j < e_size; j++) {
				if (e[i].weight > e[j].weight) {
					int temp_v = e[i].v;
					int temp_w = e[i].w;
					int temp_weight = e[i].weight;
					e[i].v = e[j].v;
					e[i].w = e[j].w;
					e[i].weight = e[j].weight;
					e[j].v = temp_v;
					e[j].w = temp_w;
					e[j].weight = temp_weight;
				}
			}
		}
		System.out.println("최소 신장 트리에 포함된 간선");
		while (edge_count < size - 1) {
			for (int x = 0; x < e_size; x++) {
				if (collapsingFind(e[x].v) != collapsingFind(e[x].w) && e[x].selected == false) {
					weightedUnion(e[x].v, e[x].w);
					e[x].selected = true;
					minCost += e[x].weight;
					edge_count++;
					System.out.print("( " + e[x].v + " , " + e[x].w + " ) ");
				}
			}
			System.out.println();
		}
		System.out.println("Min Cost : " + minCost);
	}

	public int Find(int i) {
		for (; parent[i] >= 0; i = parent[i])
			;
		return i;
	}

}

class Edge {
	int v;
	int w;
	int weight;
	boolean selected;

	Edge(int v, int w, int weight, boolean selected) {
		this.v = v;
		this.w = w;
		this.weight = weight;
		this.selected = selected;
	}
}
