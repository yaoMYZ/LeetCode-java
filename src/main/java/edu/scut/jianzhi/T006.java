package edu.scut.jianzhi;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 
public class T006 {
	private List<Integer> result=new ArrayList<Integer>();
	
	public int[] reversePrint(ListNode head) {
		resverse(head);
		int[] r = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			r[i]=result.get(i);
		}
		return r;
    }
	
	private void resverse(ListNode node) {
		if(node==null)
			return;
		resverse(node.next);
		result.add(node.val);
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		
		T006 t006 = new T006();
		int[] r = t006.reversePrint(head);
		for (int i : r) {
			System.out.println(i);
		}
	}
}
