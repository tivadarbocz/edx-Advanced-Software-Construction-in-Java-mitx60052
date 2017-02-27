package week01;

import java.io.File;

/**
 * Created by Tivadar Bocz on 2017.02.27..
 */

/**
 * A recursive implementation always has two parts:
 *
 *  -base case, which is the simplest, smallest instance of the problem, that can't be decomposed any further.
 *  Base cases often correspond to emptiness — the empty string, the empty list, the empty set, the empty tree, zero, etc.
 *
 *  -recursive step, which decomposes a larger instance of the problem into one or more simpler or smaller instances that can be solved by recursive calls,
 *  and then recombines the results of those subproblems to produce the solution to the original problem.
 *  **********************************************************************************************************************************************************
 *  Here are two common ways that a recursive implementation can go wrong:
 *
 *  -The base case is missing entirely, or the problem needs more than one base case but not all the base cases are covered
 *  -The recursive step doesn't reduce to a smaller subproblem, so the recursion doesn't converge.
 */
public class Recursive {
    public static int counter = 0;
    private String string;
    /*****************************************************************************************/
    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
    /*****************************************************************************************/
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            ++counter;
            return 1; // base cases
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // recursive step
        }
    }
    /*****************************************************************************************/
    public static String subsequences(String word) {
        if (word.isEmpty()) {
            return ""; // base case
        } else {
            char firstLetter = word.charAt(0);
            String restOfWord = word.substring(1);

            String subsequencesOfRest = subsequences(restOfWord);

            String result = "";
            for (String subsequence : subsequencesOfRest.split(",", -1)) {
                result += "," + subsequence;
                result += "," + firstLetter + subsequence;
            }
            result = result.substring(1); // remove extra leading comma
            return result;
        }
    }

    /*****************************************************************************************/
    public static String subsequencesWithHelperMethod(String word) {
        return subsequencesAfter("", word);
    }

    /**
     * Return all subsequences of word (as defined above) separated by commas,
     * with partialSubsequence prepended to each one.
     */
    private static String subsequencesAfter(String partialSubsequence, String word) {
        if (word.isEmpty()) {
            // base case
            return partialSubsequence;
        } else {
            // recursive step
            return subsequencesAfter(partialSubsequence, word.substring(1))
                    + ","
                    + subsequencesAfter(partialSubsequence + word.charAt(0), word.substring(1));
        }
    }

    /*****************************************************************************************/
    public static String subsequences3(String word) {
        partialSubsequence = "";
        return subsequencesLouis(word);
    }

    private static String partialSubsequence = "";
    public static String subsequencesLouis(String word) {
        if (word.isEmpty()) {
            // base case
            return partialSubsequence;
        } else {
            // recursive step
            String withoutFirstLetter = subsequencesLouis(word.substring(1));
            partialSubsequence += word.charAt(0);
            String withFirstLetter = subsequencesLouis(word.substring(1));
            return withoutFirstLetter + "," + withFirstLetter;
        }
    }

    /*****************************************************************************************/

    /**
     * @param n integer to convert to string
     * @param base base for the representation. Requires 2<=base<=10.
     * @return n represented as a string of digits in the specified base, with
     *           a minus sign if n<0.
     *
     * For example, stringValue(16, 10) should return "16", and stringValue(16, 2) should return "10000".
     */
    public static String stringValue(int n, int base){
        if (n < 0) return "-" + stringValue(-n, base);
        else if (n < base) { return "" + n; }
        ////else if (n == 0) { return ""; }
        //else if (n < base) { return "0123456789".substring(n,n+1); }
        return stringValue(n/base, base) + "0123456789".charAt(n%base);
    }

    /*****************************************************************************************/

    /**
     * @param f a file in the filesystem
     * @return the full pathname of f from the root of the filesystem
     */
    public static String fullPathname(File f) {
        if (f.getParentFile() == null) {
            // base case: f is at the root of the filesystem
            return f.getName();
        } else {
            // recursive step
            return fullPathname(f.getParentFile()) + "/" + f.getName();
        }
    }
}
