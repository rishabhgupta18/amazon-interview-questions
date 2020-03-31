package arrays.and.string;


public class IntegertoRoman {
	
	public static void main(String[] args) {
		System.out.println(intToRoman(3));
		System.out.println(intToRoman(4));
		System.out.println(intToRoman(9));
		System.out.println(intToRoman(58));
		System.out.println(intToRoman(1994));
	}

	static final int[] values;
	static final String[] symbols;

	static {
		values = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		symbols = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	}

	/***
	 * I 1 V 5 X 10 L 50 C 100 D 500 M 1000
	 ***/
	public static String intToRoman(int num) {

		if (num == 0)
			return "0";
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < values.length && num > 0; i++) {

			if (values[i] <= num) {
				int quan = num / values[i];
				num -= values[i] * quan;
				for (int j = 0; j < quan; j++) {
					result.append(symbols[i]);
				}

			}

		}

		return result.toString();
	}
}
