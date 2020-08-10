import java.io.*;
import java.util.LinkedList;

public class ChocolateBF {

    /**
     * Write for Output File
     */
    static BufferedWriter writer;
    /**
     * number of rows in file
     */
    static int rowNum = 0;
    /**
     * number of columns in file
     */
    static int columnNum = 0;
    /**
     * Used for reading csv file
     */
    static String filePath;
    /**
     * variable that puts the chocolate
     * into a double array
     */
    static int [][] barOfChoc;

    /**
     * writes the solution generated into a file
     * @param solutionBar
     * @param breaks
     */
    public static void writeIntoFile(LinkedList<Integer[]> solutionBar, int breaks) throws IOException {
        writer.append(String.valueOf(breaks));
        writer.append('\n');
        for (Integer[] lines : solutionBar) {
            if(correctMatrix(lines[0],lines[1], lines[2], lines[3] )){
                writer.append("("+lines[0]+","+lines[1]+","+lines[2]+","+lines[3]+")");
                writer.append('\n');
            }
        }
        writer.close();
    }

    /**
     * checks whether subproblems sent from bars is valid or not
     * that is, contains all zeros or ones
     * @param row
     * @param column
     * @param height
     * @param width
     * @return
     */
    public static boolean correctMatrix(int row, int column, int height ,int width){
        int test = barOfChoc[row][column];
        for (int k = 0; k< height ; k++){
            for (int l = 0; l< width; l++){
                if (test != barOfChoc[row+k][column+l]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Breaks down the matrix by rows and column and puts valid
     * solutions into a linkedlist
     * @param row
     * @param column
     * @param height
     * @param width
     * @param solutionBar
     * @return
     */
    public static int bars(int row, int column, int height ,int width, LinkedList<Integer[]> solutionBar) {
        Integer[] pieceOfChoc = {row, column, height, width};
        solutionBar.add(pieceOfChoc);
        if (correctMatrix(row, column, height, width)) {
            return 0;
        }
        int solution = Integer.MAX_VALUE;
        LinkedList<Integer[]> matrixBreaks = null;
        LinkedList<Integer[]> boxTotal;

        for(int i = 1; i < width; i++) {
            boxTotal = new LinkedList<>();
            int total = 1 + bars(row,column,height,i, boxTotal) + bars(row ,column + i ,height,width-i, boxTotal) ;
            if(solution >= total) {
                solution = total;
                matrixBreaks = boxTotal;
            }
        }

        for(int i = 1; i < height; i++) {
            boxTotal = new LinkedList<>();
            int total = 1 + bars((row + i),column,height-i,width, boxTotal) + bars(row,column,i,width, boxTotal);
            if(solution >= total) {
                solution = total;
                matrixBreaks = boxTotal;
            }
        }

        solutionBar.addAll(matrixBreaks);
        return solution;
    }

    /**
     * calls recursive solution, finds breakpoints and
     * number of breaks and writes them into a file
     */
    public static void matrixWork() throws IOException {
        LinkedList<Integer[]> solutionBar = new LinkedList<>();
        int breaks = bars(0,0,rowNum,columnNum, solutionBar);
        writeIntoFile(solutionBar, breaks);
    }

    /**
     * put the chocolate bar in the file into
     * the array barOfChoc
     */
    public static void arrayChocolate() {
        int i = 0;
        int j = 0;
        barOfChoc = new int[rowNum][columnNum];
        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader(filePath));
            String lineOfFile = fileReader.readLine();
            while(lineOfFile != null) {
                for(int k = 0; k < lineOfFile.length(); k++) {
                    if(lineOfFile.charAt(k) != ',' ) {
                        barOfChoc[i][j] = Character.getNumericValue(lineOfFile.charAt(k));
                        j++;
                    }
                }
                i++;
                j = 0;
                lineOfFile = fileReader.readLine();
            }
            fileReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * find the number of rows and column in the file
     */
    public static void rowColumn() {
        int count = 0;
        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader(filePath));
            String lineOfFile = fileReader.readLine();
            while(lineOfFile != null) {
                for(int i = 0; i < lineOfFile.length(); i++) {
                    if(lineOfFile.charAt(i) != ',' && count == 0) {
                        columnNum++;
                    }
                }
                count = 1;
                rowNum++;
                lineOfFile = fileReader.readLine();
            }
            fileReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializeEmptyFile() throws IOException {
        writer = new BufferedWriter(new FileWriter("OutputChocolateBF.txt"));
    }


    /**
     * args[0] is the name of the file to be used
     * @param args
     */
    public static void main(String[] args) throws IOException {
        filePath = args[0];
        if (args[0].equals("chocolatebar1.csv") || args[0].equals("chocolatebar2.csv")) {
            initializeEmptyFile();
            rowColumn();
            arrayChocolate();
            matrixWork();
        }
        else{
            System.out.println("Please print correct name of file.");
        }
    }
}
