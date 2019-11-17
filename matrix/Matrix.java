package org.suai.lab8.matrix;

public class Matrix {

	private int[][] data;

	private int rows;

	private int cols;

	public Matrix(int rows, int cols) {
		if (rows <= 0 & cols <= 0)
			throw new RuntimeException("Wrong mtx parameters");

		this.rows = rows;
		this.cols = cols;
		this.data = new int[rows][cols];
	}

	public void randomInit() {
		int randomValue = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				randomValue = (int) (Math.random() * 100);
				data[i][j] = randomValue;
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public void setElement(int row, int col, int value) {
		if (rows <= 0 & cols <= 0)
			throw new RuntimeException("Wrong mtx parameters");

		this.data[row][col] = value;
	}

	public int getElement(int row, int col) {
		
		if (rows <= 0 & cols <= 0)
			throw new RuntimeException("Wrong mtx parameters");

		return this.data[row][col];
	}

	public Matrix product(Matrix factor) {

		if (this.getCols() != factor.getRows())
			throw new RuntimeException("Error in product. Mtxs have different size ");

		else {
			Matrix result = new Matrix(this.data.length, factor.getCols());
			for (int i = 0; i < this.getRows(); i++) {
				for (int j = 0; j < factor.getCols(); j++) {
					int sumElem = 0;
					for (int c = 0; c < this.getCols(); c++)
						sumElem += getElement(i, c) * factor.getElement(c, j);
					result.setElement(i, j, sumElem);
				}
			}
			return result;
		}
	}

	public boolean equals(Matrix o) {

		if (this.getRows() != o.getRows() & this.getCols() != o.getCols())
			return false;
		else {
			for (int i = 0; i < getRows(); i++) {
				for (int j = 0; j < getCols(); j++) {
					if (getElement(i, j) != o.getElement(i, j))
						return false;
				}
			}
		}
		return true;
	}

	public String toString() {
		
	    StringBuilder builder = new StringBuilder();
	    
	    for(int i = 0; i < getRows(); i++) {
	    	
	      for(int j = 0; j < getCols(); j++) 
			builder.append(data[i][j]).append(' ');
	      
	      builder.append('\n');
	    }
	    return builder.toString();
    }
}
