/**
 * 
 */
package coding.bat.solutions;

/**
 * @author Aman Shekhar
 *
 */
public class StringTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Given a string, return a string where for every char in the original, there
	// are two chars.
	//
	//
	// doubleChar("The") → "TThhee"
	// doubleChar("AAbb") → "AAAAbbbb"
	// doubleChar("Hi-There") → "HHii--TThheerree"

	public String doubleChar(String str) {
		int mLength = (str.length()) * 2;
		StringBuilder mString = new StringBuilder(mLength);
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < 2; j++) {
				mString.append(str.charAt(i));
			}
		}
		return mString.toString();
	}

	// --------------------------------------------------------------------------------------------

	//
	// Return the number of times that the string "hi" appears anywhere in the given
	// string.
	//
	//
	// countHi("abc hi ho") → 1
	// countHi("ABChi hi") → 2
	// countHi("hihi") → 2
	//
	public int countHi(String str) {
		String find = "hi";
		int start = 0;
		int count = 0;
		while (true) {
			int found = str.indexOf(find, start);
			if (found == -1)
				break;
			count++;
			start = found + find.length(); // move start up for next iteration
		}
		return count;
	}

	// --------------------------------------------------------------------------------------------

	// Return true if the string "cat" and "dog" appear the same number of times in
	// the given string.
	//
	//
	// catDog("catdog") → true
	// catDog("catcat") → false
	// catDog("1cat1cadodog") → true

	public boolean catDog(String str) {
		int mCatsCounts = 0;
		int mDogsCounts = 0;

		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i + 3).equals("cat"))
				mCatsCounts += 1;
			if (str.substring(i, i + 3).equals("dog"))
				mDogsCounts += 1;
		}
		return mCatsCounts == mDogsCounts;
	}

	// Return the number of times that the string "code" appears anywhere in the
	// given string, except we'll accept any letter for the 'd', so "cope" and
	// "cooe" count.
	//
	//
	// countCode("aaacodebbb") → 1
	// countCode("codexxcode") → 2
	// countCode("cozexxcope") → 2

	// --------------------------------------------------------------------------------------------

	public int countCode(String str) {
		int count = 0;
		for (int i = 0; i < str.length() - 3; i++) {
			if (str.charAt(i) == 'c' && str.charAt(i + 1) == 'o' && str.charAt(i + 3) == 'e')
				count += 1;
		}
		return count;
	}

	// Given two strings, return true if either of the strings appears at the very
	// end of the other string, ignoring upper/lower case differences (in other
	// words, the computation should not be "case sensitive"). Note:
	// str.toLowerCase() returns the lowercase version of a string.
	//
	//
	// endOther("Hiabc", "abc") → true
	// endOther("AbC", "HiaBc") → true
	// endOther("abc", "abXabc") → true
	//

	// --------------------------------------------------------------------------------------------

	public boolean endOther(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		return a.endsWith(b) || b.endsWith(a);
	}

	// Return true if the given string contains an appearance of "xyz" where the xyz
	// is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does
	// not.
	//
	//
	// xyzThere("abcxyz") → true
	// xyzThere("abc.xyz") → false
	// xyzThere("xyz.abc") → true
	//

	// --------------------------------------------------------------------------------------------

	public boolean xyzThere(String str) {
		if (str.length() >= 3) {
			if (str.substring(0, 3).equals("xyz"))
				return true;
			for (int i = 0; i < str.length() - 3; i++)
				if (str.substring(i + 1, i + 4).equals("xyz") && str.charAt(i) != '.')
					return true;
		}
		return false;
	}

	// Return true if the given string contains a "bob" string, but where the middle
	// 'o' char can be any char.
	//
	//
	// bobThere("abcbob") → true
	// bobThere("b9b") → true
	// bobThere("bac") → false

	// --------------------------------------------------------------------------------------------

	public boolean bobThere(String str) {
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b')
				return true;
		}
		return false;
	}

	// We'll say that a String is xy-balanced if for all the 'x' chars in the
	// string, there exists a 'y' char somewhere later in the string. So "xxy" is
	// balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if
	// the given string is xy-balanced.
	//
	//
	// xyBalance("aaxbby") → true
	// xyBalance("aaxbb") → false
	// xyBalance("yaaxbb") → false

	// --------------------------------------------------------------------------------------------

	public boolean xyBalance(String str) {
		int lastX = str.lastIndexOf("y");
		int lastY = str.lastIndexOf("x");
		return lastX == -1 && lastY == -1 || (lastX > lastY);
	}

	// Given two strings, a and b, create a bigger string made of the first char of
	// a, the first char of b, the second char of a, the second char of b, and so
	// on. Any leftover chars go at the end of the result.
	//
	//
	// mixString("abc", "xyz") → "axbycz"
	// mixString("Hi", "There") → "HTihere"
	// mixString("xxxx", "There") → "xTxhxexre"

	// --------------------------------------------------------------------------------------------

	public String mixString(String a, String b) {
		String mResult = "";
		for (int i = 0; i < Math.min(a.length(), b.length()); i++)
			mResult += "" + a.charAt(i) + b.charAt(i);
		if (a.length() > b.length())
			return mResult + a.substring(b.length());
		return mResult + b.substring(a.length());
	}

	// Given a string and an int n, return a string made of n repetitions of the
	// last n characters of the string. You may assume that n is between 0 and the
	// length of the string, inclusive.
	//
	//
	// repeatEnd("Hello", 3) → "llollollo"
	// repeatEnd("Hello", 2) → "lolo"
	// repeatEnd("Hello", 1) → "o"

	// --------------------------------------------------------------------------------------------

	public String repeatEnd(String str, int n) {
		String mResult = "";
		for (int i = 0; i < n; i++) {
			mResult += "" + str.substring(str.length() - n);
		}
		return mResult;
	}

	// Given a string and an int n, return a string made of the first n characters
	// of the string, followed by the first n-1 characters of the string, and so on.
	// You may assume that n is between 0 and the length of the string, inclusive
	// (i.e. n >= 0 and n <= str.length()).
	//
	//
	// repeatFront("Chocolate", 4) → "ChocChoChC"
	// repeatFront("Chocolate", 3) → "ChoChC"
	// repeatFront("Ice Cream", 2) → "IcI"

	// --------------------------------------------------------------------------------------------

	public String repeatFront(String str, int n) {
		String mResult = "";
		for (int i = n; i > 0; i--) {
			mResult += "" + str.substring(0, i);
		}
		return mResult;
	}

	// Given two strings, word and a separator sep, return a big string made of
	// count occurrences of the word, separated by the separator string.
	//
	//
	// repeatSeparator("Word", "X", 3) → "WordXWordXWord"
	// repeatSeparator("This", "And", 2) → "ThisAndThis"
	// repeatSeparator("This", "And", 1) → "This"

	// --------------------------------------------------------------------------------------------

	public String repeatSeparator(String word, String sep, int count) {
		String res = "";
		if (count == 0)
			return "";
		while (count > 1) {
			res += word + sep;
			count--;
		}
		return res + word;
	}

	// Given a string, consider the prefix string made of the first N chars of the
	// string. Does that prefix string appear somewhere else in the string? Assume
	// that the string is not empty and that N is in the range 1..str.length().
	//
	//
	// prefixAgain("abXYabc", 1) → true
	// prefixAgain("abXYabc", 2) → true
	// prefixAgain("abXYabc", 3) → false

	// --------------------------------------------------------------------------------------------

	public boolean prefixAgain(String str, int n) {
		String prefix = str.substring(0, n);
		for (int i = n; i <= str.length() - prefix.length(); i++)
			if (str.substring(i, i + prefix.length()).equals(prefix))
				return true;
		return false;
	}

	// Given a string, does "xyz" appear in the middle of the string? To define
	// middle, we'll say that the number of chars to the left and right of the "xyz"
	// must differ by at most one. This problem is harder than it looks.
	//
	//
	// xyzMiddle("AAxyzBB") → true
	// xyzMiddle("AxyzBB") → true
	// xyzMiddle("AxyzBBB") → false

	// --------------------------------------------------------------------------------------------

	public boolean xyzMiddle(String str) {
		int len = str.length();
		if (len < 3)
			return false;
		if (len % 2 == 1)
			return str.substring(len / 2 - 1, len / 2 + 2).equals("xyz");
		return str.substring(len / 2 - 2, len / 2 + 1).equals("xyz")
				|| str.substring(len / 2 - 1, len / 2 + 2).equals("xyz");
	}

	// A sandwich is two pieces of bread with something in between. Return the
	// string that is between the first and last appearance of "bread" in the given
	// string, or return the empty string "" if there are not two pieces of bread.
	//
	//
	// getSandwich("breadjambread") → "jam"
	// getSandwich("xxbreadjambreadyy") → "jam"
	// getSandwich("xxbreadyy") → ""

	// --------------------------------------------------------------------------------------------

	public String getSandwich(String str) {
		int mStart = str.indexOf("bread");
		int mLast = str.lastIndexOf("bread");
		if (mStart == mLast)
			return "";
		return str.substring(mStart + 5, mLast);
	}

	// Returns true if for every '*' (star) in the string, if there are chars both
	// immediately before and after the star, they are the same.
	//
	//
	// sameStarChar("xy*yzz") → true
	// sameStarChar("xy*zzz") → false
	// sameStarChar("*xa*az") → true

	// --------------------------------------------------------------------------------------------

	public boolean sameStarChar(String str) {
		for (int i = 1; i < str.length() - 1; i++)
			if (str.charAt(i) == '*' && str.charAt(i - 1) != str.charAt(i + 1))
				return false;
		return true;
	}

	// Given a string, compute a new string by moving the first char to come after
	// the next two chars, so "abc" yields "bca". Repeat this process for each
	// subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of
	// fewer than 3 chars at the end.
	//
	//
	// oneTwo("abc") → "bca"
	// oneTwo("tca") → "cat"
	// oneTwo("tcagdo") → "catdog"

	// --------------------------------------------------------------------------------------------

	public String oneTwo(String str) {
		String string = "";
		for (int i = 0; i < str.length() - 2; i += 3) {
			string += str.substring(i + 1, i + 3) + str.charAt(i);
		}
		return string;
	}

	// Look for patterns like "zip" and "zap" in the string -- length-3, starting
	// with 'z' and ending with 'p'. Return a string where for all such words, the
	// middle letter is gone, so "zipXzap" yields "zpXzp".
	//
	//
	// zipZap("zipXzap") → "zpXzp"
	// zipZap("zopzop") → "zpzp"
	// zipZap("zzzopzop") → "zzzpzp"

	// --------------------------------------------------------------------------------------------

	public String zipZap(String str) {
		for (int i = 0; i < str.length() - 2; i++)
			if (str.charAt(i) == 'z' && str.charAt(i + 2) == 'p')
				str = str.substring(0, i + 1) + str.substring(i + 2);
		return str;
	}

	// Return a version of the given string, where for every star (*) in the string
	// the star and the chars immediately to its left and right are gone. So "ab*cd"
	// yields "ad" and "ab**cd" also yields "ad".
	//
	//
	// starOut("ab*cd") → "ad"
	// starOut("ab**cd") → "ad"
	// starOut("sm*eilly") → "silly"

	// --------------------------------------------------------------------------------------------

	public String starOut(String str) {
		while (str.indexOf('*') != -1) {
			if (str.equals("*"))
				return "";
			int mFirstStar = str.indexOf('*');
			int mSecondStar = str.indexOf('*', mFirstStar + 1);
			if (mSecondStar - mFirstStar == 1) {
				str = str.substring(0, mFirstStar) + str.substring(mSecondStar);
				continue;
			}
			if (mFirstStar == 0)
				str = str.substring(mFirstStar + 2);
			else if (mFirstStar == str.length() - 1)
				str = str.substring(0, str.length() - 2);
			else
				str = str.substring(0, mFirstStar - 1) + str.substring(mFirstStar + 2);
		}
		return str;
	}

	// --------------------------------------------------------------------------------------------

	// Given a string and a non-empty word string, return a version of the original
	// String where all chars have been replaced by pluses ("+"), except for
	// appearances of the word string which are preserved unchanged.
	//
	//
	// plusOut("12xy34", "xy") → "++xy++"
	// plusOut("12xy34", "1") → "1+++++"
	// plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
	//
	public String plusOut(String str, String word) {
		int start = 0;
		int end = str.indexOf(word);
		while (end != -1) {
			for (int i = start; i < end; i++)
				str = str.substring(0, i) + "+" + str.substring(i + 1);
			start = end + word.length();
			end = str.indexOf(word, start);
		}
		for (int i = start; i < str.length(); i++)
			str = str.substring(0, i) + "+" + str.substring(i + 1);
		return str;
	}

	// --------------------------------------------------------------------------------------------

	// Given a string and a non-empty word string, return a string made of each char
	// just before and just after every appearance of the word in the string. Ignore
	// cases where there is no char before or after the word, and a char may be
	// included twice if it is between two words.
	//
	//
	// wordEnds("abcXY123XYijk", "XY") → "c13i"
	// wordEnds("XY123XY", "XY") → "13"
	// wordEnds("XY1XY", "XY") → "11"

	public String wordEnds(String str, String word) {
		String res = "";
		int pos = str.indexOf(word);
		while (pos != -1) {
			if (pos != 0)
				res += str.charAt(pos - 1);
			if (pos + word.length() == str.length())
				break;
			res += str.charAt(pos + word.length());
			pos = str.indexOf(word, pos + 1);
		}
		return res;
	}
}
