import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    //一种初始化HashMap的方法，第一个括号是匿名内部类，第二个括号是实例构造代码块
    Map <Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int val = map.get(s.charAt(i));
            //如果还没遍历到最后一位而且，前面的比后面小
            if(i < n-1 && val < map.get(s.charAt(i + 1))){
                ans -= val;
            }else {
                ans += val;
            }
        }
        return ans;
    }
}
