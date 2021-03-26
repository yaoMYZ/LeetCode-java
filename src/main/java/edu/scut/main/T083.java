package edu.scut.main;


public class T083 {
	 private static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode hhead = new ListNode(-1000);
		hhead.next = head;
		ListNode pNode = hhead;
		ListNode curNode = pNode.next;
		while (curNode!=null) {
			if(curNode.val==pNode.val) {
				curNode = curNode.next;
				pNode.next = curNode;
			}else {
				pNode = curNode;
				curNode = curNode.next;
			}
		}
		return hhead.next;
    }
	
	public static void main(String[] args) {
		T083 t083 = new T083();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		
		ListNode res = t083.deleteDuplicates(head);
		while(res!=null) {
			System.out.println(res.val);
			res = res.next;
		}
		
	}
}
