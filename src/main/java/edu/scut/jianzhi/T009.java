package edu.scut.jianzhi;

import java.util.Stack;

public class T009 {
	private Stack<Integer> A,B;
	public T009() {
		A = new Stack<>();
		B= new Stack<>();
    }
    
    public void appendTail(int value) {
    	A.add(value);
    }
    
    public int deleteHead() {
    	if(B.isEmpty()) {
    		if(A.isEmpty())
    			return -1;
    		while(!A.isEmpty()) {
    			B.add(A.pop());
    		}
    	}
    	return B.pop();
    }
}
