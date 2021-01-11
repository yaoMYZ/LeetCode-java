package edu.scut.yao;

import java.util.Arrays;

public class T189 {
	public void rotate(int[] nums, int k) {
		if(nums.length<2)
			return;
		int len = nums.length;
		int num = 0;
		int swap = nums[0];
		int curIdx = 0;
		boolean[] record = new boolean[len];
		Arrays.fill(record, true);
		while (num<len) {
			if(record[curIdx]) {
				record[curIdx]=false;
				int nextIdx = (curIdx+k)%len;
				int tmp = nums[nextIdx];
				nums[nextIdx] = swap;
				swap = tmp;
				curIdx = nextIdx;
				num++;
			}else {
				while (!record[curIdx]) {
					curIdx = (curIdx+1)%len;
				}
				swap = nums[curIdx];
			}
			
		}
    }
	
	public static void main(String[] args) {
//		T189 t189 = new T189();
//		int[] nums = {-1,-100,3,99};
//		int k=2;
//		t189.rotate(nums, k);
//		for (int i : nums) {
//			System.out.println(i);
//		}
		int j=1;
		int k = 1<<j;
		System.out.println(k);
		System.out.println(j);
	}
}
