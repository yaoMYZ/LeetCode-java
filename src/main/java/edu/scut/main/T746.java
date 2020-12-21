package edu.scut.main;

public class T746 {
	public int minCostClimbingStairs(int[] cost) {
		int a1=0;
		int a2=0;
		for (int i = 0; i < cost.length; i++) {
			int tmp = Math.min(a1, a2)+cost[i];
			a1 = a2;
			a2 = tmp;
		}
		return Math.min(a1, a2);
    }
	
	public static void main(String[] args) {
		T746 t746 = new T746();
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int r=t746.minCostClimbingStairs(cost);
		System.out.println(r);
	}
}
