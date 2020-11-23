package edu.scut.yao;

public class T494 {
	private int num = 0;
	public int findTargetSumWays(int[] nums, int S) {
		dfs(0, nums, 0, S);
		return num;
    }
	
	private void dfs(int sum,int[] nums,int idx,int S) {
		if(idx>=nums.length) {
			if(sum==S) {
				num++;
			}
			return;
		}
		dfs(sum-nums[idx], nums, idx+1, S);
		dfs(sum+nums[idx], nums, idx+1, S);
	}
	
	public static void main(String[] args) {
		int[] nums= {1, 1, 1, 1, 1};
		int S = 3;
		T494 t494 = new T494();
		int num = t494.findTargetSumWays(nums,S);
		System.out.println(num);
	}
}
