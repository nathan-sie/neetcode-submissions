class Solution {
    public int hammingWeight(int n) {
        String a = Integer.toBinaryString(n);
        int res = 0;
        for(char c:a.toCharArray()){
            if(c == '1'){
                res += 1;
            }
        }
        return res;
    }
}
