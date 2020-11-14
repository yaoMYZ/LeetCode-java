package edu.scut.main;

import java.util.ArrayList;
import java.util.List;

public class T437 {
	private int record = 0;
	
	public int pathSum(TreeNode root, int sum) {
		List<Integer> sumList = new ArrayList<>();
		dfs(root, sum, sumList);
		return record;
	}
	
	private void dfs(TreeNode node,int sum,List<Integer> sumList) {
		if(node==null)
			return;
		sumList.add(0);
		for (int i = 0; i < sumList.size(); i++) {
			sumList.set(i, sumList.get(i)+node.val);
			if(sumList.get(i)==sum)
				record++;
		}

		dfs(node.right, sum, sumList);
		dfs(node.left, sum, sumList);
		
		sumList.remove(sumList.size()-1);
		for (int i = 0; i < sumList.size(); i++) {
			sumList.set(i, sumList.get(i)-node.val);
		}
	}
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
	    this.val = val;
	    this.left = left;
	    this.right = right;
	}
}