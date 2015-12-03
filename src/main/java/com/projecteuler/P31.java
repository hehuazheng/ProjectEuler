package com.projecteuler;

import java.io.FileNotFoundException;

public class P31 {
	static final int MAX = 201;
	static int[] coinArr = new int[] { 200, 100, 50, 20, 10, 5, 2, 1 };

	public static void main(String[] args) throws FileNotFoundException {
		long start = System.currentTimeMillis();
		System.out.println(perm(0, 200));
		System.out.println("time: " + (System.currentTimeMillis() - start));
	}

	static int perm(int s, int exp) {
		if (s == coinArr.length - 1) {
			return 1;
		}

		if (exp == 0) {
			return 1;
		}

		if (exp < 0) {
			return 0;
		}
		int sum = 0;
		int times = 0;
		while (true) {
			int mul = times * coinArr[s];
			if (mul > exp) {
				break;
			} else if (mul == exp) {
				sum += 1;
				break;
			} else {
				sum += perm(s + 1, exp - mul);
				times++;
			}
		}
		return sum;
	}

}
