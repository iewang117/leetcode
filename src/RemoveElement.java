public class RemoveElement {
    public int removeElement(int[] nums, int val){
        int n = nums.length;
        int slow = 0;
        for(int fast = 0; fast < n; fast++){
            if(nums[fast] != val){
                //不需要考虑数组中超出新长度后面的元素
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
