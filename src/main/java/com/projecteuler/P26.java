package com.projecteuler;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class P26 {

	static class Pair {
		int f;
		int s;

		public Pair(int f, int s) {
			this.f = f;
			this.s = s;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Pair) {
				Pair other = (Pair) obj;
				return other.f == this.f && other.s == this.s;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return f + s;
		}
	}

	public static void main(String[] args) {
		int maxLength = 6;
		int d = 9;
		for (; d < 1000; d++) {
			int a = 1;
			List<Integer> records = Lists.newArrayList(1);
			List<Integer> results = new ArrayList<Integer>();
			while (true) {
				while (a < d) {
					a *= 10;
					results.add(0);
				}

				int remain = a % d;
				// 能除尽
				if (remain == 0) {
					break;
				}

				int divide = a / d;
				results.add(divide);
				
				if(records.size() > 10000) {
					System.out.println("##############>10000未能除尽，认为是无理数");
					break;
				}
				int pos = records.indexOf(remain);
				if (pos >= 0) {
					// 找到循环点
					if (maxLength < (records.size() - pos)) {
						maxLength = records.size() - pos;
						System.out.println("找到D: " + d);
					}
					break;
				}
				a = remain;
				// records.add(new Pair(a, d));
			}
		}
	}

}
