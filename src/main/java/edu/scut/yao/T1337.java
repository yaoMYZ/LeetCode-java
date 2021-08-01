package edu.scut.yao;

import java.util.ArrayList;
import java.util.List;

public class T1337 {
	public int[] kWeakestRows(int[][] mat, int k) {
		List<int[]> res = new ArrayList<>();
		res.add(new int[] {-1,-1});
		for (int i = 0; i < mat.length; i++) {
			int[] nums = mat[i];
			int p = findPos(nums, 0, nums.length-1);
			for (int j = res.size()-1; j >=0; j--) {
				if(p>=res.get(j)[1]) {
					res.add(j+1, new int[] {i,p});
					break;
				}
			}
			if(res.size()>k+1)
				res.remove(k+1);
		}
		
		int[] re = new int[k];
		for (int i = 1; i < k+1; i++) {
			re[i-1] = res.get(i)[0];
		}
		return re;
    }
	
	private int findPos(int[] nums, int si, int ei) {
		if(si>ei) {
			return -1;
		}
		
		int mid = (ei-si)/2 + si;
		if(nums[mid]==1) {
			if(mid==nums.length-1)
				return nums.length;
			else if (nums[mid+1]==0) {
				return mid+1;
			}
		}
		
		if(nums[mid]==0) {
			return findPos(nums, si, mid-1);
		}else {
			return findPos(nums, mid+1, ei);
		}
	}
	
	public static void main(String[] args) {
		T1337 t1337 = new T1337();
		int[][] mat = {{1,1,0,0,0},
				 {1,1,1,1,0},
				 {1,0,0,0,0},
				 {1,1,0,0,0},
				 {1,1,1,1,1}};
		int k = 3;
		int[] res = t1337.kWeakestRows(mat,k);
		for (int i : res) {
			System.out.println(i);
		}
		
	}
}
