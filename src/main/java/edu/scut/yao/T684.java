package edu.scut.yao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class T684 {
	public int[] findRedundantConnection(int[][] edges) {
		Map<Integer, Set<Integer>> graphMap = new HashMap<>();
		for (int[] edge : edges) {
			int v1 = edge[0];
			int v2 = edge[1];
			graphMap.computeIfAbsent(v1, k->new HashSet<>());
			graphMap.get(v1).add(v2);
			graphMap.computeIfAbsent(v2, k->new HashSet<>());
			graphMap.get(v2).add(v1);
		}
		boolean find = false;
		int[] result = null;
		while (!graphMap.isEmpty()&&!find) {
			boolean removeV = false;
			Iterator<Entry<Integer, Set<Integer>>> it = graphMap.entrySet().iterator();

			while (it.hasNext()) {
				Entry<Integer, Set<Integer>> entry = it.next();
				Set<Integer> vs = entry.getValue();
				Integer key = entry.getKey();
				if(vs.size()==1) {
					removeV = true;
					for (Integer integer : vs) {
						graphMap.get(integer).remove(key);
					}
					it.remove();
				}
			}
			if(!removeV) {
				find = true;
				for (int i = edges.length-1; i >=0; i--) {
					int v1 = edges[i][0];
					int v2 = edges[i][1];
					if(graphMap.containsKey(v1)&&graphMap.containsKey(v2)) {
						result = edges[i];
						break;
					}
				}
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		T684 t684 = new T684();
		int[][] edges = {{1,3}, {3,4}, {1,5}, {3,5},{2,3}};
		int[] r = t684.findRedundantConnection(edges);
		for (int i : r) {
			System.out.println(i);
		}
	}
}
