package Work10;

import java.util.LinkedList;
import java.util.Queue;

public class HuffmanCode {
	
	HeapPriorityQueue queue = new HeapPriorityQueue();
	private htree htree_arr[] = new htree[26];
	private htree temp1, temp2,temproot;
	Queue<Integer> arr_queue = new LinkedList<Integer>();
	char pCode[] = new char[100];
	private int i=0;
	

	public void put(char ch) {
		if (htree_arr[ch - 'A'] == null) {
			htree_arr[ch - 'A'] = new htree(null, null, ch, 0);
			htree_arr[ch - 'A'].freq++;
		} else 
			htree_arr[ch - 'A'].freq++;
	}
	
	public void minheap_put() {
		for (int i = 0; i < 26; i++) {
			if(htree_arr[i] != null)
			queue.add(htree_arr[i]);
		}
	}
	
	public void remove() {
		char tempch =' ';
		int count=0;
		int size = queue.size();
		while(count < size-1) {
		temp1 = (htree) queue.remove();
		temp2 = (htree) queue.remove();
		count++;
		temproot = new htree(temp1,temp2,tempch,temp1.freq + temp2.freq);
		queue.add(temproot);
		}
	}
	public htree getterRoot() {
		return temproot;
	}
	
	public void all_print() {
		huffman_code(temproot,i,pCode);
	}
	
	public void huffman_code(htree tree,int i, char[] pCode) {
		i++;
		if(tree.lchild != null ) {
			pCode[i]='0';
			this.huffman_code(tree.lchild,i,pCode);
		}
		if(tree.rchild != null) {
			pCode[i]='1';
			this.huffman_code(tree.rchild,i,pCode);
		}
		if(tree.lchild == null && tree.rchild == null) {
			System.out.print(tree.alphabet + " : ");
			for(int x=1; x<i;x++) {
				System.out.print(pCode[x]);
			}
			System.out.println();
		}
	}
	
	public void encoding() {
		for (int i = 0; i < 26; i++) {
			if(htree_arr[i] != null)
			encode(temproot,i,pCode,htree_arr[i].alphabet);
		}
	}
	
	public void encode(htree tree,int i, char[] pCode,char alphabet) {
		i++;
		if(tree.lchild != null) {
			pCode[i]='0';
			this.encode(tree.lchild,i,pCode,alphabet);
		}
		if(tree.rchild != null) {
			pCode[i]='1';
			this.encode(tree.rchild,i,pCode,alphabet);
		}
		if(tree.lchild != null && tree.rchild != null && tree.alphabet == alphabet) {
			for(int x=1; x<i; x++) {
				System.out.print(pCode[x]);
			}
		}
		
	}
	
	public void decode(String S,htree tree) {
		if(tree == null) return;
		StringBuilder sb = new StringBuilder();
		int pos=0;
		htree current = tree;
		
	}
}
	class htree implements Comparable<htree> {
		htree lchild = null;
		htree rchild = null;
		char alphabet;
		int freq = 0;
		htree(htree lchild, htree rchild, char ch, int freq) {
			this.lchild = lchild;
			this.rchild = rchild;
			this.alphabet = ch;
			this.freq = freq;
		}
		@Override
		public int compareTo(htree arg0) {
			if (this.freq < arg0.freq)
				return -1;
			else if (this.freq == arg0.freq)
				return 0;
			else
				return 1;
		}
	}


