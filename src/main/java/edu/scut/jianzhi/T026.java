package edu.scut.jianzhi;

import java.util.ArrayList;
import java.util.List;

public class T026 {
	private List<TreeNode> nodef=new ArrayList<>();
	
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if(A==null||B==null)
			return false;
		findNode(A, B.val);
		if(nodef.size()==0)
			return false;
		for (TreeNode treeNode : nodef) {
			if(jude(treeNode, B))
				return true;
		}
		return false;
    }
	
	private void findNode(TreeNode node,int val) {
		if(node==null)
			return;
		if(node.val==val) {
			nodef.add(node);
		}
		findNode(node.left, val);
		findNode(node.right, val);
	}
	
	private boolean jude(TreeNode A, TreeNode B) {
		if(B==null)
			return true;
		else if (A==null)
			return false;
			
		if(A.val!=B.val)
			return false;
		return jude(A.left, B.left)&&jude(A.right, B.right);
	}
	
	public static void main(String[] args) {
		TreeNode A = new TreeNode(4);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);
		A.left.left.left = new TreeNode(8);
		A.left.left.right = new TreeNode(9);
		
		TreeNode B= new TreeNode(4);
		B.left = new TreeNode(8);
//		B.right = new TreeNode(9);
		
		T026 t026 = new T026();
		boolean r = t026.isSubStructure(A, B);
		System.out.println(r);
	}
}

