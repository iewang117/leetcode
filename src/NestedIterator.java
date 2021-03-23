import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> val;
    private Iterator<Integer> cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        val = new ArrayList<Integer>();
        search(nestedList);
        cur = val.iterator();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    private void search(List<NestedInteger> nestedList){
        for(NestedInteger element : nestedList){
            if(element.isInteger()){
                val.add(element.getInteger());
            } else{
                search(element.getList());
            }
        }
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
