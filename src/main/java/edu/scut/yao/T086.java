package edu.scut.yao;

public class T086 {
	public ListNode partition(ListNode head, int x) {
		ListNode first = new ListNode(-1);
		ListNode tmpF = first;
		ListNode second = new ListNode(-1);
		ListNode tmpS = second;
		while (head!=null) {
			if(head.val<x) {
				tmpF.next = head;
				tmpF = tmpF.next;
			}else {
				tmpS.next = head;
				tmpS = tmpS.next;
			}
			head = head.next;
		}
		tmpS.next = null;
		tmpF.next = second.next;
		return first.next;
    }
	
	public static void main(String[] args) {
		T086 t086 = new T086();
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		t086.partition(head, 3);
	}
}
