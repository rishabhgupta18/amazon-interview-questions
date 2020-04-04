package arrays.and.string;

public class StringToIntegerATOI {
	
	public static void main(String[] args) {
		System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("    -42"));
		System.out.println(myAtoi("words and 987"));
		System.out.println(myAtoi("-91283472332"));	
		
	}

	public static int myAtoi(String str) {

		int len = str.length();
		if (len == 0)
			return 0;
		char[] ch = str.toCharArray();
		int start = 0;

		// ignore whitespace
		boolean noMoreWhiteSpace = false;
		while (start < len && !noMoreWhiteSpace) {
			if (ch[start] == ' ') {
				start++;
			} else {
				noMoreWhiteSpace = true;
			}
		}

		if (start >= len)
			return 0;

		int charToInt = 48;

		// check valid conversion
		int val = ch[start] - charToInt;
		// Check for + or - ve
		// if not than first char is not an integer
		if (val == -3 || val == -5) {
			if (start + 1 < len) {
				val = ch[start + 1] - charToInt;
			} else {
				return 0;
			}
		}
		// first char is not an integer
		if (val < 0 || val > 9) {
			return 0;
		}

		//get start and value if +ve or -ve
		boolean isNegative = (ch[start] - charToInt) == -3 ? true : false;
		start = (isNegative || (ch[start] - charToInt) == -5) ? start + 1 : start;

		do {

			int k = ch[start] - charToInt;
			if (k == 0) {
				start++;
			} else {
				break;
			}

		} while (start < len);

		// calculate the end
		// If there is any word or whitespace after the digit
		int end = start;
		for (int i = start; i < len; i++) {
			val = (ch[i] - charToInt);
			if (val >= 0 && val <= 9) {
				end++;
			} else {
				break;
			}

		}

		val = 0;
		int mult = 1;
		boolean isLimitExceeded = false;

		if (end - start > 10) {
			isLimitExceeded = true;
		} else {
			for (int i = end - 1; i >= start; i--) {

				int key = (ch[i] - charToInt) == 0 ? 1 : (ch[i] - charToInt);
				// if a number is greater than the Integer range
				if (key * (mult / 10) > (Integer.MAX_VALUE - val) / 10) {
					// verify negative case
					if (isNegative) {
						if (key * (mult / 10) * -1 >= (Integer.MIN_VALUE + val) / 10) {
							val += (ch[i] - charToInt) * mult;
						} else {
							isLimitExceeded = true;
						}
					} else {
						isLimitExceeded = true;
					}
					break;
				} else {
					//Store the value 
					val += (ch[i] - charToInt) * mult;
					mult *= 10;
				}
			}
		}

		if (isLimitExceeded) {
			val = isNegative ? Integer.MAX_VALUE + 1 : Integer.MAX_VALUE;
		}
		return isNegative ? val * -1 : val;
	}

}
