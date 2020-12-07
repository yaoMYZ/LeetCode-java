package edu.scut.jianzhi;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class T007 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int[] p1 = {0,preorder.length-1};
		int[] p2 = {0,inorder.length-1};
		return subBuildTree(preorder, p1, inorder, p2);
    }
	
	public TreeNode subBuildTree(int[] preorder,int[] p1, int[] inorder,int[] p2) {
		if(p1[1]<p1[0])
			return null;
		if(p1[1]-p1[0]==0)
			return new TreeNode(preorder[p1[0]]);
		int midV = preorder[p1[0]];
		int midVidx = 0;
		for (int i = p2[0]; i <= p2[1]; i++) {
			if(inorder[i]==midV) {
				midVidx = i;
				break;
			}
		}
		int[] lp1 = {p1[0]+1,p1[0]+midVidx-p2[0]};
		int[] lp2 = {p2[0],midVidx-1};
		TreeNode leftNode = subBuildTree(preorder, lp1, inorder, lp2);
		int[] rp1 = {p1[0]+midVidx-p2[0]+1,p1[1]};
		int[] rp2 = {midVidx+1,p2[1]};
		TreeNode rightNode = subBuildTree(preorder, rp1, inorder, rp2);
		
		TreeNode node = new TreeNode(midV);
		node.left = leftNode;
		node.right = rightNode;
		return node;
	}
	
	public static void main(String[] args) {
		T007 t007 = new T007();
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode node = t007.buildTree(preorder, inorder);
		System.out.println(node);
	}
}
