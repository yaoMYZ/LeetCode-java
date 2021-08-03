package edu.scut.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class T743 {
	class Weight{
		Integer node;
		Integer weight;
		
		public Weight(Integer node,Integer weight) {
			this.node = node;
			this.weight = weight;
		}
	}
	
	public int networkDelayTime(int[][] times, int n, int k) {
		int[] record = new int[n+1];
		Arrays.fill(record, 1000);
		record[k] = 0;
		
		Map<Integer, List<Weight>> map = new HashMap<>();
		for (int i = 0; i < times.length; i++) {
			map.computeIfAbsent(times[i][0], key->new ArrayList<>());
			map.get(times[i][0]).add(new Weight(times[i][1], times[i][2]));
		}
		
		LinkedList<Weight> list = new LinkedList<>();
		list.add(new Weight(k, 0));
		while (!list.isEmpty()) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Weight curW = list.poll();
				if(!map.containsKey(curW.node))
					continue;
				for (Weight w:map.get(curW.node)) {
					int neighboorNode = w.node;
					int newW = curW.weight+w.weight;
					if(newW<record[neighboorNode]) {
						record[neighboorNode] = newW;
						list.add(new Weight(neighboorNode, newW));
					}
				}
			}
		}
		
		int res = 0;
		for (int i = 1; i < record.length; i++) {
			res = Math.max(record[i], res);
		}
		if(res==1000)
			return -1;
		return res;
    }
	
	public static void main(String[] args) {
//		int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
//		int n = 4;
//		int k = 2;
		
		int[][] times = {{1,2,1}};
		int n=2;
		int k=2;
		
		T743 t743 = new T743();
		System.out.println(t743.networkDelayTime(times, n, k));
	}
}
