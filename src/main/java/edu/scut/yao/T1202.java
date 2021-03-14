package edu.scut.yao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class T1202 {
	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		UnionFind unionFind = new UnionFind(s.length());
		char[] result = new char[s.length()];
		for (List<Integer> list : pairs) {
			unionFind.union(list.get(0), list.get(1));
		}
		
		Map<Integer, PriorityQueue<Character>> idxSet = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			int p = unionFind.find(i);
			idxSet.computeIfAbsent(p, k->new PriorityQueue<>());
			idxSet.get(p).add(s.charAt(i));
		}
		
		for (int i = 0; i < result.length; i++) {
			int p = unionFind.find(i);
			result[i] = idxSet.get(p).poll();
		}
		
		return String.valueOf(result);
    }
	
	private class UnionFind {

        private int[] parent;
        /**
         * 以 i 为根结点的子树的高度（引入了路径压缩以后该定义并不准确）
         */
        private int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
			int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度仅加了 1
                rank[rootY]++;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度不变
            } else {
                // 同理，此时以 rootX 为根结点的树的高度不变
                parent[rootY] = rootX;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

	
	public static void main(String[] args) {
		T1202 t1202 = new T1202();
		String s ="dcab";
		List<List<Integer>> pairs = new ArrayList<>();
		pairs.add(Arrays.asList(0,3));
		pairs.add(Arrays.asList(1,2));
		String r = t1202.smallestStringWithSwaps(s, pairs);
		System.out.println(r);
	}
}
