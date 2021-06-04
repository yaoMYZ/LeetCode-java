package edu.scut.main;

public class T160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
	
	public static void main(String[] args) {
		T160 t160 = new T160();
		ListNode headA = new ListNode(1);
		ListNode headB = new ListNode(2);
		System.out.println(t160.getIntersectionNode(headA, headB));
	}
}
