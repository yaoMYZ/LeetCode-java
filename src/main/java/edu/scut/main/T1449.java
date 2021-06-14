package edu.scut.main;

import java.util.Arrays;

public class T1449 {
	public String largestNumber(int[] cost, int target) {
		int[] record = new int[target+1];
		Arrays.fill(record, Integer.MIN_VALUE);
		record[0] = 0;
		for (int i = 0; i < cost.length; i++) {
			for(int j=cost[i];j<=target;j++) {
				record[j] = Math.max(record[j], record[j-cost[i]]+1);
			}
		}
		if(record[target]<0)
			return "0";
		StringBuilder res = new StringBuilder();
		for (int i = 9, j = target; i >0; i--) {
			while (j>=cost[i-1]&&(record[j]==record[j-cost[i-1]]+1)) {
				j = j - cost[i-1];
				res.append(String.valueOf(i));
			}
		}
		return res.toString();
    }
	
	public static void main(String[] args) {
		int[] cost = {7,6,5,5,5,6,8,7,8};
		int target = 12;
		T1449 t1449 = new T1449();
		System.out.println(t1449.largestNumber(cost, target));
	}
}
