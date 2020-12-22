package edu.scut.jianzhi;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T041 {
	/** initialize your data structure here. */
	private PriorityQueue<Integer> A,B;
	
    public T041() {
    	A = new PriorityQueue<>();
    	B = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
    
    }
    
    public void addNum(int num) {
    	if(A.size()==0) {
    		A.add(num);
    	}
    	else if(A.size()==B.size()) {
    		if(num<B.peek()) {
    			A.add(B.poll());
    			B.add(num);
    		}else {
    			A.add(num);
    		}
    	}else {
    		if(A.peek()<num) {
    			B.add(A.poll());
    			A.add(num);
    		}else {
    			B.add(num);
    		}
    	}
    }
    
    public double findMedian() {
    	return A.size()==B.size()? (A.peek()+B.peek())/2.0:A.peek();
    }
    
    public static void main(String[] args) {
		T041 t041 = new T041();
		t041.addNum(1);
		t041.addNum(2);
		System.out.println(t041.findMedian());
		t041.addNum(3);
		System.out.println(t041.findMedian());
	}
}
