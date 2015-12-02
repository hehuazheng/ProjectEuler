package com.projecteuler;

import java.util.HashSet;
import java.util.Set;

public class P14 {

	public static void main(String[] args) {
		int max = 1000000;
		int maxChainLength = 0;
		int currentMax = 0;
		for (int i = 2; i < max; i++) {
			int currentChainLength = chainLength(i);
			if (currentChainLength > maxChainLength) {
				maxChainLength = currentChainLength;
				currentMax = i;
			}
		}

		System.out.println(currentMax + " " + maxChainLength);
	}

	//有可能超过int的最大值，需要强行转long
	static int chainLength(int tmp) {
		Set<Long> set = new HashSet<Long>();
		long n = tmp;
		while (n != 1) {
			set.add(n);
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = 3 * n + 1;
			}
			if(set.contains(n)) {
				break;
			}
		}
		return set.size();
	}

}
