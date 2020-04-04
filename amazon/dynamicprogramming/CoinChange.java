package dynamicprogramming;

public class CoinChange {

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] { 1, 2, 5 }, 11));
		System.out.println(coinChange(new int[] { 2 }, 3));
		System.out.println(coinChange(new int[] { 2, 5, 10, 1 }, 27));
		// [2,5,10,1]
//		27
	}

	public static int coinChange(int[] coins, int amount) {

		if (coins.length == 0)
			return -1;
		if (amount == 0)
			return 0;

		int row = coins.length;
		int col = amount + 1;
		int[] subsolution = new int[col];
		for (int i = 1; i < col; i++) {
			subsolution[i] = Integer.MAX_VALUE - 1;
		}

		for (int i = 0; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (j >= coins[i]) {
					if ((subsolution[j] > 1 + subsolution[j - coins[i]])) {
						subsolution[j] = 1 + subsolution[j - coins[i]];
					}
				}
			}
		}
		int result = subsolution[col - 1];
		return result == Integer.MAX_VALUE - 1 ? -1 : result;
	}

}
