public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = matrix[mid / n][mid % n];
            if (num < target) {
                low = mid + 1;
            } else if (num > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
