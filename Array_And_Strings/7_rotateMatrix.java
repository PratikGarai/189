// Rotate a given square matrix by 90 degree clockwise
// Also try it inplce


import java.util.Scanner;

class RotateMatrix {
	
	public int[][] rotateMatrix(int[][] matrix) 
	{
		int n = matrix.length;
		int[][] new_matrix = new int[n][n];

		for(int i=0; i<n/2; i++) {
			for(int j=i; j<n-i; j++) {
				new_matrix[i][j] = matrix[n-j-1][i];
				new_matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
				new_matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
				new_matrix[j][n-i-1] = matrix[i][j];
			}
		}
		if(n%2==1)
		{
			int ele = n/2;
			new_matrix[ele][ele] = matrix[ele][ele];
		}

		return new_matrix;
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

		int [][] new_matrix = ob.rotateMatrix(m);
		System.out.println("New matrix : ");
		ob.printMatrix(new_matrix);
		System.out.println("\n---------------------\n");
	}
}
