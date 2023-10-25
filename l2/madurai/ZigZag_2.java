package com;

public class ZigZag_2 {

	public static void main(String[] args) {
		int m=4; int n=4;
		int A[][]= {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
				};
		int sIndex=0; int eIndex=1;
		printZigZang(A,m,n,sIndex,eIndex);
		
	}

	private static void printZigZang(int[][] A, int m, int n,int startI,int startJ) {
		
//		System.out.println("Come : " + startI + " : " + startJ);
		//right
		int temp = -1;
		for( int j=startJ;j<n;j++) {
			System.out.print(A[startI][j] + " ");
			temp=j;
			
		}
		System.out.println();
		if(temp!=-1) {
			startJ=temp;
			
		}
		
		
		
//		System.out.println("First" + startI + " : " + startJ);
		//down left
		
		int temp2 = -1;
		 for(int i=startI+1,j=startJ-1;i<n && j>=0;i++,j--) {
			 System.out.print(A[i][j] + " ");
			 temp=i;
			 temp2=j;
		 }
			System.out.println();
			
			
		if(temp!=-1) {
			
			startI=temp;
		}
		if(temp2!=-1) {
			startJ=temp2;
		}
		
//		System.out.println("Second : " + startI + " : " + startJ);
		 //right
		  temp=-1;
		 for(int j=startJ+1;j<n;j++) {
			 System.out.print(A[startI][j] + " ");
			 temp=j;
		 }
			System.out.println();
			
			if(temp!=-1) {
				startJ=temp;
				
			}
			
//			System.out.println("Third : " + startI + " : " + startJ);
		
		
		
		
		
	}
}
