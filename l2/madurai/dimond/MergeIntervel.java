package dimond;

import java.util.Arrays;

public class MergeIntervel {

    // Merge overlapping intervals in-place and return
    // the new size of the array
    public static int mergeOverlap(int[][] arr) {
       for(int i=0;i<arr.length;i++)
    	System.out.println(Arrays.toString(arr[i]));
       System.out.println();
    	// Sort intervals based on start values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        for(int i=0;i<arr.length;i++)
        	System.out.println(Arrays.toString(arr[i]));
        
        int resIdx = 0; // Index of the last merged interval

        for (int i = 1; i < arr.length; i++) {
          
            // If current interval overlaps with the last merged interval
            if (arr[resIdx][1] >= arr[i][0]) {
                arr[resIdx][1] = Math.max(arr[resIdx][1], arr[i][1]);
            } else {
                // Move to the next interval
                resIdx++;
                arr[resIdx] = arr[i];
                System.out.println(Arrays.toString(arr[resIdx])+" "+resIdx);
            }
        }

        // Return the size of the merged intervals
        return resIdx + 1;
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] arr = {{6, 8}, {1, 3}, {2, 4}, {4, 7}};
//        int arr[][] = { {1, 3}, {2, 4}, {3, 5}, {7, 9} } ;

        // Get the new size of the array after merging
        int newSize = mergeOverlap(arr);

        // Print the merged intervals based on the new size
        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i < newSize; i++) {
            System.out.print("[" + arr[i][0] + ", " + arr[i][1] + "] ");
        }
        System.out.println();
    for (int i = 0; i < arr.length; i++) 
        System.out.println(Arrays.toString(arr[i]));
    }
}

