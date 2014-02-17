package edu.finki.np.lab7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class MacString {
	
	private LinkedList<Character> chars;
	
	public MacString(String s) {
		char[] c = s.toCharArray();
		chars = new LinkedList<Character>();
		for (Character d : c) {
			chars.add(d);
		}
	}
	
	public void insert(char c){
		chars.addFirst(c);
	}
	
	public void append(char c){
		chars.addLast(c);
	}
	
	public int length(){
		return chars.size();
	}
	
	public boolean isPalindrome(){
		LinkedList<Character> reversed = new LinkedList<>(chars);
		Collections.reverse(reversed);
		return chars.equals(reversed);
	}
	
	public boolean isRecuring(MacString base){
		String seq = base.toString();
		String thisString = transform(chars);
		int begin = thisString.indexOf(seq, 0);
		if(begin==-1)
			return false;
		begin += seq.length();
		begin = thisString.indexOf(seq, begin);
		if(begin==-1)
			return false;
		return true;
	}
	
	public MacString changeAlphabet(Map<Character,Character> new_aplhabet){
		LinkedList<Character> ret = new LinkedList<>(chars);
		for (Entry<Character, Character> entry : new_aplhabet.entrySet()) {
			Collections.replaceAll(ret, entry.getKey(), entry.getValue());
		}
		return new MacString(transform(ret));
	}
	
	private String transform(LinkedList<Character> list){
		StringBuilder sb = new StringBuilder();
		for(Character character: list){
			sb.append(character);
		}
		return sb.toString();
	}

	public MacString format(int length, boolean right_align){
		if(chars.size()>length)
			return new MacString(this.toString());
		LinkedList<Character> ret = new LinkedList<>(chars);
		if(right_align){
			while(ret.size()<length)
				ret.addFirst(' ');
		} else {
			while(ret.size()<length)
				ret.addLast(' ');
		}
		return new MacString(transform(ret));
	}
	
	@Override
	public String toString() {
		return transform(chars);
	}
	
}
