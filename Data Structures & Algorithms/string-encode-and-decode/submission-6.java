class Solution {

    public String encode(List<String> strs) {
        String code = new String();
        for (String s: strs) {
            s += "`";
            code += s;
        }
        return code;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        String cur = "";
        for (int i = 0; i< str.length(); i++) {
            if (str.charAt(i) == '`') {
                result.add(cur);
                cur = "";
            }
            else cur += str.charAt(i);
        }
        return result;
    }   
}
