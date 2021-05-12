/**
 * 1310. 子数组异或查询
 * 通过缓存结果来减少运算，计算前缀异或数组
 */
public class XORQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xors = new int[n+1];
        for (int i = 0; i < n; i++) {
            xors[i+1] = xors[i] ^ arr[i];
        }
        int m = queries.length;
        int ans[] = new int[m];
        //本质上还是利用了一样的东西异或等于0，与0异或为本身
        for (int i = 0; i < m; i++) {
            ans[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }
        return ans;
    }
}
