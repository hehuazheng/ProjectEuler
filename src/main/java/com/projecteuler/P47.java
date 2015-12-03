package com.projecteuler;

import java.util.List;

import com.google.common.collect.Lists;
import com.study.common.util.NumberUtils;

public class P47 {

	static List<Integer> primeList = NumberUtils.generatePrimeList(10000);

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		List<Integer> primeCntList = Lists.newArrayList();
		for (int i = 1001; i < 1004; i++) {
			primeCntList.add(diffPrimeCountEqualTo4(i));

		}
		for (int i = 1004; i < 1000000; i++) {
			primeCntList.add(diffPrimeCountEqualTo4(i));
			int sz = primeCntList.size();
			if (primeCntList.get(sz - 1) == 4 && primeCntList.get(sz - 2) == 4
					&& primeCntList.get(sz - 3) == 4
					&& primeCntList.get(sz - 4) == 4) {
				System.out.println(i + 1001);
				break;
			}
		}
		System.out.println("time: " + (System.currentTimeMillis() - start));
	}

	static int diffPrimeCountEqualTo4(int num) throws Exception {
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
		return cnt;
	}

}
