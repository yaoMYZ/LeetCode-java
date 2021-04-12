package edu.scut.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T090 {
	private Set<List<Integer>> subset = new HashSet<>();
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		getsubset(nums, 0, new ArrayList<>());
		List<List<Integer>> res = new ArrayList<>(subset);
		return res;
    }
	
	private <T> void getsubset(int[] nums, int idx, List<Integer> tmp) {
		if(idx>=nums.length) {
			ArrayList<Integer> ntmp = new ArrayList<>(tmp);
			subset.add(ntmp);
			return;
		}else {
			for(int i=idx;i<nums.length;i++) {
				tmp.add(nums[i]);
				getsubset(nums, i+1, tmp);
				tmp.remove(tmp.size()-1);
			}
			getsubset(nums, nums.length, tmp);
			return;
		}
	}
	
	public static void main(String[] args) {
		T090 t090 = new T090();
		int[] nums = {4,4,4,1,4};
		List<List<Integer>> res = t090.subsetsWithDup(nums);
		System.out.println(res);
	}
}
