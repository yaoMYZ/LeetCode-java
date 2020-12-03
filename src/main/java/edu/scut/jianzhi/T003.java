package edu.scut.jianzhi;

import java.util.HashSet;
import java.util.Set;

public class T003 {
	public int findRepeatNumber(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if(numSet.contains(nums[i]))
				return nums[i];
			numSet.add(nums[i]);
		}
		return -1;
    }
}
