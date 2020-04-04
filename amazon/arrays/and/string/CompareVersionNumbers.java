package arrays.and.string;

public class CompareVersionNumbers {

	public static void main(String[] args) {

		System.out.println(compareVersion("0.1", "1.1"));
		System.out.println(compareVersion("1.0.1", "1"));
		System.out.println(compareVersion("7.5.2.4", "7.5.3"));
		System.out.println(compareVersion("1.01", "1.001"));
		System.out.println(compareVersion("1.0", "1.0.0"));
	}

	public static int compareVersion(String version1, String version2) {

		int[] ver1 = new int[4];
		int[] ver2 = new int[4];
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		for (int i = 0; i < 4; i++) {

			if (i < v1.length) {
				ver1[i] = Integer.parseInt(v1[i]);
			} else {
				ver1[i] = 0;
			}

			if (i < v2.length) {
				ver2[i] = Integer.parseInt(v2[i]);
			} else {
				ver2[i] = 0;
			}
		}

		// compare and check
		for (int i = 0; i < 4; i++) {
			if (ver1[i] < ver2[i])
				return -1;
			else if (ver1[i] > ver2[i])
				return 1;
		}

		return 0;
	}

}
