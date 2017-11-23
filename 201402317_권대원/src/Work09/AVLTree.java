package Work09;

public class AVLTree {
	private int key,height;
	private AVLTree left, right;
	public static final AVLTree NIL = new AVLTree();
	public AVLTree(int key) {
		this.key = key;
		left = right = NIL;
	}
	
	public AVLTree() {
		left = right = this;
		height = -1;
	}
	
	private AVLTree(int key, AVLTree left, AVLTree right) {
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1 + Math.max(left.height, right.height);
	}
	
	public boolean insert(int key) {
		int oldSize = size();
		grow(key);
		return size() > oldSize;  // 삽입이 되었으면 true, 안되면 false
	}
	
	public AVLTree grow(int key) {
		if(this == NIL) return new AVLTree(key);
		if(key ==this.key) return this;
		if(key < this.key)
			left = left.grow(key);
		else
			right = right.grow(key);
		rebalance();
		height = 1+Math.max(left.height, right.height);
		return this;
	}
	
	public int size() {
		if(this == NIL) return 0;
		return 1+left.size() + right.size();
	}
	
	public String toString() {
		if(this==NIL) return "";
		int balancefactor = left.height - right.height;
		return left + "("+ key +","+ balancefactor+ ")  " + right;
		
	}
	
	public void rebalance() {
		if(right.height > left.height +1) {
			if(right.left.height > right.right.height) 
				right.rotateRight();
			rotateLeft();
		}
		else if(left.height > right.height +1) {
			if(left.right.height > left.left.height) 
				left.rotateLeft();
			rotateRight();
		}
	}
	
	public void rotateLeft() {
		left = new AVLTree(key,left,right.left);
		key = right.key;
		right = right.right;
	}
	
	public void rotateRight() {
		right = new AVLTree(key, left.right, right);
		key = left.key;
		left = left.left;
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
