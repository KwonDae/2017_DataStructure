package Work08;

public class AVLTree {
	private int key,height;
	private AVLTree left, right;
	public static final AVLTree NIL = new AVLTree();
	public AVLTree(int key) {
		this.key = key;
		left = right = NIL;
	}
	
	private AVLTree() {
		left = right = this;
		height = -1;
	}
	
	private AVLTree(int key, AVLTree left, AVLTree right) {
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1 + Math.max(left.height, right.height);
	}
	
	public boolean add(int key) {
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
	
	public AVLTree remove(int key) { 
	    AVLTree temp = this; // this는 왼쪽항에 올수 없기 때문에 변수로 설정
		if(this == NIL) {
			System.out.println("");
			return NIL;
		}
		if(this.key < key)  // 오른쪽서브트리
	    	right = right.remove(key);
	    else if(this.key > key) // 왼쪽서브트리
	    	left = left.remove(key);
	    else { // 해당 키를 찾음
	    	if(right != NIL && left == NIL)  //오른쪽에만 자식이 있는경우
	    		temp = right;
	    	else if( left!=NIL && right == NIL)  //왼쪽에만 자식이 있는경우
	    		temp = left;
	    	else if(left != NIL && right != NIL) { // 자식이 둘인경우
	    		if(right.left != NIL) {
	    			AVLTree temp2 = right;  // 오른쪽 자식의 최솟값을 저장할 변수 temp2
	    			while(temp2.left != NIL) {  // 오른쪽 자식의 최솟값 찾기
	    				temp2 = temp2.left;
	    			}
	    			temp.key = temp2.key;  // 노드삭제
	    			temp2 = NIL;
	    		} else {
	    			temp.key = right.key;
	    			temp.right = right.right;
	    		}
	    	}
	    	else {  //자식이 없는경우
	    		return NIL;
	    	}
	    }
		rebalance();
		height = 1+Math.max(left.height, right.height);
		return this;
	}
	
	
	public boolean search(int key) {
		if(key == this.key) {
			System.out.println(key + " 검색결과 : true" );
			return true;
		}
		if(key < this.key) {	
			if(left == NIL ) { 
				System.out.println(key + " 검색결과: false");
				return false;
			}
			this.left.search(key);
			return false;
		}
		else if( key > this.key) {
			if(right == NIL) {
				System.out.println(key + " 검색결과: false");
				return false;
			}
			this.right.search(key);
			return false;
		}
		return false;
	}
}
