package Work01_2;

public class HeapPriorityQueue implements PriorityQueue {
	
	private static final int capacity =100;
	private Comparable[] a;
	private int size;
	
	public HeapPriorityQueue() {
		this(capacity);
	}
	
	public HeapPriorityQueue(int capacity) {
		a = new Comparable[capacity];
	}
	
	
	@Override
	public void add(Object object) {
		if(!(object instanceof Comparable))
			throw new IllegalArgumentException();
		Comparable x = (Comparable)object;
		if (size == a.length) resize();
		int i = size++;
		while (i>0) {
			int j = i;
			i = (i-1)/2;
			if(a[i].compareTo(x) >= 0) {
				a[j] = x; return; }
			a[j] = a[i];
			}
		a[i] = x;
		System.out.println("ADD: " + object);
		}
		
	

	@Override
	public Object best() {
		if(size == 0) throw new java.util.NoSuchElementException();
		return a[0];
	}

	@Override
	public Object removeBest() {
		if(size ==0) {
			System.out.println("Heap is empty");
			System.out.println("REMOVER: null | Elements: {}");
			return 0;
		}
		Object best = best();
		a[0] = a[--size];
		heapify(0,size);
		System.out.print("REMOVE: "+ best +" | Elements: {");
		for(int i =0; i<size-1; i++) {
			System.out.print(a[i]+",");
		}
		if( size == 0) {
			System.out.print("");
		}else {
		System.out.print(a[size-1]); }
		System.out.println("}");
		return best;
	}
	
	private void heapify(int i, int n) {
		Comparable ai= a[i];
		while(i<n/2) {
			int j = 2*i +1;
			if(j+1 < n && a[j+1].compareTo(a[j]) > 0) ++j;
			if(a[j].compareTo(ai) <= 0) break;
			a[i] = a[j];
			i=j;
		}
		a[i] = ai;
	}
	
	private void resize() {
		Comparable[] aa = new Comparable[2*a.length];
		System.arraycopy(a, 0, aa, 0, a.length);
		a = aa;
	}

	@Override
	public int size() {
		
		return size;
	}

}
