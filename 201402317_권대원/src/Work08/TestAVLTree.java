package Work08;

public class TestAVLTree {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree(1);
		for(int i =2; i<11; i++) 
			tree.add(i);
		System.out.println(tree.toString());
		tree.search(1);
		tree.search(3);
		tree.search(5);
		tree.search(11);
		System.out.println("1 삭제");
		tree.remove(1);
		System.out.println(tree.toString());
		System.out.println("3 삭제");
		tree.remove(3);
		System.out.println(tree.toString());
		System.out.println("5 삭제");
		tree.remove(5);
		System.out.println(tree.toString());
		System.out.print("11 삭제");
		tree.remove(11);
		System.out.println(tree.toString());

	}

}
