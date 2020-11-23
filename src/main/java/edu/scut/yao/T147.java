package edu.scut.yao;


public class T147 {
	public ListNode insertionSortList(ListNode head) {
		ListNode hhead = new ListNode(Integer.MIN_VALUE);
		hhead.next = head;
		ListNode curNode = head;
		ListNode preNode = hhead;
		while (curNode!=null) {
			if(curNode.val>preNode.val) {
				preNode = curNode;
				curNode = curNode.next;
				continue;
			}else {
				preNode.next = curNode.next;
				ListNode insertNode = hhead;
				while (insertNode.next.val<curNode.val) {
					insertNode = insertNode.next;
				}
				curNode.next = insertNode.next;
				insertNode.next = curNode;
				
				curNode = preNode.next;
			}
			
		}
		return hhead.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		
		T147 t147 = new T147();
		ListNode result = t147.insertionSortList(head);
		while (result!=null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
