package algorithm;

public class PowerOfFour {
	public boolean isPowerOfFour(int num) {
		boolean flag = false;
		if (num == 1) {
			return true;
		}
		if (num % 4 != 0) {
			return false;
		}

		while (num != 0) {
			if ((num % 4) > 0 && num != 1) {
				return false;
			}
			if (num == 1) {
				flag = true;
			}
			num = num >> 2;

		}
		return flag;

	}
}
