package edu.scut.yao;

public class T413 {
	public int numberOfArithmeticSlices(int[] nums) {
		if(nums.length<3)
			return 0;
		int dif = nums[1] - nums[0];
		int i = 2;
		int count = 0;
		while (i<nums.length) {
			int si = i-2;
			while (i<nums.length&&nums[i]-nums[i-1]==dif) {
				i++;
			}
			if(i-si>2) {
				int tmp = i-si-2;
				count += (tmp+1)*tmp/2;
			}
			
			if(i>=nums.length)
				break;
			dif = nums[i] - nums[i-1];
			i++;
		}
		return count;
    }
	
	public static void main(String[] args) {
		T413 t413 = new T413();
		int[] nums = {1,2,3,8,9,10};
		System.out.println(t413.numberOfArithmeticSlices(nums));
	}
}	
