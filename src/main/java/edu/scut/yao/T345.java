package edu.scut.yao;

import java.util.HashSet;

public class T345 {
	public String reverseVowels(String s) {
		char[] chas = s.toCharArray();
		HashSet<Character> charSet = new HashSet<>();
		char[] vowel = {'a','e','i','o','u','A','E','I','O','U'};
		for (char c : vowel) {
			charSet.add(c);
		}
		
		int si = 0;
		int ei = chas.length-1;
		while (si<ei) {
			while (si<ei&&!charSet.contains(chas[si])) {
				si++;
			}
			
			while (si<ei&&!charSet.contains(chas[ei])) {
				ei--;
			}
			
			if(si<ei) {
				char tmp = chas[si];
				chas[si] = chas[ei];
				chas[ei] = tmp;
				si++;
				ei--;
			}
			
		}
		
		return new String(chas);
    }
	
	public static void main(String[] args) {
		String str = "hello";
		T345 t345 = new T345();
		System.out.println(t345.reverseVowels(str));
	}
}
