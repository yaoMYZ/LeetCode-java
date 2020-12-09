package edu.scut.jianzhi;

import java.util.Arrays;

public class T010_2 {
	private int[] record;
	public int numWays(int n) {
		if(n<2)
			return 1;
		
		record = new int[n+1];
		Arrays.fill(record, 0);
		record[0]=1;
		record[1]=1;
		for (int i = 2; i < record.length; i++) {
			record[i] = (record[i-1]+record[i-2])%1000000007;
		}
		return record[n];
    }
	
	
	public static void main(String[] args) {
		T010_2 t010_2 = new T010_2();
		System.out.println(t010_2.numWays(44));
	}
}
