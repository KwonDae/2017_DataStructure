package Work10;

public class BinarySearchTree {
	private int freq;
	private char alphabet;
	private BinarySearchTree left,right;
	public static final BinarySearchTree NIL = new BinarySearchTree();
	public BinarySearchTree(int freq,char alphabet) {
		this.freq = freq;
		this.alphabet = alphabet;
		left = right = NIL;
	}
	
	public BinarySearchTree() {
		left = right = this;
	}
	
	private BinarySearchTree(int freq,char alphabet, BinarySearchTree left, BinarySearchTree right) {
		this.freq = freq;
		this.alphabet = alphabet;
		this.left = left;
		this.right = right;
	}
	public BinarySearchTree grow(int freq,char alphabet) {
		if(this == NIL) return new BinarySearchTree(freq,alphabet);
		if(freq ==this.freq) return this;
		if(freq < this.freq)
			left = left.grow(freq,alphabet);
		else
			right = right.grow(freq,alphabet);
		return this;
	}
	public boolean search(int freq) {
		if(freq == this.freq) {
			return true;
		}
		if(freq < this.freq) {	
			if(left == NIL ) { 
				return false;
			}
			this.left.search(freq);
			return false;
		}
		else if( freq > this.freq) {
			if(right == NIL) {
				return false;
			}
			this.right.search(freq);
			return false;
		}
		return false;
	}

}
