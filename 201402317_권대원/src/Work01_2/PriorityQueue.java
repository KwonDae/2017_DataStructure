package Work01_2;

public interface PriorityQueue {
	public void add(Object object); //큐에 원소를 추가함
	public Object best(); // 큐에 null상태가 아니면 최고 우선순위를 갖는 원소를 반환
	public Object removeBest(); // 큐에 null상태가 아니면 최고 우선순위를 갖는 원소를 삭제하고 반환
	public int size(); // 큐의 크기를 반환
}
