package com.projecteuler;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class P26 {
	public static void main(String[] args) {
		int maxLength = 6;
		int d = 7;
		
		int last = -1;
		long start = System.currentTimeMillis();
		for (; d < 1000; d++) {
			int a = 10;
			List<Integer> records = Lists.newArrayList();
			List<Integer> results = new ArrayList<Integer>();
			while (true) {
				records.add(a);
				while (a < d) {
					a *= 10;
					results.add(0);
					if (a < d) {
						records.add(a);
					}
				}

				int remain = a % d;
				// 能除尽
				if (remain == 0) {
					break;
				}

				int divide = a / d;
				results.add(divide);

				if (records.size() > 10000) {
					System.out.println("##############>10000未能除尽，认为是无理数");
					break;
				}
				a = remain * 10;
				int pos = records.indexOf(a);
				if (pos >= 0) {
					// 找到循环点
					if (maxLength < (records.size() - pos)) {
						maxLength = records.size() - pos;
						last = d;
					}
					break;
				}
			}
		}
		System.out.println(last);
		System.out.println(System.currentTimeMillis() - start);
	}

}
