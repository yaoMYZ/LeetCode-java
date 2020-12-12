package edu.scut.yao;

public class T376 {
	public int wiggleMaxLength(int[] nums) {
		if(nums.length==0)
			return 0;
		int pos = 1;
		int neg = 1;
		int skip = 0;
		for (int i = 1; i < nums.length; i++) {
			int diff = nums[i]-nums[i-1];
			if(diff==0)
				continue;
			if(diff>0) {
				pos = neg+1;
				skip = Math.max(skip, pos);
			}else {
				neg = pos+1;
				skip = Math.max(skip, neg);
			}
		}
		return Math.max(Math.max(pos, neg), skip);
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		T376 t376 = new T376();
		int r = t376.wiggleMaxLength(nums);
		System.out.println(r);
	}
}
