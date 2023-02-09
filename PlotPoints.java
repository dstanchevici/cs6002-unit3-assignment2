import java.util.*;

public class PlotPoints {

    public static void main (String[] argv)
    {
	DrawTool.display ();
	DrawTool.setXYRange (0,10, 0,10);

	double[] x = {4.82, 1.61, 7.22, 2.4, 8.78, 3.2, 5.59, 6.38, 8.0, 4.0};
	double[] y = {1.51, 6.12, 3.44, 4.2, 7.28, 2.8, 1.64, 2.28, 5.1, 1.9};

	System.out.println ("x: " + Arrays.toString(x));
	System.out.println ("y: " + Arrays.toString(y));
	sort (x, y, 0, x.length-1);
	System.out.println ("x sorted: " + Arrays.toString(x));
	System.out.println ("y sorted: " + Arrays.toString(y));	
        DrawTool.drawCurve (x,y);
    }


    // Merge sort
    static void sort (double[] x, double[] y, int L, int E)
    {
	//Base case
	if (L == E) {
	    return;
	}

	int middle = (L+E) / 2;

	// Recursively sort the left half.
	sort (x, y, L, middle);

	// Recursively sort the right half.
	sort (x, y, middle+1, E);

	// Merge the two halves (by now sorted):
	mergeRange (x, y, L, middle+1, E);
	
    }

    static void mergeRange (double[] x, double[] y, int L, int R, int E)
    {
	// Create the merge space.
	double[] xMergeSpace = new double [E-L+1];
	double[] yMergeSpace = new double [E-L+1];	

	// Use two cursors, for left and right sides.
	int leftCursor = L;
	int rightCursor = R;

	// Fill mergeSpaces
	for (int i=0; i < xMergeSpace.length; i++) {
	    
	    // If leftCursor is past limit, merge from right
	    if (leftCursor >= R) {
		xMergeSpace[i] = x[rightCursor];
		yMergeSpace[i] = y[rightCursor];
		rightCursor++;
	    }
	    // If rightCurso is past limit, merge from left
	    else if (rightCursor > E) {
		xMergeSpace[i] = x[leftCursor];
		yMergeSpace[i] = y[leftCursor];
		leftCursor++;
	    }
	    // Otherwise, if left half element is less, move it
	    else if (x[leftCursor] <= x[rightCursor]) {
		xMergeSpace[i] = x[leftCursor];
		yMergeSpace[i] = y[leftCursor];
		leftCursor++;
	    }
	    // Finally, in all other cases move from right.
	    else {
		xMergeSpace[i] = x[rightCursor];
		yMergeSpace[i] = y[rightCursor];
		rightCursor++;
	    }
	} // end-for

	// Copy back into data
	for (int i=0; i < xMergeSpace.length; i++) {
	    x[L+i] = xMergeSpace[i];
	    y[L+i] = yMergeSpace[i];
	}
    } //end-mergeRange

}
