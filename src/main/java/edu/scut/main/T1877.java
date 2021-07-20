package edu.scut.main;

import java.util.Arrays;

public class T1877 {
	public int minPairSum(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		int len = nums.length-1;
		for (int i = 0; i < nums.length/2; i++) {
			res = Math.max(res, nums[i]+nums[len-i]);
		}
		return res;
    }
	
	public static void main(String[] args) {
		T1877 t1877 = new T1877();
		int[] nums = {3,5,4,2,4,6};
		System.out.println(t1877.minPairSum(nums));
	}
}
