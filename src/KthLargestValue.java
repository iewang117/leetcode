import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KthLargestValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        //前缀和
        int[][] xorSum = new int[m + 1][n + 1];
        //排序数组
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //被重复异或的元素互相抵消了
                xorSum[i][j] = xorSum[i - 1][j - 1] ^ xorSum[i - 1][j] ^ xorSum[i][j - 1] ^ matrix[i-1][j-1];
                arr.add(xorSum[i][j]);
            }
        }

        //从大到小排列
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        return arr.get(k-1);
    }
}
