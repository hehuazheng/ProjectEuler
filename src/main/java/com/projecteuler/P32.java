package com.projecteuler;

import java.util.HashSet;
import java.util.Set;

public class P32 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 1; i < 100; i++) {
			if (isAcceptNum(i)) {
				for (int j = i + 1; j < 10000; j++) {
					if (isAcceptNum(j)) {
						int mul = i * j;
						if (isAcceptNum(mul) && checkCondition(i, j, mul)) {
							System.out.println("i: " + i + " j: " + j + " m: "
									+ mul);
							set.add(mul);
						}
					}
				}
			}
		}

		int sum = 0;
		for (int s : set) {
			sum += s;
		}
		System.out.println(sum);
		System.out.println("time: " + (System.currentTimeMillis() - start));
	}

	static boolean checkCondition(int a, int b, int c) {
		boolean[] flag = new boolean[10];
		while (a > 0) {
			int remain = a % 10;
			if (remain == 0 || flag[remain]) {
				return false;
			}
			flag[remain] = true;
			a /= 10;
		}
		while (b > 0) {
			int remain = b % 10;
			if (remain == 0 || flag[remain]) {
				return false;
			}
			flag[remain] = true;
			b /= 10;
		}
		while (c > 0) {
			int remain = c % 10;
			if (remain == 0 || flag[remain]) {
				return false;
			}
			flag[remain] = true;
			c /= 10;
		}
		for (int i = 1; i < 10; i++) {
			if (!flag[i]) {
				return false;
			}
		}
		return true;
	}

	static boolean isAcceptNum(int num) {
		boolean[] flag = new boolean[10];
		while (num > 0) {
			int remain = num % 10;
			if (remain == 0 || flag[remain]) {
				return false;
			}
			flag[remain] = true;
			num /= 10;
		}
		return true;
	}

	static int retrieveDigits(int num) {
		int flag = 0;
		while (num > 0) {
			int remain = num % 10;
			int pos = 1 << remain;
			if ((flag & pos) == pos) {
				return 0;
			}
			flag = (flag ^ pos);
			num /= 10;
		}
		return flag;
	}
}
