package org.suai.lab8;

import java.net.Socket;
import java.util.ArrayList;

import org.suai.lab8.matrix.Matrix;
import org.suai.lab8.threads.OddNum;
import org.suai.lab8.threads.ParallelMatrixProduct;

public class Main {
	public static void main(String[] args) {

	/*	Matrix m = new Matrix(2000,2000);
		m.randomInit();
		Matrix m1 = new Matrix(2000,2000);
		m1.randomInit();
		
		long startTime = System.currentTimeMillis();
		Matrix m2 = m.product(m1);
		long endTime = System.currentTimeMillis();
		System.out.println("Однопоточное умножение -> " + (endTime - startTime));
		
		for(int i = 2; i <=8; i++) {
			startTime = 0;
			endTime = 0;
			
			startTime = System.currentTimeMillis();
			ParallelMatrixProduct pmp = new ParallelMatrixProduct(i, m, m1);
			endTime = System.currentTimeMillis();
			System.out.println("Многопоточное умножение ["+ i + "] " + (endTime - startTime));
			
			if(m2.equals(pmp.getResult()))
				System.out.println("Equals");
			else
				System.out.println("NOT equals");
		}*/
		
		int randomValue = 0;
		int oneThreadResult = 0;
		int fewThreadsResult = 0;
		
		int threadsNum = 10;
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i < 1000; i++) {
			randomValue = (int) (Math.random() * 1000);
			array.add(randomValue);
		//	System.out.println(array.get(i));
		}

		long startTime = System.currentTimeMillis();
		OddNum oddOne = new OddNum(array, 1);
		oneThreadResult = oddOne.getResult();
		long endTime = System.currentTimeMillis();
		System.out.println("Однопоточный поиск -> " + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		OddNum oddFew = new OddNum(array, threadsNum);
		fewThreadsResult = oddFew.getResult();
		endTime = System.currentTimeMillis();
		System.out.println("Многопоточный поиск -> " + (endTime - startTime));
		
		if(oneThreadResult == fewThreadsResult)
			System.out.println("Поиск дал одинаковый результат");
		else
			System.out.println("Поиск НЕ дал одинаковый результат");
			
		
	}
}
