import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> order = new ArrayList<Integer>();
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return order;
            }
            int rows = matrix.length, cols = matrix[0].length;
            boolean[][] visited = new boolean[rows][cols];
            int total = rows * cols;
            int row = 0, col = 0;
            int directionIndex = 0;
            //右，下，左，上
            int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
            for(int i = 0; i < total; i++){
                order.add(matrix[row][col]);
                visited[row][col] = true;
                int nextRow = row + directions[directionIndex][0], nextCol = col + directions[directionIndex][1];
                if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]){
                    directionIndex = (directionIndex + 1) % 4;
                }
                row += directions[directionIndex][0];
                col += directions[directionIndex][1];
            }
            return order;
        }
    }
}
