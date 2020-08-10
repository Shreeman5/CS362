import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Dynamic Programming code for the Parentheses problem
 */
public class ParenthesesDP {

    /**
     * Write for Output File
     */
    static BufferedWriter writer;

    /**
     * Memoize strings from previous n values and use those
     * to make new Strings. Building strings of n value from
     * strings of previous n values, akin to dynamic
     * programming.
     * @param number
     * @return
     */
    public static List<String> parenthesesSets(int number) {
        if (number == 1) {
            return Arrays.asList("()");
        } else {
            Set<String> memoizationSet = new HashSet<>(number * 2);
            for (String oneString : parenthesesSets(number - 1)) {
                char[] arrayToBreakDown = oneString.toCharArray();
                int lengthOfString = oneString.length();
                for (int i = 0; i < lengthOfString; i++) {
                    String first = String.copyValueOf(arrayToBreakDown, 0, i);
                    String second = String.copyValueOf(arrayToBreakDown, i, lengthOfString - i);
                    memoizationSet.add(first + "()" + second);
                }
            }
            return new ArrayList<>(memoizationSet);
        }
    }

    /**
     * Initializing the BufferedWriter
     * @throws IOException
     */
    public static void initializeEmptyFile() throws IOException {
        writer = new BufferedWriter(new FileWriter("OutputParenthesesDP.txt"));
    }

    /**
     *
     * @param args args[0] is the N that the function asks
     * @throws IOException
     */
    public static void main (String[] args) throws IOException {
        int number = Integer.parseInt(args[0]);
        if(number > 0) {
            initializeEmptyFile();
            List<String> output = parenthesesSets(number);
            for (int i = 0; i < output.size(); i++) {
                writer.append(output.get(i));
                writer.append('\n');
            }
            writer.close();
        }
        else{
            System.out.println("Please Enter a Number > 0");
        }
    }
}
