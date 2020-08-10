import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Brute force code for the Parentheses problem
 */
public class ParenthesesBF {

    /**
     * Write for Output File
     */
    static BufferedWriter writer;

    /**Recursively find the combinations that are valid, that is
     * open a bracket and close it. At no point, should the number
     * of close brackets be greater than the number of small brackets,
     * hence the first if statement in the else bracket.
    **/
    public static void parenthesesSets(int number, int position, int openBracket, int closeBracket, char space[]) throws IOException {
        if(number == closeBracket)
        {
            String value = String.copyValueOf(space);
            writer.append(value);
            writer.append('\n');
            return;
        }
        else
        {
            if(closeBracket < openBracket) {
                space[position] = ')';
                parenthesesSets(number,position+1, openBracket, closeBracket + 1, space);
            }
            if(number > openBracket) {
                space[position] = '(';
                parenthesesSets(number,position + 1, openBracket + 1, closeBracket, space);
            }
        }
    }

    /**
     * Initializing the BufferedWriter
     * @throws IOException
     */
    public static void initializeEmptyFile() throws IOException {
        writer = new BufferedWriter(new FileWriter("OutputParenthesesBF.txt"));
    }

    /**
     * @param args args[0] is the N that the function asks
     */
    public static void main (String[] args) throws IOException {
        int number = Integer.parseInt(args[0]);
        if(number > 0) {
            initializeEmptyFile();
            int positionOfOneBracket = 0;
            int numberOfOpenBracket = 0;
            int numberOfCloseBracket = 0;
            char[] spaceOccupiedByEachString = new char[2 * number];
            parenthesesSets(number, positionOfOneBracket,
                   numberOfOpenBracket, numberOfCloseBracket, spaceOccupiedByEachString);
            writer.close();
    }
        else{
            System.out.println("Please enter a number greater than 0.");
        }
    }

}
