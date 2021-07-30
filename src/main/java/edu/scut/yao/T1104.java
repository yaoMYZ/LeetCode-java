package edu.scut.yao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class T1104 {
	public List<Integer> pathInZigZagTree(int label) {
		int[] record = new int[10000001];
		Arrays.fill(record, -1);
		record[1] = 1;
		
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		int count = 1;
		while (count<=label) {
			Stack<Integer> nStack = new Stack<>();
			while (!stack.isEmpty()) {
				int parent = stack.pop();
				record[++count] = parent;
				nStack.add(count);
				record[++count] = parent;
				nStack.add(count);
			}
			stack = nStack;
		}
		return getRes(label, record);
    }
	
	private ArrayList<Integer> getRes(int label,int[] record){
		if(record[label]==label) {
			ArrayList<Integer> res = new ArrayList<>();
			res.add(label);
			return res;
		}
		ArrayList<Integer> res = getRes(record[label], record);
		res.add(label);
		return res;
	}
	
	public static void main(String[] args) {
		T1104 t1104 = new T1104();
		System.out.println(t1104.pathInZigZagTree(26));
	}
}
