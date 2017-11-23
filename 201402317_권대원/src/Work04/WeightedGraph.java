
package Work04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WeightedGraph {
	
	int size; //그래프 정점의 갯수
	String[] vertices; //정점들을 저장하는 배열
	String start; // 스타트정점을 저장하는 변수
	String s;
	boolean[] visits;  // 방문했는지 마크여부를 저장하는 배열
	int[][] a; // 그래프의 인접행렬
	int[] dist, prev; 
	

	
	public WeightedGraph() {
		
		try {
			/*BufferedReader Class를 활용하여 파일 읽기 구현
			 BufferedReader br = new BufferedReader(new FileReader(new File("파일경로.파일명")));
			 Line 읽기 : br.readLing(); -> String형으로 반환 파일의 끝이라면 null을 반환
			 */
			BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\goodd\\Desktop\\input.txt")));
			size = Integer.parseInt(br.readLine()); // 첫번째 줄에서 정점의 갯수 받아오기
			vertices = new String[size]; //정점배열 초기화 
			dist = new int[size]; // 최단 거리의 길이 갖는 배열 초기화
			prev = new int[size]; // 시작 정점으로 부터 최단 거리에 있는 이전 정점
			visits = new boolean[size];
			a = new int[size][size]; // 그래프의 인접행렬
			for (int i = 0; i < size; i++) {
				dist[i] = Integer.MAX_VALUE; 
				prev[i] = -1;
				for (int j = 0; j < size; j++) {
					a[i][j] = Integer.MAX_VALUE;
				}
			}
			for (int i = 0; i < size; i++) {
				vertices[i] = br.readLine();
			}
			
			while ((s = br.readLine()) != null) {  // br.readLine() 이 null을 반환할 때 까지  
				String[] result = s.split(" ");
				this.add(result[0], result[1], Integer.parseInt(result[2]));
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < size; i++) {
			a[i][i] = 0;
		}

	}

	public void add(String v, String w, int x) {
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = x;
	}

	private int index(String v) {
		for (int i = 0; i < size; i++) {
			if (vertices[i].equals(v))
				return i;
		}
		return a.length;
	}

	public void dijkstra(String v) {
		start = v;
		dist[index(v)] = 0;
		visits[index(v)] = true;
		for (int i = 1; i < size; i++) {
			if (!visits[i] && a[index(v)][i] != Integer.MAX_VALUE) {
				dist[i] = a[index(v)][i];
				prev[i] = index(v);
			}
		}
		do {
			int min = Integer.MAX_VALUE;
			int min_index = -1;
			for (int i = 0; i < size; i++) {
				if (!visits[i] && dist[i] != Integer.MAX_VALUE) {
					if (dist[i] < min) {
						min = dist[i];
						min_index = i;
					}
				}
			}
			visits[min_index] = true;
			for (int i = 0; i < size; i++) {
				if (!visits[i] && a[min_index][i] != Integer.MAX_VALUE) {
					if (dist[i] > dist[min_index] + a[min_index][i]) {
						dist[i] = dist[min_index] + a[min_index][i];
						prev[i] = min_index;
					}
				}
			}
		} while (this.search(visits));

		for (int i = 0; i < size; i++) {
			System.out.print(dist[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(prev[i] + " ");
		}
		System.out.println();
	}

	public boolean search(boolean[] x) {
		int count = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == true)
				count++;
		}

		if (count == x.length)
			return false;
		else
			return true;
	}

	public void printpath(String w) {
		int i = index(w);
		if (start.equals(w)) {
			System.out.println(w);
			System.out.println("->" + vertices[index(w)] + "(" + dist[index(w)] + ")");
			return;
		}
		if (prev[i] == index(start)) {
			System.out.println(start);
		}
		if (prev[i] != index(start)) {
			i = prev[i];
			this.printpath(vertices[i]);
		}
		System.out.println("->" + vertices[index(w)] + "(" + dist[index(w)] + ")");
	}

}


