package com.projecteuler;

import java.util.List;

import com.google.common.collect.Lists;

public class P10 {

	public static void main(String[] args) {
		int max = 2000000;
		List<Integer> primeList = Lists.newArrayList(2);
		long sum = 2;
		for(int i = 3; i < max; i++) {
			boolean flag = false;
			for(int j = 0; j < primeList.size(); j++) {
				if(i % primeList.get(j) == 0) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				primeList.add(i);
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
