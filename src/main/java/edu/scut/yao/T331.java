package edu.scut.yao;

import java.util.Stack;

public class T331 {
    public boolean isValidSerialization(String preorder) {
    	String[] pArr = preorder.split(",");
    	if(pArr.length<=0)
    		return true;
    	Stack<String> tmp = new Stack<>();
    	tmp.add(pArr[0]);
    	int idx = 0;
    	while(!tmp.empty()&&idx<pArr.length) {
    		Stack<String> newTmp = new Stack<>();
    		while(!tmp.empty()) {
    			if(!tmp.pop().equals("#")) {
    				if(idx+2>=pArr.length)
    					return false;
    				newTmp.add(pArr[idx+1]);
    				newTmp.add(pArr[idx+2]);
    				idx+=2;
    			}
    		}
    		tmp = newTmp;
    	}
    	if(idx<pArr.length-1)
    		return false;
    	return true;
    }
    
    public static void main(String[] args) {
		T331 t331 = new T331();
		String preorder = "1,#";
		System.out.println(t331.isValidSerialization(preorder));
	}
}
