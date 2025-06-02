
/*
 * LC.283. 移动零
 * Level：easy
 * Tag：数组、双指针
 */


 class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0){
                swap(nums, left, right);
                left ++;
            }
            right ++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}