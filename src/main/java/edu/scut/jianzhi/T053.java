package edu.scut.jianzhi;

public class T053 {
	public int search(int[] nums, int target) {
		int sidx = 0;
		int eidx = nums.length-1;
		int count = 0;
		while(sidx<=eidx) {
			int mid = (eidx-sidx)/2 + sidx;
			if(nums[mid]==target) {
				count++;
				int i = 1;
				while((mid+i<nums.length)&&nums[mid+i]==target) {
					count++;
					i++;
				}
				i = 1;
				while((mid-i>=0)&&nums[mid-i]==target) {
					count++;
					i++;
				}
				break;
			}
			if(nums[mid]>target) {
				eidx = mid-1;
			}else {
				sidx = mid+1;
			}
		}
		return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 6;
		T053 t053 = new T053();
		System.out.println(t053.search(nums, target));
	}
}
