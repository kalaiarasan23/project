package dimond;

import java.util.Iterator;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4,i=0; 
		int[][] a=new int[n][n];
		createMatrix(n, a);
		int rowStart=0, rowEnd=a.length-1, colStart=0, colEnd=a.length-1;
		while(colStart<colEnd && rowStart <rowEnd) {
			for(i=colStart;i<=colEnd;i++)
				System.out.print(a[rowStart][i]+" ");
			rowStart++;
			
			for(i=rowStart;i<=rowEnd;i++)
				System.out.print(a[i][colEnd]+" ");
			
			colEnd--;
			
			for(i = colEnd; i>=colStart ; i--)
				System.out.print(a[rowEnd][i]+" ");
			rowEnd--;
			
			for(i = rowEnd; i>=rowStart ; i--)
				System.out.print(a[i][colStart]+" ");
			colStart++;
			System.out.println();
		}
	}

	private static void createMatrix(int n,  int[][] a) {
		int count=1;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j]=count++;
	}

	private static void printMatrix(int n, int[][] a) {
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				System.out.println(a[i][j]);
	}

}
