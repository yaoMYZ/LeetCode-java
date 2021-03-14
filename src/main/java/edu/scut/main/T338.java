package edu.scut.main;

import java.util.Arrays;

public class T338 {
	private int[] record;
	public int[] countBits(int num) {
		record = new int[num+1];
		Arrays.fill(record, -1);
		record[0] = 0;
		for (int n = num; n >=0 ; n--) {
			if(record[n]==-1)
				writeRecord(n);
		}
		return record;
    }
	
	public void writeRecord(int n) {
		if(n==0)
			return;
		if(record[n]!=-1)
			return;
		writeRecord(n/2);
		record[n] = record[n/2];
		if(n%2==1) {
			record[n]+=1;
		}
	}
	
	public static void main(String[] args) {
		T338 t338 = new T338();
		for (int n : t338.countBits(5)) {
			System.out.println(n);
		}
	}
}
