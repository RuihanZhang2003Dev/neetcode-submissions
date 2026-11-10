class Solution {
    public String simplifyPath(String path) {
        // idea: so use an array to construct the path, .. means pop the top to go back to parent, and contruct
        // the current command with string builder, anything else is a path

        List<String> files = new ArrayList<>();

        int len = path.length();
        int index = 0;
        while (index < len) {
            StringBuilder curCommand = new StringBuilder();
            while (index < len && path.charAt(index) == '/') index++;    // ignore following /s
            while (index < len && path.charAt(index) != '/' ) {
                curCommand.append(path.charAt(index)); // find the current command
                index++;
            }
            String com = curCommand.toString();
            if (com.length() == 0) break;
            if (com.equals(".")) continue;
            else if (com.equals("..")) {
                if (!files.isEmpty()) files.removeLast();      
            }
            else files.add(com);
        }
        if (files.isEmpty()) return "/";
        // build the path
        StringBuilder finalPath = new StringBuilder();
        for (String s: files){
            finalPath.append("/");
            finalPath.append(s);
        }
        return finalPath.toString();
    }
}