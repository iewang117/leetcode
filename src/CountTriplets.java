public class CountTriplets {
    public int countTriplets(int[] arr) {
        //转化成异或前缀和之间的计算
        int n = arr.length;
        int[] s = new int[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if(s[i] == s[k + 1]){
                    ans += k - i;
                }
            }
        }
        return ans;
    }
}
