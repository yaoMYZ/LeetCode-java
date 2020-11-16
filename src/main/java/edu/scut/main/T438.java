package edu.scut.main;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T438 {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if(s.length()<p.length())
			return result;
		
		Map<Character, Integer> pMap = new HashMap<>();
		for (int i=0;i<p.length();i++) {
			char c = p.charAt(i);
			pMap.computeIfAbsent(c, k->0);
			pMap.put(c, pMap.get(c)+1);
		}
		Map<Character, Integer> sMap = new HashMap<>();
		for (int j = 0; j < p.length(); j++) {
			char c = s.charAt(j);
			sMap.computeIfAbsent(c, k->0);
			sMap.put(c, sMap.get(c)+1);
		}
		boolean flag = false;
		if(compareCharMap(pMap, sMap)) {
			flag = true;
			result.add(0);
		}
		
		for(int i=1;i<(s.length()-p.length()+1);i++) {
			if(s.charAt(i-1)==s.charAt(i+p.length()-1)) {
				if(flag) {
					result.add(i);
				}
			}else {
				char bc = s.charAt(i-1);
				sMap.put(bc, sMap.get(bc)-1);
				char c = s.charAt(i+p.length()-1);
				sMap.computeIfAbsent(c, k->0);
				sMap.put(c, sMap.get(c)+1);
				
				if(flag) {
					flag = false;
				}else {
					if(compareCharMap(pMap, sMap)) {
						result.add(i);
						flag = true;
					}else {
						flag = false;
					}
				}
			}							
		}
		return result;
    }
	
	private boolean compareCharMap(Map<Character, Integer> map1,Map<Character, Integer> map2) {
		for (Entry<Character, Integer> entry : map1.entrySet()) {
			char c = entry.getKey();
			int num = entry.getValue();
			if(map2.get(c)==null || map2.get(c)!=num)
				return false;
		}
		
		return true;
	}
}
