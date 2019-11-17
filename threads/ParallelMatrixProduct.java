package org.suai.lab8.threads;
import org.suai.lab8.matrix.Matrix;

public class ParallelMatrixProduct {

	private int threadsNum;

	private Matrix first, second, result;

	private MyThread[] threads;
	
	public ParallelMatrixProduct(int threadsNum, Matrix first, Matrix second) {
		if (threadsNum <= 0)
			throw new RuntimeException("Your num of threads is incorrect.");
		
		this.threadsNum = threadsNum;
		this.first = first;
		this.second = second;
		this.threads = new MyThread[threadsNum];
		this.result = new Matrix(first.getRows(), second.getCols());
		
		process();
	}
	
	private void process() {
		int cellsOnThread = (first.getRows() * second.getCols()) / threadsNum;
		
		int firstIdx = 0;

		int lastIdx = 0;
		
		for(int threadIdx = 0; threadIdx <= threadsNum - 1; threadIdx++) {
			lastIdx = firstIdx + cellsOnThread;
			
			if(threadIdx == threadsNum - 1)
				lastIdx = first.getRows() * second.getCols();
			
			threads[threadIdx] = new MyThread(first, second, result,firstIdx, lastIdx);
			threads[threadIdx].start();
			
			firstIdx = lastIdx;
		}
		
		try {
			for(MyThread thread: threads) {
				thread.join();
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Matrix getResult() { return result; }
}
