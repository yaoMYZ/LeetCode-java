package edu.scut.yao;

public class T034 {
	public int[] searchRange(int[] nums, int target) {
		int[] result = {-1,-1};
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==target) {
				result[0]=i;
				int j=i+1;
				while (j<nums.length && nums[j]==target) {
					j++;
				}
				result[1]=j-1;
				break;
			}
			if(nums[i]>target)
				break;
		}
		return result;
    }
}	
