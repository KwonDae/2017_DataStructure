package Work10;

import java.io.*;
import java.util.StringTokenizer;

public class TestHuffmanCode {
	public static void main(String[] args) {
		HuffmanCode huffman  = new HuffmanCode();
		int countline=0;
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
		huffman.huffmancode_print();
		System.out.println("*****4줄 인코딩*****");
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("C:\\Users\\goodd\\Desktop//Caesar.txt")));
			String line = in.readLine();
			while(line != null && countline < 4) {
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!'");
				while(parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					for(int i=0; i< word.length(); i++) {
						char ch = word.charAt(i);
						huffman.encoding(ch);
					}
				}
				countline++;
				line = in.readLine();
			}
			in.close();
		} catch(IOException e) { System.out.println(e); }
		System.out.println();
		System.out.println("*****4줄 디코딩*****");
		huffman.decoding();
	
	}

}



