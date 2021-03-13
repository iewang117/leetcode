import java.util.Iterator;
import java.util.LinkedList;

public class designHashset {
    //用取余作为哈希函数，为了尽量避免哈希冲突，选一个质数769
    private static final int BASE = 769;
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public designHashset() {
        data = new LinkedList[BASE];
        for(int i = 0; i < BASE; i++){
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while(iterator.hasNext()){
            if(iterator.next() == key){
                return;
            }
        }
        data[h].add(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while(iterator.hasNext()){
            Integer element = iterator.next();
            if(element == key){
                data[h].remove(element);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while(iterator.hasNext()){
            if(iterator.next() == key){
                return true;
            }
        }
        return false;
    }

    private static int hash(int key){
        return key % BASE;
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}