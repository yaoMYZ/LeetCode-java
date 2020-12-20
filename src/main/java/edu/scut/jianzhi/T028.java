package edu.scut.jianzhi;

public class T028 {
	public boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		return jude(root.left, root.right);
    }
	
	private boolean jude(TreeNode a,TreeNode b) {
		if(a==null&&b==null)
			return true;
		if(a==null||b==null)
			return false;
		if(a.val!=b.val)
			return false;
		else
			return jude(a.left, b.right)&&jude(a.right, b.left);
			
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		T028 t028 = new T028();
		boolean r=t028.isSymmetric(root);
		System.out.println(r);
	}
}
