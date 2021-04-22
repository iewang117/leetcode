import java.util.TreeSet;

public class MaxSumSubmatrix {
    /*
    枚举上下边界，然后求出每列之和
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        //上边界
        for(int i = 0; i < m; i++){
            //每列之和
            int[] sum = new int[n];
            //下边界
            for(int j = i; j < m; j++){
                //计算每列之和
                for (int l = 0; l < n; l++) {
                    sum[l] += matrix[j][l];
                }
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for(int v : sum){
                    s += v;
                    //ceiling返回在这个集合中大于或者等于给定元素的最小元素
                    Integer ceil = sumSet.ceiling(s - k);
                    if(ceil != null){
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }
}
