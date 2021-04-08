public class SearchRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        int mid;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[lo] == nums[mid]) {
                lo++;
                continue;
            }
            //前半部分有序
            if (nums[lo] < nums[mid]) {
                //target在前半部分
                if (nums[mid] > target && nums[lo] <= target) {
                    lo = mid - 1;
                } else {
                    //target在后半部分
                    lo = mid + 1;
                }
            } else {
                //后半部分有序
                //target在后半部分
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    //target在前半部分
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
}
