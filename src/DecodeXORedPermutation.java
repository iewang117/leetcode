public class DecodeXORedPermutation {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        //需要求出perm[0]
        //该数组里的所有数确定，容易求所有数的异或和
        //encoded的奇数和与所有数的异或和之间相差一个perm[0]
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }
        int odd = 0;
        for (int i = 1; i < n - 1; i += 2) {
            odd ^= encoded[i];
        }
        int[] perm = new int[n];
        perm[0] = total ^ odd;
        for(int i = 0; i < n - 1; i++){
            perm[i+1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
}
