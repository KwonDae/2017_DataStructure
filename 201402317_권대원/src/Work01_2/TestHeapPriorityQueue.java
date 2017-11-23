package Work01_2;

public class TestHeapPriorityQueue {

	public static void main(String[] args) {
		HeapPriorityQueue queue = new HeapPriorityQueue();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.removeBest();
		queue.add(6);
		queue.add(7);
		queue.add(8);
		queue.add(9);
		queue.add(10);
		queue.removeBest();
		queue.removeBest();
		queue.removeBest();
		queue.removeBest();
		queue.removeBest();
		queue.removeBest();
		queue.removeBest();
		queue.removeBest();
		queue.removeBest();
		queue.removeBest();
		
		
		
	}

}
