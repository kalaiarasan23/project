package com;

import java.util.Scanner;

public class ShortestString_5 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter String : ");
		String s=in.nextLine();
		int n1=s.length();

		System.out.println("Enter Find String : ");
		String findString=in.nextLine();
		int n2=findString.length();
		
		
		char A[]=s.toCharArray();
		char B[]=findString.toCharArray();
		
		 fintShortestString(A,B,n1,n2);
		
	}

	private static void fintShortestString(char[] A, char[] B, int n1, int n2) {
		
		int k=0; // B's String index
		
		int minCount=0; int startPosition=0; int endPosition=0;
		int flag=0;
		for(int i=0;i<n1;i++) {
			if(A[i]==B[k]) {
				k++;
				for(int j=i+1;j<n1;j++) {
					
					if(A[j]==B[k]) {
						k++;
					}
					if(k==n2) {
						int count=j-i+1;
						//for first value set
						if(flag==0) {
							minCount=count;
							startPosition=i;
							endPosition=j;
							flag++;
						}
						if(minCount>count) {
							minCount=count;
							startPosition=i;
							endPosition=j;
							
						}

					}
					if(k==n2) {
						break;
					}
				}
			}
			k=0;
		}
		
		printMinString(A,startPosition,endPosition);
		
		
	}

	private static void printMinString(char[] A, int startPosition, int endPosition) {
		
		for(int i=startPosition;i<=endPosition;i++) {
			System.out.print(A[i]);
		}
	}

	
}
