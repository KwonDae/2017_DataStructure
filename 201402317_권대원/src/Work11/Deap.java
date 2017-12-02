package Work11;

public class Deap {
	int[] deap;
	int n = 0; // deap에 저장되는 원소의 개수, 루트는 비워져있음.
	
	static double baseLog(double x, double base) {
		return Math.log10(x) / Math.log10(base);
	}

	public Deap(int maxSize) {
		deap = new int[maxSize];
	}

	// 인덱스 i가 max-heap에 위치해 있으면 true를 리턴하고, 그렇지 않으면 false를 리턴한다
	private boolean inMaxHeap(int i) {
		while(i>2) {
			i = (i-1)/2;
		}
		if(i==2)
			return true;
		return false;

	}

	// 인덱스 pos가 min-heap에 위치해 있을때 max partner의 인덱스를 리턴한다
	private int maxPartner(int pos) {
		int square = (int)Math.floor(baseLog(pos+1,2));
		int j = pos + (int)Math.pow(2, square-1);
		if(j > n)
			j = (j-1)/2;
		return j;
	}

	// 인덱스 pos가 max-heap에 위치해 있을때 min partner의 인덱스를 리턴한다
	private int minPartner(int pos) {
		int square = (int)Math.floor(baseLog(pos+1,2));
		int j = pos - (int)Math.pow(2, square-1);
		return j;
	}

	// min-heap에 있는 인덱스 at 위치에 key를 삽입
	private void minInsert(int at, int key) {
		for(int parent; (parent=(at-1)/2) != 0 && key < deap[parent]; deap[at] = deap[parent], at = parent);
		deap[at] = key;
		
		/*deap[at] = key;	
		while(deap[(int)Math.floor((at-1)/2)] > deap[at]) {
			if(deap[(int)Math.floor((at-1)/2)] == 0)
				break;
			int temp = deap[(int)Math.floor((at-1)/2)];
			deap[(int)Math.floor((at-1)/2)] = deap[at];
			deap[at] = temp;
		
			at = (int)Math.floor((at-1)/2);
		}*/
	}

	// max-heap에 있는 인덱스 at 위치에 key를 삽입
	private void maxInsert(int at, int key) {
		for(int parent; (parent=(at-1)/2) != 0 && key > deap[parent]; deap[at] = deap[parent], at=parent);
		deap[at] = key;
		/*
		deap[at] = key;	
		while(deap[(int)Math.floor((at-1)/2)] < deap[at]) {
			if(deap[(int)Math.floor((at-1)/2)] == 0)
				break;
			int temp = deap[(int)Math.floor((at-1)/2)];
			deap[(int)Math.floor((at-1)/2)] = deap[at];
			deap[at] = temp;
		
			at = (int)Math.floor((at-1)/2);
		}
		*/

	}
	
	// max 값을 삭제하여 리턴한다
	public int deleteMax() {
		int i=2,j=0,temp = deap[n--];
		while(true) {
			j = (2*i)+1;
			if( j > n) 
				break;
			if( deap[j] > deap[j+1] ) {
				deap[i] = deap[j];
			} else {
				j = (2*i)+2;
				deap[i] = deap[j];
			}
			i = j;
		}
		j = this.minPartner(i);
		if( temp < deap[j]) {
			deap[i] = deap[j];
			this.minInsert(j, temp);
		} else {
			this.maxInsert(i, temp);
		}
		
		j = (2*j)+1;
		int minmax = deap[j];
		if(deap[j] < deap[j+1])
			minmax = deap[j+1];
		if(deap[i] < minmax) {
			int temp2 = deap[i];
			deap[i] = minmax;
			deap[j+1] = temp2;
		}
		
		return deap[2];

	}

	// min 값을 삭제하여 리턴한다
	public int deleteMin() {  
		int i=1,j=0,temp = deap[n--];
		while(true) {
			j = (2*i)+1;
			if( j > n) 
				break;
			if( deap[j] < deap[j+1] ) {
				deap[i] = deap[j];
			} else {
				j = (2*i)+2;
				deap[i] = deap[j];
			}
			i = j;
		}
		j = this.maxPartner(i);
		if( temp > deap[j]) {
			deap[i] = deap[j];
			this.maxInsert(j, temp);
		} else {
			this.minInsert(i, temp);
		}
		return deap[1];
	}

	// x를 삽입한다, 구현할 필요 없음.
	public void insert(int x) {
		if (n == deap.length - 1) {
			System.out.println("The heap is full");
			System.exit(1);
		}
		n++;

		if (n == 1) {
			deap[1] = x;
			return;
		}
		if (inMaxHeap(n)) {
			int i = minPartner(n);
			if (x < deap[i]) {
				deap[n] = deap[i];
				minInsert(i, x);
			} else {
				maxInsert(n, x);
			}
		} else {
			int i = maxPartner(n);
			if (x > deap[i]) {
				deap[n] = deap[i];
				maxInsert(i, x);
			} else {
				minInsert(n, x);
			}

		}
	}

	// Deap를 트리 형식으로 프린트한다, 구현할 필요 없음.
	public void print() {
		int levelNum = 2;
		int thisLevel = 0;
		int gap = 8;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < gap - 1; j++) {
				System.out.print(" ");
			}
			if (thisLevel != 0) {
				for (int j = 0; j < gap - 1; j++) {
					System.out.print(" ");
				}
			}
			if (Integer.toString(deap[i]).length() == 1) {
				System.out.print(" ");
			}
			System.out.print(deap[i]);
			thisLevel++;
			if (thisLevel == levelNum) {
				System.out.println();
				thisLevel = 0;
				levelNum *= 2;
				gap /= 2;
			}
		}
		System.out.println();
		if (thisLevel != 0) {
			System.out.println();
		}
	}

	// 메인 함수 작성
	public static void main(String[] argv) {
		Deap deap = new Deap(1024);
		
		int[] data = {235,33,88,63,242,423,253,332,444,48,29,87,999};
		for(int i=0;i<data.length;i++) {
			deap.insert(data[i]);
		}
		
		System.out.println("*****Initial Deap**************");
		deap.print(); 
		System.out.println("*****Delete Min**************");
		deap.deleteMin();
		deap.print();
		System.out.println("*****Delete Min**************");
		deap.deleteMin();
		deap.print();
		System.out.println("*****Delete Min**************");
		deap.deleteMin();
		deap.print();
		System.out.println("*****Delete Max**************");
		deap.deleteMax();
		deap.print();
		System.out.println("*****Delete Max**************");
		deap.deleteMax();
		deap.print();
		System.out.println("*****Delete Max**************");
		deap.deleteMax();
		deap.print();
		
	}
}

