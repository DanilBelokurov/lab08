package org.suai.lab8.threads;

import java.util.ArrayList;

public class OddCalcThread extends Thread{

	private ArrayList<Integer> array;
	private int result;
	private int start, finish;
	
	public OddCalcThread(ArrayList<Integer> array, int start, int finish) {
		this.array = array;
		this.start = start;
		this.finish = finish;
	}
	
	public void run() {
		for(int i = start; i < finish; i++) {
			if(array.get(i) % 2 != 0)
				result++;
		}
	}
	
	public int getResult() {
		return result;
	}
	
}
