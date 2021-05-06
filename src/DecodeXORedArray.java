public class DecodeXORedArray {
    public int[] decodeXORedArray(int[] encoded, int first) {
        //异或运算满足交换律，推得arr[i] = arr[i-1] XOR encoded[i-1]
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i-1] ^ encoded[i-1];
        }
        return arr;
    }
}
