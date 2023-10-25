package com;

import java.util.Scanner;

public class SpiralMatrix_4 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
//		System.out.println("Enter Row : ");
//		int m=in.nextInt();
//		System.out.println("Enter Column : ");
//		int n=in.nextInt();
//		
//		char A[][] = new char[m][n]; 
//		
//		System.out.println("Enter Matrix : ");
//		for(int i=0;i<m;i++) {
//			for(int j=0;j<n;j++) {
//				A[i][j]=in.next().charAt(0);
//			}
//		}
		/**/
		int m=5; int n=6;
		char A[][]= {
				{'i','l','o','v','e','a'},
				{'d','i','n','t','z','b'},
				{'n','e','w','e','o','c'},
				{'a','i','v','r','h','d'},
				{'m','a','x','e','o','e'}
		};
		
		
		printSpiralMatrix(A,m,n);
	
		//printMatrix(A,m,n);
		
		
	}

	private static void printSpiralMatrix(char[][] A, int m, int n) {
		int a=0; int b=n-1; 
		int c=0; int d=m-1;
		
		while(a<=b && c<=d) {
			//right
			for(int i=a;i<=b;i++) {
				System.out.print(A[c][i] + " ");
			}
			c++;
			//down
			for(int i=c;i<=d;i++) {
				System.out.print(A[i][b] + " ");
			}
			b--;
			if(a<=b && c<=d)
			for(int i=b;i>=a;i--) {
				System.out.print(A[d][i] + " ");

			}
			d--;
			if(a<=b && c<=d)
			for(int i=d;i>=c;i--) {
				System.out.print(A[i][a] + " ");

			}
			a++;
			
		}
		
		
	}

	private static void printMatrix(char[][] A, int m, int n) {
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
