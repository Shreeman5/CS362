import java.util.LinkedList;

public class Main {

    /**
     * for ConnectedComponent
     */
    /**
     * Used to store neighbors for each node
     */
    static LinkedList<Integer>[] neighborList;

    /**
     * Integer that stores the number of connected
     * components in the graph
     */
    static int components;

    /**
     * Integral to DFS, this variable will check
     * which vertices have been explored
     */
    static boolean [] exploredNode;

    /**
     * store the number of nodes used in the graph
     */
    static int nodeNum;

    /**
     * method that makes a list of neighbors
     * for each node
     * @param nodeNumber
     */
    public static void connectedComponent(int nodeNumber) {
        components = 1;
        nodeNum = nodeNumber;
        neighborList = new LinkedList[nodeNumber];
        for(int i = 0; i < nodeNumber; i++) {
            neighborList[i] = new LinkedList<>();
        }
        exploredNode = new boolean [nodeNum];
    }



    /**
     * this will store all the
     * edges such that vertices will or will not
     * have neighbors. The main graph is made here.
     * @param edge1
     * @param edge2
     */
    public static void edges(int edge1, int edge2) {
        neighborList[edge1].add(edge2);
        neighborList[edge2].add(edge1);
    }



    /**
     * do DFS at the starting node, which is 0 and
     * establish connections. Once there are no
     * connections left, check node 1, 2, 3.... n
     * until an unexplored node is found. Start DFS
     * there again until the last node n.
     */
    public static void findComponents() {
        for(int j = 0; j < nodeNum; j++) {
            if(!exploredNode[j]) {
                System.out.println("Component no: " + components);
                DFS(j);
                components++;
            }
        }
        System.out.println("Total number of components in " +
                "this graph: "+(components - 1));
    }



    /**
     * Nodes are marked explored here, after all, this
     * is the main DFS method. Run until 1 connected
     * component is found.
     * @param nodeNumber
     */
    public static void DFS(int nodeNumber) {
        exploredNode[nodeNumber] = true;
        System.out.println("Node: " + nodeNumber);

        for(int neighbor : neighborList[nodeNumber]) {
            if(!exploredNode[neighbor]) {
                DFS(neighbor);
            }
        }
    }

    public static void findMaxSub(int[] intArray, int n){
        int ans = 0, sum = 0;
        for (int i = 0; i < n; ++i)
        {
            if(sum + intArray[i] > 0)
                sum += intArray[i];
            else
                sum = 0;
            ans = Math.max(ans, sum);
        }
        System.out.println("Ans: "+ans);

    }

    /**
     * call Question2 first, then Question1 after
     * @param args
     */
    public static void main(String args[]) {

        int[] intArray = new int[]{-4, 13, 8, -13, 20, -15};
        findMaxSub(intArray, 6);

        /*
        System.out.println("Q2");
        System.out.println();
        connectedComponent(13);

        edges(0,3);
        edges(0,4);
        edges(3, 5);
        edges(4, 6);
        edges(1, 6);
        edges(1, 2);
        edges(7, 8);
        edges(8, 9);
        edges(7, 8);
        edges(10, 11);
        edges(11, 12);
        //edges(6, 10);
        //edges(5, 7);
        findComponents();


        System.out.println();

        /**
         * for isRotated

        System.out.println("Q1");
        System.out.println();
        System.out.println(isRotated("black", "lackb"));
        System.out.println(isRotated("lady", "dyal"));
        System.out.println(isRotated("homer", "unhomer"));
        System.out.println(isRotated("abcdefghijkl", "jklabcdefghi"));
        System.out.println(isRotated("Standhope", "hopestand"));
        System.out.println(isRotated("1234566", "6612345"));
        */
    }





    /**
     * finds whether rotatedWord is contained
     * in the main word
     * @param word
     * @param rotatedWord
     * @return
     */
    public static boolean isRotated(String word, String rotatedWord) {

        if(word.length() != rotatedWord.length()) {
            return false;
        }
        else {
            word = word.toLowerCase();
            rotatedWord = rotatedWord.toLowerCase();
            String wordContainer = rotatedWord + rotatedWord;
            if(wordContainer.contains(word)) {
                return true;
            }
            return false;
        }
    }

}

