

import java.util.List;

import com.google.common.collect.Lists;

public class P27 {

	public static void main(String[] args) {
		// 生成素数
		long start = System.currentTimeMillis();
		List<Integer> primeList = Lists.newArrayList(2, 3, 5, 7, 11, 13);
		// 生成素数表
		for (int i = 14; i < 1000; i++) {
			System.out.println(i);
			boolean flag = false;
			for (int j : primeList) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				primeList.add(i);
			}
		}

		int max = 0;
		int lastA = -1;
		int lastB = -1;

		for (int b : primeList) {
			for (int a = 0; a < 1000; a++) {
				//a, b
				int consecutiveCount = 0;
				for (int i = 1;; i++) {
					int val = fun(i, a, b);
					if (!isPrime(val)) {
						break;
					}
					consecutiveCount++;
				}
				if (consecutiveCount > max) {
					max = consecutiveCount;
					lastA = a;
					lastB = b;
				}

				// a, -b
				consecutiveCount = 0;
				for (int i = 1;; i++) {
					int val = fun(i, a, -b);
					if (!isPrime(val)) {
						break;
					}
					consecutiveCount++;
				}
				if (consecutiveCount > max) {
					max = consecutiveCount;
					lastA = a;
					lastB = -b;
				}
				// -a, b
				consecutiveCount = 0;
				for (int i = 1;; i++) {
					int val = fun(i, -a, b);
					if (!isPrime(val)) {
						break;
					}
					consecutiveCount++;
				}
				if (consecutiveCount > max) {
					max = consecutiveCount;
					lastA = -a;
					lastB = b;
				}
				// -a, -b
				consecutiveCount = 0;
				for (int i = 1;; i++) {
					int val = fun(i, -a, -b);
					if (!isPrime(val)) {
						break;
					}
					consecutiveCount++;
				}
				if (consecutiveCount > max) {
					max = consecutiveCount;
					lastA = -a;
					lastB = -b;
				}
			}
		}
		System.out.println(max + " " + lastA + " " + lastB);
		System.out.println(System.currentTimeMillis() - start);
	}

	static int fun(int n, int a, int b) {
		return n * n + a * n + b;
	}

	static boolean isPrime(int n) {
		n = Math.abs(n);
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
