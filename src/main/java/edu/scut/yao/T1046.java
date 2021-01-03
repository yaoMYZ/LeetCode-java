package edu.scut.yao;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T1046 {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		
		for (Integer integer : stones) {
			queue.add(integer);
		}
		
		while(queue.size()>1) {
			int num1 = queue.poll();
			int num2 = queue.poll();
			if(num1-num2>0)
				queue.add(num1-num2);
		}
		if(queue.size()==0)
			return 0;
		return queue.peek();
	}
	
	public static void main(String[] args) {
		int[] stones = {2,7,4,1,8,1};
		T1046 t1046 = new T1046();
		int r = t1046.lastStoneWeight(stones);
		System.out.println(r);
	}
}
