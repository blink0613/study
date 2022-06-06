package WeekOne.ClassOne;

public class LeetCode88 {
    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *

     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int position1 = m - 1;
        int position2 = n - 1;
        int overallPosition = m + n - 1;
        int cur;
        while(position1 >= 0 || position2 >= 0){
            if(position1 == -1){
                cur = nums2[position2--];
            }else if(position2 == -1){
                cur = nums1[position1--];
            }else if(nums1[position1] >= nums2[position2]){
                cur = nums1[position1--];
            }else{
                cur = nums2[position2--];
            }
            nums1[overallPosition--] = cur;
        }
    }
}

