package edu.scut.main;

public class T134 {
	private int find = -1;
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < cost.length; i++) {
			if(canComplete(gas, cost, i)) {
				find = i;
				break;
			}
		}
		return find;
    }
	
	private boolean canComplete(int[] gas, int[] cost, int idx) {
		int visitNum = 0;
		int posNum = gas.length;
		int totalGas = gas[idx]-cost[idx];
		while (totalGas>=0 && visitNum<posNum) {
			visitNum++;
			idx = (idx+1)%posNum;
			totalGas += gas[idx]-cost[idx];
		}
		return visitNum>=posNum?true:false;
	}
}
