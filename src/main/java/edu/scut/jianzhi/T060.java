package edu.scut.jianzhi;

import java.util.Arrays;

public class T060 {
	public double[] dicesProbability(int n) {
		int[][] mat = new int[n+1][6*n+1];
		for (int i = 0; i < mat.length; i++) {
			Arrays.fill(mat[i], 0);
		}
		for (int i = 1; i <= 6; i++) {
			mat[1][i] = 1; 
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = i; j <= 6*i; j++) {
				for (int k = 1; k <= 6; k++) {
					if(j-k<=0) {
						break;
					}
					mat[i][j]+=mat[i-1][j-k];
				}
			}
		}
		
		double[] res = new double[5*n+1];
		double pow = Math.pow(6, n);
		for (int i = n; i <= 6*n; i++) {
			res[i-n] = mat[n][i]/pow;
		}
		return res;
    }
	
	public static void main(String[] args) {
		T060 t060 = new T060();
		double[] res = t060.dicesProbability(2);
		for (double d : res) {
			System.out.println(d);
		}
	}
}
