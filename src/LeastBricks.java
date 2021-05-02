import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        //统计各个位置墙缝出现次数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(List<Integer> width : wall){
            int n = width.size();
            int sum = 0;
            //最右边不算
            for (int i = 0; i < n - 1; i++) {
                sum += width.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCount = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxCount = Math.max(maxCount, entry.getValue());
        }

        return wall.size() - maxCount;
    }
}
