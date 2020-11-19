package edu.scut.main;

public class T283 {
	public void moveZeroes(int[] nums) {
		int zerosIdx = -1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0) {
				zerosIdx = i;
				break;
			}
		}
		if(zerosIdx==-1)
			return;
		int startIdx = zerosIdx+1;
		for (int i = startIdx; i < nums.length; i++) {
			if(nums[i]!=0) {
				nums[zerosIdx] = nums[i];
				nums[i] = 0;
				zerosIdx+=1;
			}
		}
    }
}
