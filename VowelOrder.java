

public class VowelOrder {

    public static void main (String[] argv)
    {
	test ();
	checkAllWords ();
    }

    static void checkAllWords ()
    {
	// Because there aren't many words with all vowels, let's 
	// reduce the number of vowels to see how many words we get.
	char[] vowels = {'a','e','i','o'};
	String[] words = WordTool.getAllWords ();
	for (String w: words) {
	    boolean yes = checkOrder (w.toCharArray(), 0, vowels, 0);
	    if (yes) {
		System.out.println (w);
	    }
	}
    }

    static void test ()
    {
	//String str = "sacrilegious";
	//String str = "abstemious";
	String str = "egregious";
	char[] letters = str.toCharArray ();
	char[] vowels = {'a','e','i','o','u'};

	boolean yes = checkOrder (letters, 0, vowels, 0);
	System.out.println (str + ": " + yes);
    }

    static boolean checkOrder (char[] word, int positionInWord, char[] vowels, int positionInVowels)
    {
	// HANDLE THE BOTTOM-OUT HERE:
	if (positionInVowels >= vowels.length) {
	    return true;
	}

	if (positionInVowels < vowels.length-1 && positionInWord >= word.length) {
	    return false;
	}

	// THE REST:
	char c = vowels[positionInVowels];
	for (int k=positionInWord; k<word.length; k++) {
	    if (word[k] == c) {
		return checkOrder (word, k+1, vowels, positionInVowels+1);
	    }
	}

	// Not found.
	return false;
    }

}
