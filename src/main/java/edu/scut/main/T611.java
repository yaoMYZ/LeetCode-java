package edu.scut.main;

import java.util.Arrays;

public class T611 {
	public static void main(String[] args) {
		int[] nums = {2,2,3,4};
		T611 t611 = new T611();
		System.out.println(t611.triangleNumber(nums));
	}
	
	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		
		int count = 0;
		int n = nums.length;
		for (int i = 0; i < n-2; i++) {
			for (int j = i+1; j < n-1; j++) {
				int left = j + 1, right = n - 1, k = j;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                count += k-j;
			}
		}
		return count;
    }
}
