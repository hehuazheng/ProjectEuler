package com.projecteuler;

public class P12 {

	public static void main(String[] args) {
		for (int i = 7;; i++) {
			long triangleNumber = i * (i + 1) / 2;
			int cnt = calcFactorCount(triangleNumber);
			if (cnt > 500) {
				System.out.println(triangleNumber + " " + i + " " + cnt);
				break;
			}
		}
	}

	private static int calcFactorCount(long n) {
		int cnt = 2; // 1和其自身计为2
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				if (i * i == n) {
					cnt++;
				} else {
					cnt += 2;
				}
			}
		}
		return cnt;
	}

}
