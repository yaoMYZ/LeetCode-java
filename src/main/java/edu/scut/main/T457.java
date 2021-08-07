package edu.scut.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class T457 {
	boolean[] visitGlobal;
 	
	public boolean circularArrayLoop(int[] nums) {
		visitGlobal = new boolean[nums.length];
		Arrays.fill(visitGlobal, false);
		for (int i = 0; i < nums.length; i++) {
			if(visitGlobal[i])
				continue;
			if(judeLoop(i, nums))
				return true;
		}
		return false;
    }
	
	public boolean judeLoop(int sid,int[] nums) {
		Set<Integer> visit = new HashSet<>();
		LinkedList<Integer> visitList = new LinkedList<>();
		int positive = 1;
		if(nums[sid]<0)
			positive = -1;
		int i = sid;
		while (!visit.contains(i)) {
			if(visitGlobal[i]) {
				Iterator<Integer> iterator = visit.iterator();
				while (iterator.hasNext()) {
					visitGlobal[iterator.next()] = true;
				}
				return false;
			}
			
			visit.add(i);
			visitList.add(i);
			if(nums[i]==0)
				return false;
			if((positive*nums[i])<0)
				return false;
			if(nums[i]>0) {
				i = (i+nums[i])%nums.length;
			}else {
				int ni = i+nums[i];
				while (ni<0) {
					ni+=nums.length;
				}
				i = ni%nums.length;
			}
		}
		
		while (visitList.peek()!=i) {
			visitList.poll();
		}
		
		if(visitList.size()>1) {
			return true;
		}else {
			Iterator<Integer> iterator = visit.iterator();
			while (iterator.hasNext()) {
				visitGlobal[iterator.next()] = true;
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,-3,-9};
		T457 t457 = new T457();
		System.out.println(t457.circularArrayLoop(nums));
	}
}
