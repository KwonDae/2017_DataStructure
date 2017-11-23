package Work10;

import java.io.*;
import java.util.StringTokenizer;

public class TestHuffmanCode {
	public static void main(String[] args) {
		HuffmanCode huffman  = new HuffmanCode();
		/*
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\goodd\\Desktop//Caesar.txt")));
			String line;
			while((line = br.readLine().toUpperCase()) != null) {
				for(int i=0; i< line.length(); i++) {
					char ch = line.charAt(i);
					huffman.put(ch);
				}
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		*/
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("C:\\Users\\goodd\\Desktop//Caesar.txt")));
			String line = in.readLine();
			while(line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!'");
				while(parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					for(int i=0; i< word.length(); i++) {
						char ch = word.charAt(i);
						huffman.put(ch);
						
					}
				}
				line = in.readLine();
			}
			in.close();
		} catch(IOException e) { System.out.println(e); }
		
		huffman.minheap_put();
		huffman.remove();
		System.out.println("*****Huffman Code*****");
		huffman.all_print();
		System.out.println("*****4줄 인코딩*****");
		
		System.out.println();
	
	}

}



