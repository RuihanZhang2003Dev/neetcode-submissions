class Solution {
    /**
     * @param {number[]} prices
     * @return {number}
     */
    maxProfit(prices: number[]): number {
        const map: Map<[number,number], number> = new Map();
        let maxProfit: number = 0;
        for (let i = 0; i< prices.length; i++){
            for (let j = i+1; j< prices.length; j++){
                let tmp = prices[j] - prices[i];
                if (!(map.has([prices[i], prices[j]]))){
                    map.set([prices[i], prices[j]], tmp);
                    if (prices[j] > prices[i]){
                        if (tmp > maxProfit){
                            maxProfit = tmp;
                        }
                    }
                }

            }
        }
        return maxProfit;
    }
}
