package Work09;

public class BinarySearchTree {
	private int key;
	private BinarySearchTree left,right;
	public static final BinarySearchTree NIL = new BinarySearchTree();
	public BinarySearchTree(int key) {
		this.key = key;
		left = right = NIL;
	}
	
	public BinarySearchTree() {
		left = right = this;
	}
	
	private BinarySearchTree(int key, BinarySearchTree left, BinarySearchTree right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
	public BinarySearchTree grow(int key) {
		if(this == NIL) return new BinarySearchTree(key);
		if(key ==this.key) return this;
		if(key < this.key)
			left = left.grow(key);
		else
			right = right.grow(key);
		return this;
	}
	public boolean search(int key) {
		if(key == this.key) {
			return true;
		}
		if(key < this.key) {	
			if(left == NIL ) { 
				return false;
			}
			this.left.search(key);
			return false;
		}
		else if( key > this.key) {
			if(right == NIL) {
				return false;
			}
			this.right.search(key);
			return false;
		}
		return false;
	}

}
