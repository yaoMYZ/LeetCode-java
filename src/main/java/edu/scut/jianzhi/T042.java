package edu.scut.jianzhi;

public class T042 {
	public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
	
	public static void main(String[] args) {
		T042 t042 = new T042();
		int[] nums = {-5,8,-5,1,1,-3,5,5,-3,-3,6,4,-7,-4,-8,0,-1,-6};
		System.out.println(t042.maxSubArray(nums));
	}
}
