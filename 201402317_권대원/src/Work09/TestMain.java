package Work09;

public class TestMain {

	public static void main(String[] args) {
		QuadraticProbingHashTable hashTable = new QuadraticProbingHashTable();
		AVLTree  avlTree = new AVLTree(1);
		BinarySearchTree searchTree = new BinarySearchTree(1);
		long start, end;
		
		////////////////////////////////////insert 10000/////////////////////////////////////
		int array[] = new int[10000];
		int check[] = new int[10000];
		for(int i=0; i<10000;i++) {
			check[i] = 0;
		}
		for(int i=0;i<10000;) {
			array[i] = (int)(Math.random() * 10000)+1;
			if(check[array[i]-1] != 1) {
				check[array[i]-1] = 1;
				i++;
			}
		}
		System.out.println("n=10000");
		System.out.println("***** Insert *****");
		start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			searchTree.grow(array[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("BST insert : " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			avlTree.grow(array[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("AVL insert : " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			hashTable.put(array[i],array[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("QPH insert : " + (end - start) + "ms");
		
		////////////////////////////////////search 10000/////////////////////////////////////
		System.out.println("***** search *****");
		start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			searchTree.search(array[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("BST search : " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			avlTree.search(array[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("AVL search : " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			hashTable.search(array[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("QPH search : " + (end - start) + "ms");
		System.out.println();
		
		////////////////////////////////////insert 100000/////////////////////////////////////
		QuadraticProbingHashTable hashTable2 = new QuadraticProbingHashTable();
		AVLTree  avlTree2 = new AVLTree(1);
		BinarySearchTree searchTree2 = new BinarySearchTree(1);
		
		int array2[] = new int[100000];
		int check2[] = new int[100000];
		for(int i=0;i<100000;i++) {
			check2[i] = 0;
		}
		for(int i=0;i<100000;) {
			array2[i] = (int)(Math.random() * 100000)+1;
			if(check2[array2[i]-1] != 1) {
				check2[array2[i]-1] = 1;
				i++;
			}
			
		}
		System.out.println("n=100000");
		System.out.println("***** Insert *****");
		start = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			searchTree2.grow(array2[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("BST insert : " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			avlTree2.grow(array2[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("AVL insert : " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			hashTable2.put(array2[i],array2[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("QPH insert : " + (end - start) + "ms");
		
		////////////////////////////////////search 100000/////////////////////////////////////
		System.out.println("***** search *****");
		start = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			searchTree2.search(array2[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("BST search : " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			avlTree2.search(array2[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("AVL search : " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			hashTable2.search(array2[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("QPH search : " + (end - start) + "ms");
		System.out.println();
		
		////////////////////////////////insert 1000000/////////////////////////////////////////
		QuadraticProbingHashTable hashTable3 = new QuadraticProbingHashTable();
		AVLTree  avlTree3 = new AVLTree(1);
		BinarySearchTree searchTree3 = new BinarySearchTree(1);
		
		int array3[] = new int[1000000];
		int check3[] = new int[1000000];
		for(int i=0;i<1000000;i++) {
			check3[i] = 0;
		}
		for(int i=0;i<1000000;) {
			array3[i] = (int)(Math.random() * 1000000)+1;
			if(check3[array3[i]-1] != 1) {
				check3[array3[i]-1] = 1;
				i++;
			}
		}
		System.out.println("n=1000000");
		System.out.println("***** Insert *****");
		start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
			searchTree3.grow(array3[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("BST insert : " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
			avlTree3.grow(array3[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("AVL insert : " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
			hashTable3.put(array3[i],array3[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("QPH insert : " + (end - start) + "ms");
		

		////////////////////////////////search 1000000/////////////////////////////////////////
		System.out.println("***** search *****");
		start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
			searchTree3.search(array3[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("BST search : " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
			avlTree3.search(array3[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("AVL search : " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
			hashTable3.search(array3[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("QPH search : " + (end - start) + "ms");
		
	}

}
