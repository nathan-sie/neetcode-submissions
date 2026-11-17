class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 1. 决定接着前面，还是重新开始
            current = Math.max(current + nums[i], nums[i]);
            // 2. 更新全局最大和
            res = Math.max(res, current);
        }

        return res;
    }
}
