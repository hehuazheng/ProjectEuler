package com.projecteuler;

public class P15 {
	public static void main(String[] args) {
		int grid = 21;
		long[][] f = new long[grid][grid];
		for (int i = 0; i < grid; i++) {
			f[i][0] = f[0][i] = 1;
		}
		for (int i = 1; i < grid; i++) {
			for (int j = 1; j < grid; j++) {
				f[i][j] = f[i - 1][j] + f[i][j - 1];
			}
		}
		System.out.println(f[grid - 1][grid - 1]);
	}
}
