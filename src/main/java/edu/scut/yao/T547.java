package edu.scut.yao;

import java.util.Arrays;

public class T547 {
	public int findCircleNum(int[][] isConnected) {
		int[] num = new int[isConnected.length];
		Arrays.fill(num, -1);
		int r = isConnected.length;
		int c = isConnected[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = i+1; j < c; j++) {
				if(isConnected[i][j]==1)
					merge(i, j, num);
			}
		}
		
		int result = 0;
		for (int i : num) {
			if(i==-1)
				result++;
		}
		return result;
    }
	
	private void merge(int n1,int n2,int[] num) {
		int fn1 = find(n1, num);
		int fn2 = find(n2, num);
		if(fn1!=fn2) {
			num[fn2] = fn1;
		}
	}
	
	private int find(int n,int[] num) {
		if(num[n]==-1)
			return n;
		return find(num[n], num);
	}
	
	
	public static void main(String[] args) {
		T547 t547 = new T547();
		int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
		int r = t547.findCircleNum(isConnected);
		System.out.println(r);
	}
}
