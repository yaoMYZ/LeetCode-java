package edu.scut.main;

public class T581 {
	public int findUnsortedSubarray(int[] nums) {
		int si = 0;
		while (si+1<nums.length) {
			if(nums[si]>nums[si+1]) {
				while (si-1>=0&&nums[si]==nums[si-1]) {
					si--;
				}
				break;
			}
			si++;
		}
		if(si==nums.length-1)
			return 0;
		int ei = nums.length-1;
		while (ei>si) {
			if(nums[ei]<nums[ei-1]) {
				while (ei+1<nums.length&&nums[ei]==nums[ei+1]) {
					ei++;
				}
				break;
			}	
			ei--;
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = si; i <=ei; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		
		int rsi = si;
		int rei = ei;
		
		while (rsi-1>=0&&min<nums[rsi-1]) {
			rsi--;
		}
		
		while (rei+1<nums.length&&max>nums[rei+1]) {
			rei++;
		}
		
		return rei-rsi+1;
    }
	
	
//	public int findUnsortedSubarray(int[] nums) {
//		if(nums.length<2)
//			return 0;
//		int sidx = 0;
//		int eidx = nums.length-1;
//		for (int i = 1; i < nums.length; i++) {
//			if(nums[i]<nums[i-1])
//				break;
//			sidx=i;
//		}
//		for (int i = nums.length-2; i >= 0; i--) {
//			if(nums[i]>nums[i+1])
//				break;
//			eidx=i;
//		}
//		if(sidx>eidx)
//			return 0;
//		
//		int max_n = Integer.MIN_VALUE;
//		int min_n = Integer.MAX_VALUE;
//		for (int i = sidx; i <= eidx; i++) {
//			max_n = Math.max(nums[i], max_n);
//			min_n = Math.min(nums[i], min_n);
//		}
//		
//		int sortArrLen = eidx-sidx+1;
//		for (int i = sidx-1; i >=0; i--) {
//			if(nums[i]<=min_n)
//				break;
//			sortArrLen++;
//		}
//		for (int i = eidx+1; i < nums.length; i++) {
//			if(nums[i]>=max_n)
//				break;
//			sortArrLen++;
//		}
//		return sortArrLen;
//    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,4,5,3};
		T581 t581 = new T581();
		int r = t581.findUnsortedSubarray(nums);
		System.out.println(r);
	}
}
