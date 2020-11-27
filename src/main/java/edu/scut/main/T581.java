package edu.scut.main;

public class T581 {
	public int findUnsortedSubarray(int[] nums) {
		if(nums.length<2)
			return 0;
		int sidx = 0;
		int eidx = nums.length-1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]<nums[i-1])
				break;
			sidx=i;
		}
		for (int i = nums.length-2; i >= 0; i--) {
			if(nums[i]>nums[i+1])
				break;
			eidx=i;
		}
		if(sidx>eidx)
			return 0;
		
		int max_n = Integer.MIN_VALUE;
		int min_n = Integer.MAX_VALUE;
		for (int i = sidx; i <= eidx; i++) {
			max_n = Math.max(nums[i], max_n);
			min_n = Math.min(nums[i], min_n);
		}
		
		int sortArrLen = eidx-sidx+1;
		for (int i = sidx-1; i >=0; i--) {
			if(nums[i]<=min_n)
				break;
			sortArrLen++;
		}
		for (int i = eidx+1; i < nums.length; i++) {
			if(nums[i]>=max_n)
				break;
			sortArrLen++;
		}
		return sortArrLen;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,5};
		T581 t581 = new T581();
		int r = t581.findUnsortedSubarray(nums);
		System.out.println(r);
	}
}
