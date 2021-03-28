package edu.scut.yao;

import java.util.Stack;

public class T173 {
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
	private TreeNode curNode;
	private Stack<TreeNode> stack;
	
	public T173(TreeNode root) {
		this.curNode = root;
		stack = new Stack<>();
    }
    
    public int next() {
    	while(curNode!=null) {
    		stack.add(curNode);
    		curNode = curNode.left;
    	}
    	curNode = stack.pop();
    	int res = curNode.val;
    	curNode = curNode.right;
    	return res;
    }
    
    public boolean hasNext() {
    	return curNode!=null||!stack.isEmpty();
    }
}
