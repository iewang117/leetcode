public class spiralMatrix2 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int total = n * n;
            int row = 0, col = 0;
            //右，下，左，上
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIndex = 0;
            for (int i = 0; i < total; i++) {
                matrix[row][col] = i + 1;
                int nextRow = row + directions[directionIndex][0], nextCol = col + directions[directionIndex][1];
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != 0) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row = row + directions[directionIndex][0];
                col = col + directions[directionIndex][1];
            }
            return matrix;
        }
    }
}
