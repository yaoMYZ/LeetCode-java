package edu.scut.yao;

import java.util.Arrays;

public class T976 {
	public int largestPerimeter(int[] A) {
		if(A.length<3)
			return 0;
		Arrays.sort(A);
		for (int i = A.length-1; i >= 2; i--) {
			int e1 = A[i];
			int e2 = A[i-1];
			int e3 = A[i-2];
			if(e1<(e2+e3)) {
				return e1+e2+e3;
			}
		}
		return 0;
    }
	
	public static void main(String[] args) {
		T976 t976 = new T976();
		int[] A = {3,9,2,5,2,19};
		System.out.println(t976.largestPerimeter(A));
	}
}
