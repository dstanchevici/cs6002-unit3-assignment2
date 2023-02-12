import java.util.*;

public class SelectionSortRecursion {

    public static void main (String[] argv)
    {
	int[] A = {51, 24, 63, 73, 42, 85, 71, 41, 87, 32};
	selectionSortRecursive (A, 0);
	System.out.println (Arrays.toString(A));

	
	String[] B = {"the", "quick", "brown", "fox", "jumps", "over", "a", "lazy", "dog"};
	selectionSortRecursive (B, 0);
	System.out.println (Arrays.toString(B));
	
    }

    static void selectionSortRecursive (String[] A, int startOfRemainder)
    {
	// Bottom out case.
	if (startOfRemainder >= A.length-1) {
	    return;
	}

	// Find the smallest value from A[startOfRemainder] to A[A.length-1]
	// and swap that into A[startOfRemainder].
	int smallestInd = startOfRemainder;
	for (int i = smallestInd+1; i < A.length; i++) {
	    if (A[i].compareTo(A[smallestInd]) < 0) {
		smallestInd = i;
	    }
	}

	String temp = A[startOfRemainder];
	A[startOfRemainder] = A[smallestInd];
	A[smallestInd] = temp;
	
	// Recurse from next position onwards.
	selectionSortRecursive (A, startOfRemainder+1);
    }
    
    static void selectionSortRecursive (int[] A, int startOfRemainder)
    {
	// Bottom out case.
	if (startOfRemainder >= A.length-1) {
	    return;
	}

	// Find the smallest value from A[startOfRemainder] to A[A.length-1]
	// and swap that into A[startOfRemainder].
	int smallestInd = startOfRemainder;
	for (int i = smallestInd+1; i < A.length; i++) {
	    if (A[i] < A[smallestInd]) {
		smallestInd = i;
	    }
	}

	int temp = A[startOfRemainder];
	A[startOfRemainder] = A[smallestInd];
	A[smallestInd] = temp;
	
	// Recurse from next position onwards.
	selectionSortRecursive (A, startOfRemainder+1);
    }

}
