package edu.scut.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

public class T037 {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				stringBuilder.append(",");
				if(node!=null) {
					stringBuilder.append(String.valueOf(node.val));
					queue.add(node.left);
					queue.add(node.right);
				}else {
					stringBuilder.append("null");
				}
			}
        }
        stringBuilder.deleteCharAt(0);
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	String[] strs = data.split(",");
        TreeNode root = null;
        if(strs.length==0||strs[0].equals("null")) {
        	return root;
        }else {
        	root = new TreeNode(Integer.valueOf(strs[0]));
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int idx = 1;
        while(idx<strs.length) {
        	TreeNode curNode = queue.poll();
        	curNode.left = getNode(strs[idx++]);
        	curNode.right = getNode(strs[idx++]);
        	if(curNode.left!=null) {
        		queue.add(curNode.left);
        	}
        	if(curNode.right!=null) {
        		queue.add(curNode.right);
        	}
        }
        return root;
    }
    
    private TreeNode getNode(String str) {
    	if(str.equals("null")) {
        	return null;
        }else {
        	return new TreeNode(Integer.valueOf(str));
        }
    }
    
    public static void main(String[] args) {
		T037 t037 = new T037();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		String data = t037.serialize(root);
		TreeNode res = t037.deserialize(data);
		
		Queue<TreeNode> queue = new LinkedList<>();
        queue.add(res);
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				System.out.println(curNode.val);
				if(curNode.left!=null) {
					queue.add(curNode.left);
	        	}
	        	if(curNode.right!=null) {
	        		queue.add(curNode.right);
	        	}
			}
        }
	}
}
