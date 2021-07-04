package edu.scut.yao;

import java.util.Arrays;

public class T645 {
	public int[] findErrorNums(int[] nums) {
		boolean[] visit = new boolean[nums.length+1];
		Arrays.fill(visit, false);
		int[] res = new int[2];
		for (int i=0;i<nums.length;i++) {
			if(!visit[nums[i]]) {
				visit[nums[i]] = true;
			}else {
				res[0] = nums[i];
			}
		}
		for (int i=1;i<visit.length;i++) {
			if(!visit[i]) {
				res[1] = i;
			}
		}
		return res;
    }
}
