import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> count = new HashMap<Integer, Integer>();
            for (int y : answers) {
                //HashMap统计
                count.put(y, count.getOrDefault(y, 0) + 1);
            }
            int ans = 0;
            //对Map进行遍历
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                int y = entry.getKey(), x = entry.getValue();
                //有(x + y) / (y + 1)种颜色,是x / (y + 1)向上取整
                //每种最少(y + 1)只
                ans += (x + y) / (y + 1) * (y + 1);
            }
            return ans;
        }
    }
}
