package edu.scut.jianzhi;

import java.util.Stack;

public class T030 {
	Stack<Integer> A,B;
	/** initialize your data structure here. */
    public T030() {
    	A = new Stack<>();
    	B= new Stack<>();
    }
    
    public void push(int x) {
    	A.add(x);
    	if(B.isEmpty()||x<=B.peek())
    		B.add(x);
    }
    
    public void pop() {
    	int a = A.peek();
    	int b = B.peek();
    	if(a==b)
    		B.pop();
    	A.pop();
    }
    
    public int top() {
    	return A.peek();
    }
    
    public int min() {
    	return B.peek();
    }
    
    public static void main(String[] args) {
		T030 t030 = new T030();
		t030.push(512);
		t030.push(-1024);
		t030.push(-1024);
		t030.push(512);
		t030.pop();
		System.err.println(t030.min());
		t030.pop();
		System.err.println(t030.min());
		t030.pop();
		System.err.println(t030.min());
		
	}
}
