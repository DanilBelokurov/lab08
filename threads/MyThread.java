package org.suai.lab8.threads;

import java.util.ArrayList;

import org.suai.lab8.matrix.Matrix;

public class MyThread extends Thread{

	private Matrix first;
	private Matrix second;
	private Matrix result;
	private int firstIdx, lastIdx;
	private ArrayList<Integer> array;
	
	public MyThread(Matrix first, Matrix second, Matrix result, int firstIdx, int lastIdx) {
		this.first = first;
		this.second = second;
		this.result = result;
		this.firstIdx = firstIdx;
		this.lastIdx = lastIdx;
	}
		
	public void run() {
		for(int i = firstIdx; i < lastIdx; i++) 
			calculateValue(i / second.getCols(), i % second.getCols());
	}
	
	public void calculateValue(int row, int col) {
		int res = 0;
		for(int i = 0; i < second.getRows(); i++) 
			res += first.getElement(row, i) * second.getElement(i, col);
		
		result.setElement(row, col, res);
	}
	
	public int calcOddNum(ArrayList<Integer> array, int threadNum) {
		return 0;
	}
	
}
