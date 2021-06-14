package edu.scut.yao;

import java.util.ArrayList;
import java.util.List;

public class T279 {
	private List<Integer> reList = new ArrayList<>();
	
	public int numSquares(int n) {
		List<Integer> tmpNums = new ArrayList<>();
		reList.add(0);
		for (int i=1;i<=n;i++) {
			reList.add(Integer.MAX_VALUE);
		}
		int sn = (int) Math.sqrt(n);
		for (int i = 1; i <= sn; i++) {
			tmpNums.add(i*i);
		}
		search(n, tmpNums, tmpNums.size());
		return reList.get(n);
    }
	
	private void search(int n, List<Integer> nums, int midx) {
		for(int i=0 ;i<midx && nums.get(i)<=n;i++) {
			int target = n-nums.get(i);
			if(reList.get(target)==Integer.MAX_VALUE) {
				search(target, nums,midx);
			}
			int minS = Math.min(reList.get(n), reList.get(target)+1);
			reList.set(n, minS);
		}
	}
	
	public static void main(String[] args) {
		T279 t279 = new T279();
		System.out.println(t279.numSquares(12));
	}
}
