// Given a MxN matrix, set entire rows adn columns to 0 if that place has one

import java.util.Scanner;

class ZeroMatrix {

	public void getZeroMatrixInplace(int[][] matrix) {
		int m = matrix.length;
		if(m==0)
			return;
		int n = matrix[0].length;
		boolean zeroFirstRow = false, zeroFirstColumn = false;
		
		// Check if first rows and columns have zeros
		for(int i=0; i<m; i++) {
			if (matrix[i][0]==0)
				zeroFirstColumn = true;
		}
		for(int i=0; i<n; i++) {
			if (matrix[0][i]==0)
				zeroFirstRow = true;
		}

		// If body has zero, cjange values of the first rows and columns to 0
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j]==0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		// Filling rest of the body
		for(int i=1; i<m; i++) {
			if(matrix[i][0]==0) {
				for(int j=1; j<n; j++)
					matrix[i][j] = 0;
			}
		}
		for(int i=1; i<n; i++) {
			if(matrix[0][i]==0) {
				for(int j=1; j<m; j++)
					matrix[j][i] = 0;
			}
		}

		// Filling the first and second row
		if(zeroFirstRow) {
			for(int i=0; i<n; i++)
				matrix[0][i] = 0;
		}
		if(zeroFirstColumn) {
			for(int i=0; i<m; i++)
				matrix[i][0] = 0;
		}
	}

	public void printMatrix(int[][] matrix) {
		int m = matrix.length;
		if(m==0)
			return;
		int n = matrix[0].length;
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the dimensions of the matrix : ");
		int m = in.nextInt();
		int n = in.nextInt();

		int matrix[][] = new int[m][n];
		System.out.println("Enter the values : ");
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				matrix[i][j] = in.nextInt();
			}
		}

		ZeroMatrix ob = new ZeroMatrix();
		System.out.println("\nThe original matrix : ");
		ob.printMatrix(matrix);
		ob.getZeroMatrixInplace(matrix);
		System.out.println("\nThe zero matrix : ");
		ob.printMatrix(matrix);
	}
}
