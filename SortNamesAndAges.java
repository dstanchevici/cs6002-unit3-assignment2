import java.util.*;

public class SortNamesAndAges {

    public static void main (String[] argv)
    {
	// Test 1:
	String[] names = {"Dave", "Carol", "Alice","Bob", "Franco", "Ella"};
	int[] ages = {23, 21, 24, 27, 25, 22};
	performTest (names, ages);
	/*
	// Test 2:
	String[] names2 = {"LaTisha", "Irene", "Harry", "Kay", "Jenny"};
	int[] ages2 = {21, 23, 22, 25, 27};
	performTest (names2, ages2);
	*/
    }

    static void performTest (String[] names, int[] ages)
    {
	int[] originalOrder = new int [names.length];
	for (int i=0; i<names.length; i++) {
	    originalOrder[i] = i;
	}

	// IMPORTANT: the sortByAge() method should NOT change the
	// order of the original data.
	// I'm not sure why I need to send both ages and names to sortByAge,
	//   so I'll try sending just ages.
	int[] sortOrder = sortByAge (ages);
	//int[] sortOrder = sortByAge (names, ages);
	System.out.println ("\nSort by age: ");
	print (names, ages, sortOrder);

	
	// IMPORTANT: the sortByName() method should NOT change the
	// order of the original data.
	System.out.println ("\nSort by name: ");
	sortOrder = sortByName (names);
	print (names, ages, sortOrder);
	

	System.out.println ("\nOriginal order: ");
	print (names, ages, originalOrder);
    }

    static int[] sortByName (String[] names)
    {
	int[] sortOrder = new int [names.length];
	
	String[] copyNames = new String [names.length];
	for (int i=0; i < copyNames.length; i++) {
	    copyNames[i] = names[i];
	}

	for (int i=0; i < sortOrder.length; i++) {
	    
	    int minInd = 0;
		
	    for (int j = 0; j < copyNames.length; j++) {
		if ( copyNames[j].compareTo(copyNames[minInd]) < 0 ) {
		    minInd = j;
		}
	    }

	    copyNames[minInd] = "zzzz";
	    sortOrder[i] = minInd;

	} 
	
	return sortOrder;
    }
    
    
    static int[] sortByAge (int[] ages)
    {
	int[] sortOrder = new int [ages.length];
	
	int[] copyAges = new int [ages.length];
	for (int i=0; i < copyAges.length; i++) {
	    copyAges[i] = ages[i];
	}

	for (int i=0; i < copyAges.length; i++) {
	    
	    int minInd = 0;
		
	    for (int j = 0; j < copyAges.length; j++) {
		if ( copyAges[j] < copyAges[minInd] ) {
		    minInd = j;
		}
	    }

	    copyAges[minInd] = 1_000;
	    sortOrder[i] = minInd;	    
	} 
	
	return sortOrder;
    }

    static void print (String[] names, int[] ages, int[] sortOrder)
    {
	for (int i=0; i<names.length; i++) {
	    System.out.println (names[sortOrder[i]] + " is " + ages[sortOrder[i]] + " old");
	}
    }

}
