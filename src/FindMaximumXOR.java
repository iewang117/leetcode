import java.util.HashSet;
import java.util.Set;

public class FindMaximumXOR {
    public int findMaximumXOR(int[] nums) {
        //为了满足时间复杂度要求，要逐位确定
        int x = 0;
        for (int k = 30; k >= 0 ; k--) {
            Set<Integer> set = new HashSet<Integer>();
            for(int num : nums){
                set.add(num >> k);
            }

            //下一位为1的数，逐位试探
            int xNext = x * 2 + 1;
            boolean found = false;

            for(int num : nums){
                if(set.contains(xNext ^ (num >> k))){
                    found = true;
                    break;
                }
            }

            if(found){
                x = xNext;
            }else{
                //找不到则这一位为0
                x = xNext - 1;
            }
        }
        return x;
    }
}
