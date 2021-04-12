import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largetstNumber(int[] nums){
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for(int i = 0; i < n; i++){
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, new MyComparator());

        //应对"00"之类的输入
        if (numsArr[0] == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for(int num : numsArr){
            res.append(num);
        }

        return res.toString();
    }

    public static class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer x, Integer y){
            //定义逐位比较规则
            long sx = 10, sy = 10;
            while(sx <= x){
                sx*=10;
            }
            while(sy <= y){
                sy*=10;
            }
            //sx * y + x就是x接在y后面
            //sy * x + y就是y接在x后面
            return (int) (-sy * x - y + sx * y + x);
        }
    }
}
