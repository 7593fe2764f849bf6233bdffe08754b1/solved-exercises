package edu.finki.np.homework1;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Anagrams {

		public static void main(String[] args) {
			findAll(System.in);
		}
	    
	    public static void findAll(InputStream inputStream) {
			Scanner wordStream = new Scanner(inputStream);
			Map<String, TreeSet<String>> anagrams = new TreeMap<String, TreeSet<String>>();
			while(wordStream.hasNext()){
				String word = wordStream.nextLine();
				char[] sortedWord = word.toCharArray();
				Arrays.sort(sortedWord);
				String anagramWord = new String(sortedWord);
				boolean added = false;
				for(String key: anagrams.keySet()){
					char[] sortedKey = key.toCharArray();
					Arrays.sort(sortedKey);
					String anagramKey = new String(sortedKey);
					if(anagramKey.equals(anagramWord)){
						if(!anagrams.get(key).contains(word)){
							anagrams.get(key).add(word);
							added = true;
							break;
						}
					}
				}
				if(!added){
					anagrams.put(word, new TreeSet<String>());
					anagrams.get(word).add(word);
				}
// faster way, if we put the first word of the group (sorted) to be the key of the group
// but it doesn't lead to the same ordering...
//				String word = wordStream.nextLine();
//				char[] anagram = word.toCharArray();
//				Arrays.sort(anagram);
//				String anagramKey = new String(anagram);
//				if(anagrams.containsKey(anagramKey)){
//					if(anagrams.get(anagramKey).contains(word))
//						anagrams.get(anagramKey).add(word);
//				}
//				else{
//					anagrams.put(anagramKey, new TreeSet<String>());
//					anagrams.get(anagramKey).add(word);
//				}
			}
			wordStream.close();
			for (Entry<String, TreeSet<String>> word_groups : anagrams.entrySet()) {
				if(word_groups.getValue().size()>=5){
					StringBuilder groupPrint = new StringBuilder();
					Iterator it = word_groups.getValue().iterator();
					while(it.hasNext()){
						groupPrint.append(it.next());
						if(it.hasNext())
							groupPrint.append(" ");
					}
					System.out.println(groupPrint.toString());
				}
			}
		}
	
}
