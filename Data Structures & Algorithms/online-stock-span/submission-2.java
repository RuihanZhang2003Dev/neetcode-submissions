class StockSpanner {
    // idea: use 2 stacks, 1 for the current unpopped prices pop and second for days for next until the current 
    // day encounters a prices larger than today's price
    Deque<Integer> prices;
    Deque<Integer> spans;
    public StockSpanner() {
        prices = new ArrayDeque<>();
        spans = new ArrayDeque<>();
    }
    
    public int next(int price) {
        if (prices.isEmpty()) {
            prices.push(price);
            spans.push(1);
            return 1;
        }
        int count = 1;  // starts at 1 since we count the current day
        while (!prices.isEmpty() && price >= prices.peek()) {
            count += spans.pop();
            prices.pop();
        }
        prices.push(price);
        spans.push(count);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */