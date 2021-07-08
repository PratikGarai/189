// Rotate a given square matrix by 90 degree clockwise
// Also try it inplce


import java.util.Scanner;

class RotateMatrix {
	
	public int[][] rotateMatrix(int[][] matrix) 
	{
		return matrix;
	}

	public void rotateMatrixInplace(int[][] matrix) 
	{
	}

	public void printMatrix(int[][] matrix) 
	{
		int n = matrix.length;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		RotateMatrix ob = new RotateMatrix();
		System.out.print("Enter the side length : ");
		int n = in.nextInt();
		int m[][] = new int[n][n];

		System.out.println("Enter matrix : ");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++) {
				m[i][j] = in.nextInt();
			}
		}

		System.out.println("\nOriginal matrix : ");
		ob.printMatrix(m);

		System.out.println("\n---------------------\n");
	}
}
