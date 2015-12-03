package com.projecteuler;

import java.util.List;

import com.google.common.collect.Lists;
import com.study.common.util.NumberUtils;

public class P47 {

	static List<Integer> primeList = NumberUtils.generatePrimeList(10000);

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int i = 1001; i < 10000; i++) {
			if (diffPrimeCountEqualTo4(i) && diffPrimeCountEqualTo4(i + 1)
					&& diffPrimeCountEqualTo4(i + 2)
					&& diffPrimeCountEqualTo4(i + 3)) {
				System.out.println(i);
				break;
			}
		}
		System.out.println("time: " + (System.currentTimeMillis() - start));
	}

	static boolean diffPrimeCountEqualTo4(int num) {
		int n = num;
		int cnt = 0;

		List<Integer> primes = Lists.newArrayList();
		for (int i = 0; i < primeList.size(); i++) {
			int prime = primeList.get(i);
			if (n < prime) {
				break;
			}
			if (n % prime == 0) {
				cnt++;
				primes.add(prime);
				if (cnt > 4) {
					break;
				}
				while (n % prime == 0) {
					n /= prime;
				}
			}
		}
		System.out.println("num: " + num + " cnt: " + cnt + " " + primes);
		return cnt == 4;
	}

}
