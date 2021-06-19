package edu.scut.yao;

public abstract class T852 {
	public int peakIndexInMountainArray(int[] arr) {
		int res = 0;
		int maxV = arr[0];
		for (int i=1;i<arr.length;i++) {
			if(arr[i]>maxV) {
				maxV = arr[i];
				res = i;
			}
		}
		return res;
    }
}
