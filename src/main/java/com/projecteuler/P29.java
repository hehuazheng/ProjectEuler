package com.projecteuler;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;
import com.study.common.util.NumberUtils;

public class P29 {

	public static void main(String[] args) {
		List<Integer> primeList = NumberUtils.generatePrimeList(101);
		final int max = 101;
		String[][] tb = new String[max][max];
		for (int i = 2; i < max; i++) {
			List<Integer> pairList = new ArrayList<>();
			for (int j = 0; j < primeList.size(); j++) {
				int prime = primeList.get(j);
				if (prime > i) {
					break;
				}

				int cnt = 0;
				while (i % prime == 0) {
					i /= prime;
					cnt++;
				}

				if (cnt > 0) {
					pairList.add(j);
				}
			}

			tb[i][1] = reverseString("" + i);
			// 计算素因数分解
			if (pairList.isEmpty()) {
				for (int j = 2; j < max; j++) {
					tb[i][j] = combine(tb[i][j - 1], i);
				}
			} else {
				for (int j = 2; j < max; j++) {
					int remain = j;
					boolean first = false;
					for ( Integer p : pairList) {
						while(remain > 100) {
							
						}
					}
				}
			}
		}
		System.out.println(primeList);
	}

	static String combine(String a, int b) {
		if (b == 0) {
			return "";
		}

		if (b == 1) {
			return a;
		}

		List<Integer> list = reverseStringToList(a);
		int remain = 0;
		for (int i = 0; i < list.size(); i++) {
			int val = list.get(i) * b + remain;
			list.set(i, val % 10);
			remain = val / 10;
		}
		while (remain > 0) {
			list.add(remain % 10);
			remain /= 10;
		}
		return Joiner.on("").join(list);
	}

	static String combine(String a, String b) {
		String tmp = null;
		if (b.length() > 0) {
			tmp = combine(a, b.charAt(0) - '0');
		}
		for (int i = 1; i < b.length(); i++) {
			StringBuilder sb = new StringBuilder();
			int zCnt = 0;
			while (zCnt < i) {
				zCnt++;
				sb.append('0');
			}
			String tmp2 = sb.toString() + combine(a, b.charAt(i) - '0');
			tmp = sumAddReverse(tmp, tmp2);
		}
		return tmp;
	}

	static String sumAddReverse(String a, String b) {
		List<Integer> aList = stringToList(a);
		List<Integer> bList = stringToList(b);
		List<Integer> cList = new ArrayList<>();
		int remain = 0;
		int min = aList.size() < bList.size() ? aList.size() : bList.size();
		for (int i = 0; i < min; i++) {
			int val = aList.get(i) + bList.get(i) + remain;
			cList.add(val % 10);
			remain /= 10;
		}
		for (int i = min; i < aList.size(); i++) {
			int val = aList.get(i) + remain;
			cList.add(val % 10);
			remain /= 10;
		}
		for (int i = min; i < bList.size(); i++) {
			int val = bList.get(i) + remain;
			cList.add(val % 10);
			remain /= 10;
		}
		while (remain > 0) {
			cList.add(remain % 10);
			remain /= 10;
		}
		return Joiner.on("").join(cList);
	}

	static List<Integer> stringToList(String a) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length(); i++) {
			list.add(a.charAt(i) - '0');
		}
		return list;
	}

	static String reverseString(String s) {
		StringBuilder b = new StringBuilder(s);
		return b.reverse().toString();
	}

	static List<Integer> reverseStringToList(String a) {
		List<Integer> list = new ArrayList<>();

		// 反转，个位放前
		for (int i = a.length() - 1; i >= 0; i--) {
			list.add(a.charAt(i) - '0');
		}
		return list;
	}

}
