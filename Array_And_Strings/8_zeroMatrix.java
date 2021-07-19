// Given a MxN matrix, set entire rows adn columns to 0 if that place has one

import java.util.Scanner;

class ZeroMatrix {

	public void getZeroMatrixInplace(int[][] matrix) {
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
