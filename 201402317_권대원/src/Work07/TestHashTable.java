package Work07;

import java.io.*;
import java.util.StringTokenizer;

public class TestHashTable {
	public static void main(String[] args) {
		
	DoubleHashingHashTable doublehash = new DoubleHashingHashTable();
	LinearProbingHashTable linearhash = new LinearProbingHashTable();
	QuadraticProbingHashTable quadrahash = new QuadraticProbingHashTable();
	
	try {
		BufferedReader in = new BufferedReader(new FileReader(new File("C:\\Users\\goodd\\Desktop//Caesar.txt")));
		String line = in.readLine();
		while(line != null) {
			StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
			while(parser.hasMoreTokens()) {
				String word = parser.nextToken().toUpperCase();
				doublehash.put(word, 1);
				linearhash.put(word, 1);
				quadrahash.put(word, 1);
			}
			line = in.readLine();
		}
		in.close();
	
		
	} catch(IOException e) { System.out.println(e); }
	
	System.out.println("*****Collision count *****");
	System.out.println("LineProb: " + linearhash.getCollision());
	System.out.println("QuadProb: " + quadrahash.getCollision());
	System.out.println("DoubHash: " + doublehash.getCollision());
	
	System.out.println("*****Word count *****");
	System.out.println("LineProb: " + linearhash.size());
	System.out.println("QuadProb: " + quadrahash.size());
	System.out.println("DoubHash: " + doublehash.size());
	}

}
