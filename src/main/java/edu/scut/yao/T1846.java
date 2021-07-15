package edu.scut.yao;

import java.util.Arrays;

public class T1846 {
	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		Arrays.sort(arr);
		if(arr[0]>1)
			arr[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Math.min(arr[i], arr[i-1]+1);
		}
		return arr[arr.length-1];
    }
	
	public static void main(String[] args) {
		int[] arr = {2,2,1,2,1};
		T1846 t1846 = new T1846();
		System.out.println(t1846.maximumElementAfterDecrementingAndRearranging(arr));
	}
}
