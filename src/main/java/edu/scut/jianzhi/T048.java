package edu.scut.jianzhi;

import java.util.HashMap;
import java.util.Map;

public class T048 {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> tmpMap = new HashMap<>();
		int sidx = 0;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(tmpMap.containsKey(c)) {
				res = Math.max(res, i-sidx);
				sidx = Math.max(sidx, tmpMap.get(c)+1);
				tmpMap.put(c, i);
			}else {
				tmpMap.put(c, i);
			}
		}
		res = Math.max(res, s.length()-sidx);
		return res;
    }
	
	public static void main(String[] args) {
		T048 t048 = new T048();
		String s = "abba";
		int n = t048.lengthOfLongestSubstring(s);
		System.out.println(n);
	}
}
