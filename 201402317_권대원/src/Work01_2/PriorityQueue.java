package Work01_2;

public interface PriorityQueue {
	public void add(Object object); //ť�� ���Ҹ� �߰���
	public Object best(); // ť�� null���°� �ƴϸ� �ְ� �켱������ ���� ���Ҹ� ��ȯ
	public Object removeBest(); // ť�� null���°� �ƴϸ� �ְ� �켱������ ���� ���Ҹ� �����ϰ� ��ȯ
	public int size(); // ť�� ũ�⸦ ��ȯ
}
