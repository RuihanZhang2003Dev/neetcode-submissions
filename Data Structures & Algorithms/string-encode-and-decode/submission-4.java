class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for (String s : strs){
            s = s+"`";
            result += s;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> code = new ArrayList<>();
        int startInd = 0;
        for (int i = 0; i< str.length(); i++) {
            if (str.charAt(i) == '`'){
                code.add(str.substring(startInd, i));
                startInd = i+1;
            }
        }
        return code;
    }
}
