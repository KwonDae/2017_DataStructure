package Work10;

public class HuffmanCode {
	
	HeapPriorityQueue queue = new HeapPriorityQueue();
	private htree htree_arr[] = new htree[26]; //트리형 알파벳이 저장될 htree배열
	private htree temp1, temp2,CompleteTree;
	char pCode[] = new char[100];  //인코딩한 정보를 저장할 배열
	private int i=0;  // 인코딩한 정보를 저장하기 위해 필요한 인덱스
	private String temp = ""; //디코딩을 위해 인코딩한 데이터를 저장할 배열

	public void put(char ch) {  // 알파벳을 입력받아 트리를 구성하기 위한 삽입메소드
		if (htree_arr[ch - 'A'] == null) {
			htree_arr[ch - 'A'] = new htree(null, null, ch, 0);
			htree_arr[ch - 'A'].freq++;
		} else 
			htree_arr[ch - 'A'].freq++;
	}
	
	public void minheap_put() { //트리로 구성된 알파벳을 freq을 기준으로 우선순위큐에 삽입
		for (int i = 0; i < 26; i++) {
			if(htree_arr[i] != null)
			queue.add(htree_arr[i]);
		}
	}
	
	public void extraction() { //우선순위큐에서 2개씩 노드를 추출하여 BinaryTree로 구성
		char tempch =' ';
		int count=0;
		int size = queue.size();
		while(count < size-1) {
		temp1 = (htree) queue.remove();
		temp2 = (htree) queue.remove();
		count++;
		CompleteTree = new htree(temp1,temp2,tempch,temp1.freq + temp2.freq);
		queue.add(CompleteTree); //합친걸 다시 우선순위큐에 삽입
		}
	}
	
	public htree getterRoot() {
		return CompleteTree;
	}
	
	public void huffmancode_print() {
		huffmancode(CompleteTree,i,pCode);
	}
	
	public void huffmancode(htree tree,int i, char[] pCode) {  //완성된 트리에  루트노드 기준으로 왼쪽은 0, 오른쪽은 1 가중치 부여
		i++;
		if(tree.lchild != null ) {
			pCode[i]='0';
			this.huffmancode(tree.lchild,i,pCode);
		}
		if(tree.rchild != null) {
			pCode[i]='1';
			this.huffmancode(tree.rchild,i,pCode);
		}
		if(tree.lchild == null && tree.rchild == null) {
			System.out.print(tree.alphabet + " : ");
			for(int x=1; x<i;x++) {
				System.out.print(pCode[x]);
			}
			System.out.println();
		}
	}
	
	/////////////////////////////////////////////////////////////////////////
	
	public void encoding(char alphabet) {
		this.encode(CompleteTree,i,pCode,alphabet);
	}
	
	public void encode(htree tree,int i, char[] pCode,char alphabet) { //해당 알파벳이 있으면 인코딩을하여 출력하는 인코딩메소드
		i++;
		if(tree.lchild != null) {
			pCode[i]='0';
			this.encode(tree.lchild,i,pCode,alphabet);
		}
		if(tree.rchild != null) {
			pCode[i]='1';
			this.encode(tree.rchild,i,pCode,alphabet);
		}
		if(tree.lchild == null && tree.rchild == null ) {
			if(tree.alphabet == alphabet) {
				for(int x=1; x<i;x++) {
					System.out.print(pCode[x]);
					temp += pCode[x];
				}
			}			
		}
		
	}
	
	/////////////////////////////////////////////////////////////////////////
	
	public void decoding() {
		this.decode(temp,CompleteTree);
	}
	
	public void decode(String S,htree tree) {
		if(tree == null) return;
		StringBuilder sb = new StringBuilder();
		int pos=0;
		htree current = tree;
		char[] chars = S.toCharArray();
		while(pos < chars.length) {
			char c = chars[pos];
			if( c== '0' && current.lchild != null) {
				current = current.lchild;
			}
			else if( c== '1' && current.rchild != null) {
				current = current.rchild;
			}
			if( current.lchild == null && current.rchild ==null) {
				sb.append(current.alphabet);
				current = tree;
			}
			pos++;
		}
		System.out.print(sb.toString());
	}
}

	/////////////////////////////////////////////////////////////////////////

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


