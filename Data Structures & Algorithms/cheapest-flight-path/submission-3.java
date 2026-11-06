class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        /*
        idea: use bellman ford, we are allowed for k+1 iterations, set initial prices. at each step, iterate 
        through the whole flights to look for flights that we can depart from (flights with source where we 
        have a price to get there (that means a source where we can get to in k+1 steps))
        */

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;    // the price to get to the source is 0 

        for (int i = 0; i<= k; i++) {
            // create a copy so that we can modify it in this iteration without modifying the initial array
            int[] tmpPrices = Arrays.copyOf(prices, n);

            for (int[] flight: flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                
                if (prices[from] == Integer.MAX_VALUE) continue;
                
                // here you can modify tmpPrices as many times as you want to get the minimum prices to get from
                // source to destination
                if (prices[from] + price < tmpPrices[to]) tmpPrices[to] = prices[from] + price;
            }
            prices = tmpPrices;
        }
        if (prices[dst] == Integer.MAX_VALUE) return -1;    // if unreachable
        return prices[dst];

    }
}
