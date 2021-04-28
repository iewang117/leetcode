public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        //比较典型的是用sqrt和数学解法，但是双指针也可以
        long left = 0;
        long right = (long) Math.sqrt(c);
        while(left <= right){
            long sum = left * left + right * right;
            if(sum == c){
                return true;
            }else if(sum > c){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }
}
