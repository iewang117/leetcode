import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int num = entry.getKey(), numFreq = entry.getValue();
            if(numFreq == 1){
                ans = num;
                break;
            }
        }
        return ans;
    }
}
