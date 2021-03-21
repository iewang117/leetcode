public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean[] m = new boolean[matrix.length];
        boolean[] n = new boolean[matrix[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < n.length; j++) {
                if (matrix[i][j] == 0) {
                    m[i] = n[j] = true;
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < n.length; j++) {
                if (m[i] == true || n[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
