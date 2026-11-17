class Solution {
    public int openLock(String[] deadends, String target) {
        /*
        idea: in order to get the minimum of a question, BFS is the best solution since we can stop
        the moment we find target and we know that will be the minimum step we took . From each 
        number, we can increase by 1 or decrease by 1, so for all 4 of them, there will be maximum 8 
        new digits, but we will not revisit the already visited ones, so we will set a hashset aside 
        to avoid this situation
        */
        Set<String> visited = new HashSet<>();
        Queue<String> toCheck = new LinkedList<>();
        for (String deadend: deadends) visited.add(deadend);
        if (visited.contains("0000")) return -1;
        toCheck.offer("0000");
        visited.add("0000");
        
        int timer = 0;
        while (!toCheck.isEmpty()) {
            int size = toCheck.size(); 
            for (int j = 0; j< size; j++) {
                String code = toCheck.poll();
                // +1 and -1 for each position
                for (int i = 0; i< code.length(); i++) {
                    int curNum = code.charAt(i) - '0';
                    int plus = (curNum +1) %10;
                    int minus = (curNum -1 +10) %10;
                    String tmpS = code.substring(0,i)+ plus + code.substring(i+1, code.length());
                    if (tmpS.equals(target)) return timer +1;
                    // if the current number is unvisited, add it to the queue and to set
                    if (!visited.contains(tmpS)) {
                        visited.add(tmpS);
                        toCheck.offer(tmpS);
                    }
                    tmpS = code.substring(0,i)+ minus + code.substring(i+1, code.length());
                    if (tmpS.equals(target)) return timer +1;
                    if (!visited.contains(tmpS)) {
                        visited.add(tmpS);
                        toCheck.offer(tmpS);
                    }
                }
            
            }
            timer++;
        }
        return -1;

    }


}