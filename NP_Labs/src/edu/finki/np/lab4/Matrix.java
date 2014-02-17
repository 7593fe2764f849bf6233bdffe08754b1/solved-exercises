package edu.finki.np.lab4;

public class Matrix<T> {

	private int rows;
	private int columns;
	private T elements[][];

	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		elements = (T[][]) new Object[rows][columns];
	}

	public int getNumRow() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public T getElementAt(int row, int column) {
		return elements[row][column];
	}

	public void setElementAt(int row, int col, T value) {
		elements[row][col] = value;
	}

	public void fill(T element) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				elements[i][j] = element;
			}
		}
	}

	public void insertRow(int row) {
		if (row < 0 || row >= getNumRow())
			throw new IndexOutOfBoundsException();
		T[][] elems = (T[][]) new Object[rows + 1][columns];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < columns; j++) {
				elems[i][j] = elements[i][j];
			}
		}
		for (int i = 0; i < columns; i++) {
			elems[row][i] = null;
		}
		for (int i = row + 1; i < rows + 1; i++) {
			for (int j = 0; j < columns; j++) {
				elems[i][j] = elements[i - 1][j];
			}
		}
		rows++;
		elements = elems;
	}

	public void deleteRow(int row) {
		if (row < 0 || row >= getNumRow())
			throw new IndexOutOfBoundsException();
		T[][] elems = (T[][]) new Object[rows - 1][columns];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < columns; j++) {
				elems[i][j] = elements[i][j];
			}
		}
		for (int i = row; i < rows - 1; i++) {
			for (int j = 0; j < columns; j++) {
				elems[i][j] = elements[i + 1][j];
			}
		}
		rows--;
		elements = elems;
	}

	public void insertColumn(int col) {
		if (col < 0 || col >= getColumns())
			throw new IndexOutOfBoundsException();
		T[][] elems = (T[][]) new Object[rows][columns + 1];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				elems[i][j] = elements[i][j];
			}
		}
		for (int i = 0; i < rows; i++) {
			elems[i][col] = null;
		}
		for (int i = 0; i < rows; i++) {
			for (int j = col + 1; j < columns + 1; j++) {
				elems[i][j] = elements[i][j - 1];
			}
		}
		columns++;
		elements = elems;
	}

	public void deleteColumn(int col) {
		if (col < 0 || col >= getColumns())
			throw new IndexOutOfBoundsException();
		T[][] elems = (T[][]) new Object[rows][columns + 1];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				elems[i][j] = elements[i][j];
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = col; j < columns - 1; j++) {
				elems[i][j] = elements[i][j + 1];
			}
		}
		columns--;
		elements = elems;
	}

	public void resize(int row, int cols) {
		if (row == rows && cols == columns)
			return;
		T[][] elems = (T[][]) new Object[row][cols];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cols; j++) {
				if (i < rows && j < columns)
					elems[i][j] = elements[i][j];
				else
					elems[i][j] = null;
			}
		}
		columns = cols;
		rows = row;
		elements = elems;
		return;
	}

}
