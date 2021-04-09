public class FindMinInRotatedSortedArray2 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;
        int mid;
        while(low < high){
            mid = low + (high-low)/2;
            //在右半部分
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else if(nums[mid] < nums[high]){
                //在左半部分
                high = mid;
            }else{
                //有相同值，强制推进
                high--;
            }
        }
        return nums[low];
    }
}
