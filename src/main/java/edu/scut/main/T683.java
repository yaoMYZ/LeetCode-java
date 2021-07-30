package edu.scut.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class T683 {
	
	 static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, List<TreeNode>> relations = new HashMap<>();
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
        	Stack<TreeNode> nStack = new Stack<>();
        	while (!stack.isEmpty()) {
        		TreeNode node = stack.pop();
        		relations.computeIfAbsent(node, key->new ArrayList<>());
        		if(node.left!=null) {
        			nStack.add(node.left);
        			relations.computeIfAbsent(node.left, key->new ArrayList<>());
        			
        			relations.get(node).add(node.left);
        			relations.get(node.left).add(node);
        		}
        		if(node.right!=null) {
        			nStack.add(node.right);
        			relations.computeIfAbsent(node.right, key->new ArrayList<>());
        			
        			relations.get(node).add(node.right);
        			relations.get(node.right).add(node);
        		}
			}
        	stack = nStack;
		}
        
        int step = 0;
        stack.add(target);
        Set<TreeNode> visit = new HashSet<>();
        visit.add(target);
        while (!stack.isEmpty()&&step<k) {
        	Stack<TreeNode> nStack = new Stack<>();
        	while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				for (TreeNode treeNode : relations.get(node)) {
					if(!visit.contains(treeNode)) {
						visit.add(treeNode);
						nStack.add(treeNode);
					}
				}
			}
        	stack = nStack;
        	step++;
		}
        
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	res.add(node.val);
		}
        return res;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(5);
		TreeNode right = new TreeNode(1);
		root.left = left;
		root.right = right;
		
		left.left = new TreeNode(6);
		left.right = new TreeNode(2);
		left.right.left = new TreeNode(7);
		left.right.right = new TreeNode(4);
		
		right.left = new TreeNode(0);
		right.right = new TreeNode(8);
		
		T683 t683 = new T683();
		System.out.println(t683.distanceK(root, left, 2));
	}
}
