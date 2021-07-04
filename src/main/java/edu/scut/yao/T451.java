package edu.scut.yao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public abstract class T451 {
	public String frequencySort(String s) {
		HashMap<Character, Integer> frequencyMap = new HashMap<>();
		for (Character c : s.toCharArray()) {
			frequencyMap.computeIfAbsent(c, key->0);
			frequencyMap.put(c, frequencyMap.get(c)+1);
		}
		
		ArrayList<Entry<Character, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
		entryList.sort(new Comparator<Entry<Character, Integer>>() {
		     @Override
		     public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
		       return o2.getValue().compareTo(o1.getValue());
		     }
		});
		
		StringBuilder res = new StringBuilder();
		for (Entry<Character, Integer> entry : entryList) {
			for (int i = 0; i < entry.getValue(); i++) {
				res.append(entry.getKey());
			}
		}
		
		return res.toString();
    }
}
