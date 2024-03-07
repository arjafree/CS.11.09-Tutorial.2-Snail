public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (array2d == null || array2d.length == 0 || array2d[0].length == 0) {
            return new int[0];
        }
        if(!isPerfectSquare(array2d)){
            return new int[0];
        }

        int n = array2d.length;
        int[] result = new int[n * n];
        int index = 0;

        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse right
            for (int col = colStart; col <= colEnd; col++) {
                result[index++] = array2d[rowStart][col];
            }
            rowStart++;

            // Traverse down
            for (int row = rowStart; row <= rowEnd; row++) {
                result[index++] = array2d[row][colEnd];
            }
            colEnd--;

            // Traverse left
            if (rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    result[index++] = array2d[rowEnd][col];
                }
                rowEnd--;
            }

            // Traverse up
            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    result[index++] = array2d[row][colStart];
                }
                colStart++;
            }
        }

        return result;

    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if(array1d == null){
            return new int[0][0];
        }
        int n = array1d.length;
        int size = (int) Math.sqrt(n);

        if(!isPerfectSquare(array1d)){
            return new int[0][0];
        }

        int[][] snailArray = new int[size][size];
        int index = 0;

        int rowStart = 0, rowEnd = size - 1;
        int colStart = 0, colEnd = size - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse right
            for (int col = colStart; col <= colEnd; col++) {
                snailArray[rowStart][col] = array1d[index++];
            }
            rowStart++;

            // Traverse down
            for (int row = rowStart; row <= rowEnd; row++) {
                snailArray[row][colEnd] = array1d[index++];
            }
            colEnd--;

            // Traverse left
            if (rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    snailArray[rowEnd][col] = array1d[index++];
                }
                rowEnd--;
            }

            // Traverse up
            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    snailArray[row][colStart] = array1d[index++];
                }
                colStart++;
            }
        }

        return snailArray;

    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */

    private static void print1dArray(int[] array1d) {

        for(int i:array1d){
            System.out.print(array1d[i]);
        }
        System.out.println();

    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[i].length; j++) {
                System.out.print(array2d[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        if((int)Math.sqrt(array1d.length)*(int)Math.sqrt(array1d.length) == array1d.length){
            return true;
        }
        return false;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        for(int i = 0; i<array2d.length; i++){
            if(array2d.length != array2d[i].length){
                return false;
            }
        }
        return true;
    }


}
