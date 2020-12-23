package edu.scut.jianzhi;

public class T053_2 {
	public int missingNumber(int[] nums) {
		int len = nums.length;
		int total = (int) ((len+1)*len/2.0);
		int sum = 0;
		for (int i : nums) {
			sum+=i;
		}
		return total-sum;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4,5,6,7,8};
		T053_2 t053_2 = new T053_2();
		int r = t053_2.missingNumber(nums);
		System.out.println(r);
	}
}
