class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // idea: use a queue, when it is positive, add to queue, when it is negative, pop queue until reaching
        // an astroid larger than current one. if there is no more astroids to pop and the current asteroid 
        // still exists, push it into queue as it will never be popped again
        Stack<Integer> rocks= new Stack();
        for (int n: asteroids) {
            if (n > 0) rocks.push(n);
            if (n < 0) {
                boolean broken = false;
                while (!rocks.isEmpty() && rocks.peek() > 0) {
                    int cur = rocks.peek();
                    if (Math.abs(cur) < Math.abs(n)) rocks.pop();
                    else if (Math.abs(cur) == Math.abs(n)) {
                        rocks.pop();
                        broken = true;
                        break;
                    }
                    else {
                        broken = true;
                        break;
                    }
                }
                if (!broken) rocks.push(n);
            }
        }
        int[] result = new int[rocks.size()];
        // since this is a stack, we will have the last element in the remaining rocks first, so we will fill
        // the result in reverse
        for (int i = result.length -1; i >= 0; i--) result[i] = rocks.pop();
        return result;
    }
}