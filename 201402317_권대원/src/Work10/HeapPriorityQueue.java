package Work10;

public class HeapPriorityQueue {
	   private static final int CAPACITY = 100;
	   private Comparable[] a;
	   private int size;

	   public HeapPriorityQueue() {
	      this(CAPACITY);
	   }

	   public HeapPriorityQueue(int capacity) {
	      a = new Comparable[capacity];
	   }

	   public void add(Object object) { // 큐에 추가 될 때 작을 값이 먼저 나가게 큐에 추가.
	      if (!(object instanceof Comparable)) {
	         throw new IllegalArgumentException();
	      }
	      Comparable x = (Comparable) object;
	      if (size == a.length) {
	         resize();
	      }
	      int i = size++;
	      while (i > 0) {
	         int j = i;
	         i = (i - 1) / 2;
	         if (a[i].compareTo(x) <= 0) {
	            a[j] = x;
	            return;
	         }
	         a[j] = a[i];
	      }
	      a[i] = x;
	   }

	   public Object best() { // 우선순위가 높은 것을 리턴.
	      if (size == 0)
	         throw new java.util.NoSuchElementException();
	      return a[0];
	   }

	   public Object remove() { // 우선순위가 높은 순서대로 삭제.
	      Object best = best();
	      a[0] = a[--size];
	      heapify(0, size);
	      return best;
	   }

	   public int size() { // 큐의 크기.
	      return size;
	   }

	   public String toString() { // 출력.
	      if (size == 0) {
	         return "{}";
	      }
	      StringBuffer buf = new StringBuffer("{" + a[0]);
	      for (int i = 1; i < size; i++) {
	         buf.append("," + a[i]);
	      }
	      return buf + "}";
	   }

	   private void heapify(int i, int n) { // 우선순위에 맞게 큐를 정렬.
	      Comparable ai = a[i];
	      while (i < n / 2) {
	         int j = 2 * i + 1;
	         if (j + 1 < n && a[j + 1].compareTo(a[j]) < 0) {
	            ++j;
	         }
	         if (a[j].compareTo(ai) >= 0) {
	            break;
	         }
	         a[i] = a[j];
	         i = j;
	      }
	      a[i] = ai;
	   }

	   private void resize() { // 큐의 크기 재정의.
	      Comparable[] aa = new Comparable[2 * a.length];
	      System.arraycopy(a, 0, aa, 0, a.length);
	   }

	}