class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        String t = sb.toString();
        int start = 0;
        int end = t.length() - 1;
        while(start < end){
            if(t.charAt(start) != t.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
