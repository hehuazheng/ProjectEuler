package com.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class P16 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		int times = 1000;
		for (int i = 1; i < times; i++) {
			int remain = 0;
			for (int j = 0; j < list.size(); j++) {
				int val = list.get(j);
				val *= 2;
				val += remain;
				remain = val / 10;
				list.set(j, val % 10);
			}
			while (remain > 0) {
				list.add(remain % 10);
				remain /= 10;
			}
		}
		
		int sum = 0;
		for(int i : list) {
			sum += i;
		}
		System.out.println(sum);
	}

}
