package edu.scut.main;

import java.util.Arrays;

public class T1818 {
	public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
		int[] nums11 = new int[nums1.length];
		for (int i = 0; i < nums11.length; i++) {
			nums11[i] = nums1[i];
		}
		Arrays.sort(nums11);
		int diff = 0;
		int diffSwitch = 0;
		for (int i = 0; i < nums1.length; i++) {
			int curDiff = Math.abs(nums1[i]-nums2[i]);
			if(curDiff!=0) {
				int minDiff = findMinDiff(nums11, nums2[i]);
				if(minDiff<curDiff) {
					int subDiff = curDiff-minDiff;
					if(subDiff>diffSwitch) {
						diff -= (subDiff-diffSwitch);
						diffSwitch = subDiff;
					}
				}
			}
			diff= (diff+curDiff)%1000000007;
		}
		return diff;
    }
	
	private int findMinDiff(int[] nums, int target) {
		int sidx = 0;
		int eidx = nums.length-1;
		int minDiff = Integer.MAX_VALUE;
		while (sidx<=eidx) {
			int mid = (eidx-sidx)/2 + sidx;
			if(nums[mid]==target)
				return 0;
			int diff = Math.abs(target-nums[mid]);
			minDiff = Math.min(minDiff, diff);
			if(target>nums[mid]) {
				sidx = mid+1;
			}else {
				eidx = mid-1;
			}
		}
		return minDiff;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,10,4,4,2,7};
		int[] nums2 = {9,3,5,1,7,4};
		T1818 t1818 = new T1818();
		System.out.println(t1818.minAbsoluteSumDiff(nums1, nums2));
	}
}
