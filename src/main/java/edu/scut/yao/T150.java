package edu.scut.yao;

import java.util.Stack;

public class T150 {
	
	public int evalRPN(String[] tokens) {
		Stack<Integer> tmp = new Stack<>();
		for(int i=0;i<tokens.length;i++) {
			String opStr = tokens[i];
			Character lastChar = opStr.charAt(opStr.length()-1);
			if(Character.isDigit(lastChar))
				tmp.add(Integer.valueOf(opStr));
			else {
				int num2 = tmp.pop();
				int num1 = tmp.pop();
				tmp.add(operation(num1, num2, opStr));
			}
		}
		return tmp.pop();
    }
	
	private int operation(int num1,int num2,String op) {
		switch (op) {
		case "+":
			return num1+num2;
		case "-":
			return num1-num2;
		case "*":
			return num1*num2;
		case "/":
			return num1/num2;
		default:
			throw new IllegalArgumentException("´íÎó²Ù×÷·û£º"+op);
		}
	}
	
	public static void main(String[] args) {
		T150 t150 = new T150();
		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.println(t150.evalRPN(tokens));
	}
}
