package edu.scut.jianzhi;

import java.util.Stack;

public class T031 {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> tmp = new Stack<>();
		int idx = 0;
		for (int i = 0; i < popped.length; i++) {
			if(tmp.isEmpty()||(int)tmp.peek()!=popped[i]) {
				boolean find = false;
				while(idx<pushed.length) {
					if(pushed[idx]!=popped[i]) {
						tmp.add(pushed[idx]);
						idx++;
					}else {
						find = true;
						idx++;
						break;
					}
				}
				if(!find)
					return false;
			}else {
				tmp.pop();
			}
		}
		return true;
    }
}
