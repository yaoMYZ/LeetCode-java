package edu.scut.jianzhi;

import java.util.Stack;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class T025 {
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(-1);
        ListNode result = root;
        Stack<ListNode> tmp = new Stack<>();
        while(head != null) {
        	for (int i = 0; i < k && head!=null; i++) {
				tmp.add(head);
				head = head.next;
			}
        	if(tmp.size()!=k) {
        		while (tmp.size()!=1) {
					tmp.pop();
				}
        		root.next = tmp.peek();
        	}else {
        		while(!tmp.isEmpty()) {
        			root.next = tmp.peek();
        			tmp.pop();
        			root=root.next;
        		}
        		root.next = null;
        	}
        }
        return result.next;
    }
}
