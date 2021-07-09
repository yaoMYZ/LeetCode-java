package edu.scut.main;

import java.util.HashMap;
import java.util.Map;

public class T930 {
	public int numSubarraysWithSum(int[] nums, int goal) {
		int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }
	
	public static void main(String[] args) {
		T930 t930 = new T930();
		int[] nums = {0,0,0,0,0};
		int goal = 0;
		System.out.println(t930.numSubarraysWithSum(nums, goal));
	}
}
