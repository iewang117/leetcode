import java.util.Iterator;
import java.util.LinkedList;

public class designHashmap {
    private class Pair{
        private int key;
        private int value;

        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }

        public int getKey(){
            return key;
        }

        public int getValue(){
            return value;
        }

        public void setValue(int value){
            this.value = value;
        }
    }

    private static final int BASE = 769;
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public designHashmap() {
        data = new LinkedList[BASE];
        for(int i = 0; i < BASE; i++){
            data[i] = new LinkedList<Pair>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair> iter = data[h].iterator();
        while(iter.hasNext()){
            Pair pair = iter.next();
            //覆盖value
            if(pair.getKey() == key){
                pair.setValue(value);
                return;
            }
        }
        data[h].add(new Pair(key,value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> iter = data[h].iterator();
        while(iter.hasNext()){
            Pair pair = iter.next();
            if(pair.getKey() == key){
                return pair.getValue();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> iter = data[h].iterator();
        while(iter.hasNext()){
            Pair pair = iter.next();
            if(pair.getKey() == key){
                data[h].remove(pair);
                return;
            }
        }
    }

    public static int hash(int key){
        return key % BASE;
    }
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}

