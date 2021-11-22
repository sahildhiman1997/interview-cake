public class StockPrice {
    public static void main(String[] args) {
        int[] x = {9,7,4,1};
        System.out.println(getMaxProfit(x));

    }

    public static int getMaxProfit(int[] stockPrices)  {
        // calculate the max profit
        int buy = stockPrices[0];
        int profit = stockPrices[1]-buy;
        for (int i = 1; i < stockPrices.length; i++) {
            if(stockPrices[i]<buy){
                buy=stockPrices[i];
            }
            else {
                if((stockPrices[i]-buy) > profit){
                    profit = stockPrices[i]-buy;
                }
            }
        }
        return profit;
    }
}
