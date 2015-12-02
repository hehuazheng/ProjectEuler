package com.projecteuler;

import java.util.List;

import com.google.common.collect.Lists;

public class P25 {

	public static void main(String[] args) {
		List<Integer> listA = Lists.newArrayList(1);
		List<Integer> listB = Lists.newArrayList(1);
		int cnt = 2;
		int end = 1000;
		while (true) {
			// 变等长
			makeLengthEqual(listA, listB);
			int remain = 0;
			for (int i = 0; i < listA.size(); i++) {
				int add = listA.get(i) + listB.get(i) + remain;
				listA.set(i, add % 10);
				remain = add / 10;
			}

			while (remain > 0) {
				listA.add(remain % 10);
				remain /= 10;
			}

			cnt++;
			if (listA.size() >= end) {
				break;
			}

			// 变等长
			makeLengthEqual(listA, listB);

			for (int i = 0; i < listA.size(); i++) {
				int add = listA.get(i) + listB.get(i) + remain;
				listB.set(i, add % 10);
				remain = add / 10;
			}

			while (remain > 0) {
				listB.add(remain % 10);
				remain /= 10;
			}

			cnt++;
			if (listB.size() >= end) {
				break;
			}

		}
		System.out.println(cnt);
	}

	static void makeLengthEqual(List<Integer> listA, List<Integer> listB) {
		// 变等长
		int max = listA.size();
		if (max < listB.size()) {
			max = listB.size();
			for (int i = 0; i < max - listA.size(); i++) {
				listA.add(0);
			}
		} else {
			for (int i = 0; i < max - listB.size(); i++) {
				listB.add(0);
			}
		}
	}

}
