package edu.scut.main;

public class Test {
	@org.junit.Test
	public void main() {
//		T031 t031 = new T031();
//		int[] nums = {2,2,0,4,3,1};
//		t031.nextPermutation(nums);
//		for (int i : nums) {
//			System.out.println(i);
//		}
		
		T394 t394 = new T394();
		String s = "3[a2[c]]";
		String ss = t394.decodeString(s);
		System.out.println(ss);
	}

}
