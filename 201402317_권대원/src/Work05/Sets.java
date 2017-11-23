package Work05;

public class Sets {
	private int parent[];
	private int size;

	public Sets(int n) {
		this.size = n;
		this.parent = new int[size];
	}

	public void initialize() {
		this.parent = new int[size];
	}

	// 구현 사항1: set 배열을 입력받아서 parent 배열을 초기화한다. 집합의 Root는 index 0번째 원소로 설정한다.
	public void addSet(int set[]) {
		int set_size = set.length;
		int root = set[0];
		parent[root] = -set_size;

	}

	// 구현 사항2. Root에 속한 원소들을 출력한다.
	public void printSets() {
		int i = 0;
		while (true) {
			if (i == parent.length)
				break;
			if (parent[i] <0) {
				System.out.print("[ROOT:");
				System.out.print(i+"], { ");
				for(int x=0; x<parent.length; x++) {
					if(this.Find(x) == i && x != i) {
						System.out.print(x+" ");
					}
				}
				System.out.print("}");
				System.out.println();
			}
			i++;
		}
	}

	// 구현사항3. i가 속한 집합과 j가 속한 집합을 합집합으로 만든다
	public void weightedUnion(int i, int j) {
		if (parent[collapsingFind(i)] < parent[collapsingFind(j)]) {
			parent[collapsingFind(i)] += parent[collapsingFind(j)];
			parent[collapsingFind(j)] = i;
		}else {
			parent[collapsingFind(j)] += parent[collapsingFind(i)];
			parent[collapsingFind(i)] = j;
		}

	}

	public int collapsingFind(int i) {
		int r;
		for (r = i; parent[r] >= 0; r = parent[r]);
		while (i != r) {
			int s = parent[i];
			parent[i] = r;
			i = s;
		}
		return r;
	}
	
	public int Find(int i) {
		for(; parent[i] >= 0; i = parent[i]);
		return i;
	}
}