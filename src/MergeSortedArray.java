public class MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1, p2 = n - 1;
            int tail = m + n - 1;
            int cur = 0;
            while(p1 >= 0 || p2 >= 0){
                if(p1 < 0){
                    cur = nums2[p2--];
                }else if(p2 < 0){
                    cur = nums1[p1--];
                }else if(nums1[p1] > nums2[p2]){
                    cur = nums1[p1--];
                }else{
                    cur = nums2[p2--];
                }
                nums1[tail--] = cur;
            }
        }
    }
}
