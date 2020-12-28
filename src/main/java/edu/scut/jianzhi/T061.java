package edu.scut.jianzhi;

import java.util.Arrays;

public class T061 {
	public boolean isStraight(int[] nums) {
		int zero = 0;
		int s = 0;
		Arrays.sort(nums);
		while(nums[s]==0) {
			zero++;
			s++;
		}
		for (int i=s+1;i<nums.length;i++) {
			if(i==0)
				zero++;
			else {
				if (nums[i]-nums[i-1]==0) {
					return false;
				}
				else {
					zero-=(nums[i]-nums[i-1]-1);
					if(zero<0)
						return false;
				}
			}
		}
		return true;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,5,0,0};
		T061 t061 = new T061();
		boolean r = t061.isStraight(nums);
		System.out.println(r);
	}
}
