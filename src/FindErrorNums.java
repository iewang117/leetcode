import java.util.HashMap;
import java.util.Map;

public class FindErrorNums {
    public int[] findErrorNums(int[] nums){
        int[] errorNums = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(i, 0);
            if(count == 2){
                errorNums[0] = i;
            }else{
                errorNums[1] = i;
            }
        }
        return errorNums;
    }
}
