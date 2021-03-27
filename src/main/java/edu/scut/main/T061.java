package edu.scut.main;


public class T061 {
	 private static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	public ListNode rotateRight(ListNode head, int k) {
		if(k==0||head==null)
			return head;
		ListNode finalEnd = head;
		ListNode end = head;
		for (int i = 0; i < k; i++) {
			end = end.next;
			if(end==null)
				end = head;
		}
		
		while (end.next!=null) {
			finalEnd = finalEnd.next;
			end = end.next;
		}
		if(finalEnd.next==null)
			return head;
		ListNode newHead = finalEnd.next;
		end.next = head;
		finalEnd.next = null;
		return newHead;
    }
}
