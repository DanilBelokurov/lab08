package org.suai.lab8.threads;

import java.util.ArrayList;

public class OddNum {

	private ArrayList<Integer> array;
	private int threadsNum;
	private int result;
	
	private OddCalcThread[] threads;
	
	public OddNum(ArrayList<Integer> array, int threadsNum) {
		this.array = array;
		this.threadsNum = threadsNum;
		process();
	}
	
	private void process() {
		
		threads = new OddCalcThread[threadsNum];
		
		int cellsOnThread = array.size() / threadsNum;
		int start = 0, finish = 0;
		
		
		for(int threadIdx = 0; threadIdx <= threadsNum - 1; threadIdx++) {
			finish = start + cellsOnThread;
			
			if(threadIdx == threadsNum - 1)
				finish = array.size();
			
			threads[threadIdx] = new OddCalcThread(array, start, finish);
			threads[threadIdx].start();
			
			start = finish;
		}
	
		try {
			for(OddCalcThread thread: threads) {
				thread.join();
				result += thread.getResult();
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getResult() {
		return result;
	}
	
	
}
