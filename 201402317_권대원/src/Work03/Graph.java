package Work03;

import java.util.Stack;

public class Graph {
	int size;
	String[] vertices;
	boolean[][] a;
	boolean[] visits;

	public Graph(String[] args) {	
		size = args.length;
		vertices = new String[size]; // 정점들을 저장하는 배열 초기화
		visits = new boolean[size];	// 방문여부 배열 초기화
		System.arraycopy(args, 0, vertices, 0, size);
		a = new boolean[size][size];	// 인정행렬 초기화
	}

	public void add(String v, String w) {
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = true;
	}

	private int index(String v) {
		for (int i = 0; i < size; i++) {
			if (vertices[i].equals(v))
				return i;
		}
		return a.length;
	}

	//재귀법으로 깊이 우선 탐색
	public void recu_dfs(String v) {   
		visits[index(v)] = true;
		System.out.print(v + " ");
		// 모든 인접 정점을 순회
		for (int i = 0; i < size; i++) {
			if (a[index(v)][i] && !visits[i]) {
				// 아직 방문한 적 없다면 방문한다.
				this.recu_dfs(vertices[i]);
			}
		}
		// 더이상 방문할 정점이 없으니, 재귀호출을 종료하고 이전 정점으로 돌아간다.
	}

		
	public void nonrecu_dfs(String v) {
		Stack<String> s = new Stack<String>();
		visits[index(v)] = true;
		s.push(v);
		System.out.print(v);
		while (this.search(visits)) {
			for (int i = 0; i < size; i++) {
				if (a[index(v)][i] && !visits[i]) {
					visits[i] = true;
					System.out.print(" " + vertices[i]);
					s.push(vertices[i]);
					v = vertices[i];
					i=0;
				}
			}
			v = s.pop();
		}
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
}
