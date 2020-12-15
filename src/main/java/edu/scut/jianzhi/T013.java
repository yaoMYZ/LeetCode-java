package edu.scut.jianzhi;

import java.util.Arrays;

public class T013 {
	private int result = 1;
	private boolean[][] flags;
	private int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}}; 
	private int row;
	private int col;
	public int movingCount(int m, int n, int k) {
		if(m==0)
			return 0;
		flags = new boolean[m][n];
		row = m;
		col = n;
		for (boolean[] bs : flags) {
			Arrays.fill(bs, true);
		}
		flags[0][0]=false;
		moving(0, 0, k);
		return result;
    }
	
	private void moving(int i,int j,int k) {
		for (int[] p : pos) {
			int ni = i+p[0];
			int nj = j+p[1];
			int bitS = calBitSum(ni)+calBitSum(nj);
			if(ni>=0&&ni<row&&nj>=0&&nj<col&&flags[ni][nj]&&bitS<=k) {
				flags[ni][nj]=false;
				result++;
				moving(ni, nj, k);
			}
		}
	}
	
	private int calBitSum(int n) {
		int sum=0;
		while (n>0) {
			sum+=n%10;
			n=n/10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int m = 3;
		int n = 2;
		int k = 17;
		T013 t013 = new T013();
		int r = t013.movingCount(m, n, k);
		System.out.println(r);
	}
}
