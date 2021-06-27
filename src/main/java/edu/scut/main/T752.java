package edu.scut.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class T752 {
	public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<String>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        if (dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer("0000");
        Set<String> seen = new HashSet<String>();
        seen.add("0000");

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String status = queue.poll();
                for (String nextStatus : get(status)) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    // 枚举 status 通过一次旋转得到的数字
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }

	
	public static void main(String[] args) {
		String[] deadends = {"0201","0101","0102","1212","2002"};
		String target = "0202";
		T752 t752 = new T752();
		System.out.println(t752.openLock(deadends, target));
//		char[] str = {'0','1'};
//		HashSet<String> set = new HashSet<>();
//		set.add(new String(str));
//		char[] strs = {'0','1'};
//		if(set.contains(new String(strs)))
//			System.out.println("true");
	}

}
