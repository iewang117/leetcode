import java.util.*;

public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        //TreeMap不能根据value来排序，所以用不了
        List<String> arr = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            arr.add(entry.getKey());
        }
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //字符串的compareTo是lexicographically地比较字符串，即按字典序
                return wordCount.get(o2) == wordCount.get(o1) ?
                        o1.compareTo(o2) : wordCount.get(o2) - wordCount.get(o1);
            }
        });
        return arr.subList(0, k);
    }
}
