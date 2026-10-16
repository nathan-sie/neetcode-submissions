class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        int l = 0;
        int maxCount = 0;
        for(int r = 0; r < s.length(); r++){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0) + 1);
  
            maxCount = Math.max(maxCount,map.get(s.charAt(r)));

            while((r - l + 1) - maxCount > k){
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
