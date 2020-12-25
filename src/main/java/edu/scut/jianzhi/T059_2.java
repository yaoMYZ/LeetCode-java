package edu.scut.jianzhi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class T059_2 {
	private Queue<Integer> A,B;
	private int maxV = -1;
	public T059_2() {
		A = new LinkedList<>();
		B = new LinkedList<>();
    }
    
    public int max_value() {
    	return maxV;
    }
    
    public void push_back(int value) {
    	A.add(value);
    	if(B.isEmpty()||value>=maxV) {
    		B.add(value);
    		maxV = value;
    	}
    }
    
    public int pop_front() {
    	if(A.isEmpty())
    		return -1;
    	int a = A.peek();
    	A.poll();
    	if(!B.isEmpty()) {
    		int b = B.peek();
        	if(a==b)
        		B.poll();
    	}
    	if(B.isEmpty()) {
			maxV = -1;
			for (Integer integer : A) {
				if(integer>=maxV) {
		    		B.add(integer);
		    		maxV = integer;
		    	}
			}
    	}
    	return a;
    }
    
    public static void main(String[] args) {
		T059_2 t059_2 = new T059_2();
		t059_2.push_back(1);
		t059_2.push_back(2);
		System.out.println(t059_2.max_value());
		System.out.println(t059_2.pop_front());
		System.out.println(t059_2.max_value());
	}
}



//class MaxQueue {
//    Queue<Integer> q;
//    Deque<Integer> d;
//
//    public MaxQueue() {
//        q = new LinkedList<Integer>();
//        d = new LinkedList<Integer>();
//    }
//    
//    public int max_value() {
//        if (d.isEmpty()) {
//            return -1;
//        }
//        return d.peekFirst();
//    }
//    
//    public void push_back(int value) {
//        while (!d.isEmpty() && d.peekLast() < value) {
//            d.pollLast();
//        }
//        d.offerLast(value);
//        q.offer(value);
//    }
//    
//    public int pop_front() {
//        if (q.isEmpty()) {
//            return -1;
//        }
//        int ans = q.poll();
//        if (ans == d.peekFirst()) {
//            d.pollFirst();
//        }
//        return ans;
//    }
//}

