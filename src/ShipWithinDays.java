import java.util.Arrays;

public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        //stream方法求最大求和
        //OptionalInt的定义,如果value存在则返回getasIntValue(),但如果value不存在,则抛出Exception
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            int need = 1, cur = 0;
            for (int weight : weights) {
                //超出了，排到下一天去
                if (cur + weight > mid) {
                    need++;
                    cur = 0;
                }
                cur += weight;
            }
            //有多出的时间
            if (need <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
