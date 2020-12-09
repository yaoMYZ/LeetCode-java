package edu.scut.yao;

import java.util.HashMap;
import java.util.Map;

public class T062 {
	private int row;
	private int col;
	private Map<String, Integer> record = new HashMap<>();
	public int uniquePaths(int m, int n) {
		row = m;
		col = n;
		return sumPaths(1,1);
    }
	private int sumPaths(int r, int c) {
		if(r==row || c==col)
			return 1;
		String pos = String.valueOf(r)+"-"+String.valueOf(c);
		if(record.containsKey(pos))
			return record.get(pos);
		int result = sumPaths(r+1,c)+sumPaths(r, c+1);
		record.put(pos, result);
		return result;
	}
	
	public static void main(String[] args) {
		int m = 7;
		int n = 3;
		T062 t062 = new T062();
		int r = t062.uniquePaths(m,n);
		System.out.println(r);
	}
}
