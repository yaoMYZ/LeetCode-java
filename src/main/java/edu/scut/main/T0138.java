package edu.scut.main;

import java.util.HashMap;

public class T0138 {
	
	private class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	public Node copyRandomList(Node head) {
		HashMap<Node, Node> map = new HashMap<>();
		Node newHead = new Node(-1);
		Node tmp = head;
		Node curNode = newHead;
        while(tmp!=null) {
        	Node newNode = new Node(tmp.val);
        	map.put(tmp, newNode);
        	
        	curNode.next = newNode;
        	curNode = curNode.next;
        	tmp = tmp.next;
        }
        tmp = head;
        curNode = newHead.next;
        while(tmp!=null) {
        	Node ramNode = tmp.random;
        	if(ramNode!=null) {
        		curNode.random = map.get(ramNode);
        	}
        	curNode = curNode.next;
        	tmp = tmp.next;
        }
        return newHead.next;
    }
}
