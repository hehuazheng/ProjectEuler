package com.projecteuler;

import java.util.List;

import com.google.common.collect.Lists;

public class P24 {

	public static void main(String[] args) {
		int[] p = new int[11];
		p[0] = 1;
		for (int i = 1; i < 11; i++) {
			p[i] = p[i - 1] * i;
		}

		List<Integer> list = Lists.newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		int size = list.size();

		int pos = 999999;
		List<Integer> result = Lists.newArrayList();
		for (int i = size - 1; i >= 0; i--) {
			if (pos == 0) {
				break;
			}
			if (p[i] > pos) {
				result.add(list.get(0));
				list.remove((int) 0);
				continue;
			}

			int divide = pos / p[i];
			result.add(list.get(divide));
			list.remove((int) divide);
			pos -= divide * p[i];
		}

		if (pos == 0) {
			result.addAll(list);
		}
		System.out.println(result);
	}

}
