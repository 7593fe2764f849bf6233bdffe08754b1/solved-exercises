package edu.finki.np.homework1;

import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class TermFrequency {

	private HashSet<String> ignoreWords;
	private TreeMap<String, Integer> allWords;
	private int totalCount;
	
	public TermFrequency(InputStream inputStream, String[] stopWords){
		ignoreWords = new HashSet<String>();
		totalCount = 0;
		for(String word: stopWords){
			ignoreWords.add(word);
		}
		Scanner wordStream = new Scanner(inputStream);
		allWords = new TreeMap<>();
		while(wordStream.hasNextLine()){
			String nextLine = wordStream.nextLine();
			String[] words = nextLine.toLowerCase().split("\\s+");
			for(String word: words){
				
				//ignore single "," and "."
				if(word.equals(",") || word.equals("."))
					continue;
				
				//make no difference between "word" and "word." or "word,"
				if(word.contains(".") || word.contains(","))
					word = word.substring(0, word.length()-1);
				
				//ignore empty strings
				if(word.length()==0)
					continue;
				
				//ignore stop words
				if(ignoreWords.contains(word))
					continue;
				
				//count the word
				totalCount++;
				
				//count the recurring appearance word
				if(allWords.containsKey(word)){
					int numWords = allWords.get(word);
					numWords++;
					allWords.put(word, numWords);
					continue;
				}
				
				//start counting the word
				allWords.put(word, 1);
			}
		}
		wordStream.close();
	}
	
	public int countTotal(){
		return totalCount;
	}
	
	public int countDistinct(){
		return allWords.size();
	}
	
	public List<String> mostOften(int k){
		int i = 0;
		
		LinkedList<String> retList = new LinkedList<>();
		LinkedList<Map.Entry<String, Integer>> mostOften = new LinkedList<>(allWords.entrySet());
		
		//sort ascending
		Collections.sort(mostOften, new WordComparator());
		
		//revert to descending
		Collections.reverse(mostOften);
		
		//get the k-most frequent words
		ListIterator<Map.Entry<String, Integer>> iterator = mostOften.listIterator();
		while(i<k&&iterator.hasNext()){
			retList.add(iterator.next().getKey());
			i++;
		}
		
		return retList;
	}

	//compare words on word-frequency, if equal, then enforce alphabetical order 
	private class WordComparator implements Comparator<Map.Entry<String, Integer>>{

		@Override
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			Integer word1freq = o1.getValue();
			Integer word2freq = o2.getValue();
			if(word1freq.compareTo(word2freq)==0)
				return o2.getKey().compareTo(o1.getKey());
			return word1freq.compareTo(word2freq);
		}		
	}
	
}