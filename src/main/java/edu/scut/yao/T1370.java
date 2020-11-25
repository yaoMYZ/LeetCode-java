package edu.scut.yao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class T1370 {
	public String sortString(String s) {
		String result = "";
		Map<Character, Integer> charMap = new  HashMap<>();
		for (int i=0;i<s.length();i++) {
			Character c = s.charAt(i);
			charMap.computeIfAbsent(c, k->0);
			charMap.put(c, charMap.get(c)+1);
		}
		TreeMap<Character, Integer> sortedMap = new TreeMap<>(charMap);
		while (!sortedMap.isEmpty()) {
			Set<Entry<Character,Integer>> entries = sortedMap.entrySet();
			List<Entry<Character,Integer>> entries2 = new ArrayList<>(entries);
			for (Entry<Character,Integer> entry : entries2) {
				result+=entry.getKey();
				if(entry.getValue()==1) {
					sortedMap.remove(entry.getKey());
				}else {
					sortedMap.put(entry.getKey(), entry.getValue()-1);
				}
			}
			
			if(sortedMap.isEmpty())
				break;
			entries = sortedMap.entrySet();
			entries2 = new ArrayList<>(entries);
			for (int i = entries2.size()-1; i >= 0; i--) {
				Entry<Character,Integer> entry = entries2.get(i);
				result+=entry.getKey();
				if(entry.getValue()==1) {
					sortedMap.remove(entry.getKey());
				}else {
					sortedMap.put(entry.getKey(), entry.getValue()-1);
				}
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		String s = "leetcode";
		T1370 t1370 = new T1370();
		String r = t1370.sortString(s);
		System.out.println(r);
	}
}
