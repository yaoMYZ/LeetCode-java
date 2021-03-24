package edu.scut.main;

import java.util.Stack;
import java.util.TreeMap;

public class T456 {
	public boolean find132pattern(int[] nums) {
		int leftMin = nums[0];
		TreeMap<Integer, Integer> rightAll = new TreeMap<>();
		for (int i = 2; i < nums.length; i++) {
			rightAll.put(nums[i], rightAll.getOrDefault(nums[i], 0)+1);
		}
		for (int i = 1; i < nums.length-1; i++) {
			Integer right = rightAll.ceilingKey(leftMin+1);
			if(right!=null&&nums[i]>right&&right>leftMin)
				return true;
			leftMin = Math.min(leftMin, nums[i]);
			rightAll.put(nums[i+1], rightAll.get(nums[i+1])-1);
			if(rightAll.get(nums[i+1])==0)
				rightAll.remove(nums[i+1]);
		}
		
		return false;
    }
	
	public boolean find132pattern2(int[] nums) {
		int mark2 = Integer.MIN_VALUE;
		Stack<Integer> condidate = new Stack<>();
		for (int i = nums.length-1; i >=0 ; i--) {
			if(mark2>nums[i])
				return true;
			while(!condidate.isEmpty()&&nums[i]>condidate.peek()) {
				mark2 = condidate.pop();
			}
			if(nums[i]>mark2)
				condidate.add(nums[i]);
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,5,0,3,4};
		T456 t456 = new T456();
		System.out.println(t456.find132pattern2(nums));
	}
}
