//1482. 制作 m 束花所需的最少天数
public class MinBloomDays {
    //在最少天数和最多天数之间进行二分查找
    public int minBloomDays(int[] bloomDay, int m, int k) {
        //总数不够
        if((m * k) > bloomDay.length){
            return -1;
        }
        int low = Integer.MAX_VALUE, high = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length; i++) {
            //最大不大于最慢的花，最小不小于最快的花
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        //二分查找
        while(low < high){
            int days = low + (high - low) / 2;
            if(canMake(bloomDay, days, m, k)){
                high = days;
            }else{
                low = days + 1;
            }
        }
        return low;
    }

    public boolean canMake(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers= 0;
        int length = bloomDay.length;
        for (int i = 0; i < length; i++) {
            //统计能用的花
            if(bloomDay[i] <= days){
                flowers++;
                //把花做成花束
                if(flowers == k){
                    bouquets++;
                    flowers = 0;
                }
            }else{
                //不连续的花不能用，清零
                flowers = 0;
            }
        }
        return m <= bouquets;
    }
}
