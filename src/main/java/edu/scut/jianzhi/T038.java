package edu.scut.jianzhi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T038 {
	private boolean[] visit;
	private Set<String> res;
	
	public String[] permutation(String s) {
		visit = new boolean[s.length()];
		Arrays.fill(visit, false);
		res = new HashSet<>();
		char[] sarr = s.toCharArray();
		Arrays.sort(sarr);
		findStr(0, sarr, new StringBuilder());
		return res.toArray(new String[0]);
    }
	
	private void findStr(int count,char[] s,StringBuilder strBuilder) {
		if(count>=s.length) {
			String str = strBuilder.toString();
			res.add(str);
		}
		for (int i=0;i<s.length;i++) {
			if(visit[i]||(i > 0 && visit[i - 1] && s[i - 1] == s[i]))
				continue;
			strBuilder.append(s[i]);
			visit[i] = true;
			findStr(count+1, s, strBuilder);
			strBuilder.deleteCharAt(count);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) {
		T038 t038 = new T038();
		String s = "abc";
		String[] res = t038.permutation(s);
		for (String string : res) {
			System.out.println(string);
		}
	}
}
