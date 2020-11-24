package edu.scut.yao;


public class T543 {
	public int diameterOfBinaryTree(TreeNode root) {
		if(root==null)
			return 0 ;
		int[] result = diameter(root);
		return result[1]-1;
    }
	
	private int[] diameter(TreeNode root) {
		if(root==null) {
			return new int[]{0,0};
		}
		int[] left = diameter(root.left);
		int[] right = diameter(root.right);
		int childMaxPath = Math.max(left[1], right[1]);
		return new int[] {Math.max(left[0], right[0])+1,Math.max(left[0]+right[0]+1,childMaxPath)};
 	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		T543 t543 = new T543();
		t543.diameterOfBinaryTree(root);
		System.err.println(root);
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}