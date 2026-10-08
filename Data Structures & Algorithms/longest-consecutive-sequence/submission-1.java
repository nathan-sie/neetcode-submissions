class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            if(!set.contains(num - 1)){
                int length = 1;
                int current = num;
                while(set.contains(current + 1)){
                    current += 1;
                    length += 1;
                }
                res = Math.max(res,length);
            }
        }
        return res;
    }
}
