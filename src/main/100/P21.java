

import java.util.HashSet;
import java.util.Set;

public class P21 {

	public static void main(String[] args) {
		int n = 10000;
		int[] d = new int[n];
		for (int i = 2; i < n; i++) {
			int sumDivide = sumDivide(i);
			d[i] = sumDivide >= n ? 0 : sumDivide;
		}

		int sum = 0;
		for (int i = 2; i < n; i++) {
			if (i == d[d[i]] && i != d[i]) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	static int sumDivide(int n) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		for (int j = 2; j * j <= n; j++) {
			if (n % j == 0) {
				set.add(j);
				set.add(n / j);
			}
		}

		int sum = 0;
		for (int i : set) {
			sum += i;
		}
		return sum;
	}

}
