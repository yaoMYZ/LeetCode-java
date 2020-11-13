package edu.scut.main;

public class T328 {
	public ListNode oddEvenList(ListNode head) {
		if(head==null)
			return head;
		ListNode curOddNode = head;
		if(head.next==null)
			return head;
		ListNode evenNode = head.next;
		ListNode curEvenNode = evenNode;
		ListNode curNode = curEvenNode.next;
		while (curNode!=null) {
			curOddNode.next = curNode;
			curOddNode = curOddNode.next;
			
			if(curNode.next==null)
				break;
			else {
				curEvenNode.next = curNode.next;
				curEvenNode = curEvenNode.next;
				curNode = curNode.next.next;
			}
		}
		curOddNode.next = evenNode;
		curEvenNode.next = null;
        return head;
    }
}


//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
