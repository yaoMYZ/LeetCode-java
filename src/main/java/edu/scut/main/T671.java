package edu.scut.main;

public class T671 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	private boolean assign = false;
	
	public int findSecondMinimumValue(TreeNode root) {
		int res = df(root, root.val);
		if(assign) { // 用assign符号避免节点数值等于Integer.MAX_VALUE时，使得res！=Integer.MAX_VALUE变为false返回-1的情况
			return res;
		}
		else {
			return -1;
		}
	}
	
	
	private int df(TreeNode node,int min) {
		if(node.left==null)
			return Integer.MAX_VALUE;
		int curMin = Integer.MAX_VALUE;
		
		if(node.left.val>node.right.val) {
			if(node.left.val!=min) {
				assign = true;
				curMin = node.left.val;
			}
				
			return Math.min(curMin, df(node.right, min));
		}else if(node.left.val<node.right.val) {
			if(node.right.val!=min) {
				assign = true;
				curMin = node.right.val;
			}
			return Math.min(curMin, df(node.left, min));
		}else {
			return Math.min(df(node.right, min), df(node.left, min));
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2147483647);
		
		T671 t671 = new T671();
		System.out.println(t671.findSecondMinimumValue(root));
	}
}
