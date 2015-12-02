package com.study.common.util;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

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
}
