package com.study.common.util;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class NumberUtils {
	public static List<Integer> generatePrimeList(int n) {
		Preconditions.checkArgument(n > 1);
		List<Integer> primeList = Lists.newArrayList(2);
		for (int i = 3; i < n; i++) {
			boolean flag = false;
			for (int prime : primeList) {
				if (i % prime == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				primeList.add(i);
			}
		}
		return primeList;
	}

	/**
	 * 质因数分解
	 */
	public static Map<Integer, Integer> decompositionPrimeFactors(int n) {
		Preconditions.checkArgument(n > 1, "n should be bigger than 1");
		Map<Integer, Integer> map = Maps.newHashMap();
		List<Integer> primeList = generatePrimeList(n + 1);
		for (int prime : primeList) {
			if (n < prime) {
				break;
			}

			if (n % prime == 0) {
				int cnt = 0;
				while (n % prime == 0) {
					n /= prime;
					cnt++;
				}
				map.put(prime, cnt);
			}
		}
		return map;
	}
}
