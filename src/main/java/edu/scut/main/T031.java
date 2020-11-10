package edu.scut.main;

public class T031 {
	public void nextPermutation(int[] nums) {
		int len = nums.length;
		int i=len-1;
		int s_i = 0;
		while (i>0) {
			if(nums[i]>nums[i-1]) {
				s_i=i;
				for (int j=i+1;j<len;j++) {
					if(nums[j]>nums[i-1])
						s_i = j;
					else
						break;
				}
				break;
			}
			i--;
		}
		if(i-1>=0)
			swap(s_i, i-1, nums);
		for(int j=0;j<(len-i)/2;j++) {
			swap(i+j, len-1-j, nums);
		}
    }
	
	private void swap(int i, int j,int[] nums) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
