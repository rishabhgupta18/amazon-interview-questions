package dynamicprogramming;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	public static int maxProfit(int[] prices) {

		if (prices.length == 0)
			return 0;

		int maxRight = prices.length - 1;
		int maxProfit = 0;

		for (int i = maxRight - 1; i >= 0; i--) {

			if (prices[maxRight] - prices[i] > 0) {

				if (prices[maxRight] - prices[i] > maxProfit) {
					maxProfit = prices[maxRight] - prices[i];
				}

			} else {
				maxRight = i;
			}

		}
		return maxProfit;
	}
}
