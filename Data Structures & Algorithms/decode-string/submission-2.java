class Solution {
    public String decodeString(String s) {
        // idea: use a stack of string builders, when encounter ], pop the top of stack of string builder and 
        // the times it needs to repeat, build it and merge with the next top string builder in the stack
        
        Deque<StringBuilder> strings = new ArrayDeque<>();
        Deque<Integer> times = new ArrayDeque<>();
        StringBuilder num = new StringBuilder();
        int bracket_opened = 0;
        for (int i = 0; i< s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) num.append(cur);

            else if (cur == '[') {
                times.push(Integer.parseInt(num.toString()));
                strings.push(new StringBuilder());
                bracket_opened++;
                num = new StringBuilder();
            }

            // when encountered with a letter, check if the bracket is opened, if so, merge to the stringBuilder
            // on top of stack
            else if (Character.isLetter(cur)) {
                if (bracket_opened > 0) {
                    StringBuilder curS = strings.pop();
                    curS.append(cur);
                    strings.push(curS);
                }
                else{
                    StringBuilder newS = new StringBuilder();
                    newS.append(cur);
                    strings.push(newS);
                }
                
            }
            
            else if (cur == ']') {
                int time = times.pop();
                StringBuilder to_add = strings.pop();
                if (!strings.isEmpty()) {
                    StringBuilder curS = strings.pop();
                    for (int j = 0; j< time; j++) {
                        curS.append(to_add);
                    }
                    strings.push(curS);
                }
                // if the current string is already at bottom, add to itself and push it back
                else {
                    StringBuilder res = new StringBuilder();
                    for (int j = 0; j< time; j++) {
                        res.append(to_add);
                    }
                    strings.push(res);
                } 
                bracket_opened--;
            }  
        }
        while (strings.size() != 1) {
            StringBuilder top = strings.pop();
            StringBuilder bot = strings.pop();
            strings.push(bot.append(top));
        }
        return strings.pop().toString();
    }
}