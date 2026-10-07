class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str.length() + "#" + str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

         while (i < str.length()) {
            int j = i;

        // 1. 让 j 往后走，直到找到 '#'
            while (str.charAt(j) != '#') {
            j++;
            }
        // 2. 把下标 i 到 j 之间的文本转成整数 length
            int length = Integer.parseInt(str.substring(i, j));
        // 3. 从 j + 1 开始，取 length 个字符，加入 res
            int start = j + 1;
            int end = j + 1 + length;
        // 4. 将 i 移到刚取出的内容之后
            res.add(str.substring(start, end));
            i = end;
        }

        return res;
    }
}
