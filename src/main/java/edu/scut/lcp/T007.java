package edu.scut.lcp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class T007 {
	public int numWays(int n, int[][] relation, int k) {
		HashMap<Integer, ArrayList<Integer>> relationMap = new HashMap<>();
		for (int[] is : relation) {
			relationMap.computeIfAbsent(is[0], key->new ArrayList<>());
			relationMap.get(is[0]).add(is[1]);
		}
		
		int step = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		
		while(step<k&&!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				ArrayList<Integer> visitors = relationMap.get(cur);
				if(visitors!=null) {
					for (Integer integer : visitors) {
						queue.add(integer);
					}
				}
			}
			step++;
		}
		int res = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur==n-1)
				res++;
		}
		return res;
    }
}
