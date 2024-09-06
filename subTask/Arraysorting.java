package subTask;

import java.util.Arrays;
import java.util.Collections;

public class Arraysorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,5,6,789,6,43,6,7};
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
		System.out.println("after sorting");
		Arrays.sort(arr);
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
		
		// sort and reverse
		String ar[]= {"dfs","dfsgf","dfs","dwethfh"};
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));
		Arrays.sort(ar,Collections.reverseOrder());
		System.out.println(Arrays.toString(ar));
		
	}

}
