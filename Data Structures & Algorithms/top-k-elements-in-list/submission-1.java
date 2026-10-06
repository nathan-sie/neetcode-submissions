class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<Integer,Integer>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num,0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for(int num: count.keySet()){
            int freq = count.get(num);

            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        int[] result = new int[k];
        int index = 0;
        for(int freq = nums.length; freq > 0; freq--){
            if(buckets[freq] == null){
                continue;
            }

            for(int num: buckets[freq]){
                result[index] = num;
                index++;

                if(index == k){
                    return result;
                }
            }
        }
        return result;

    }
}
