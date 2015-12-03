package com.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class P30 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int times = 5;
		int end = 7 * power(9,5);
		List<Integer> resultList = new ArrayList<Integer>();
		for(int i = 2; i < end; i++) {
			int sum = 0;
			int tmp = i;
			while(tmp > 0) {
				sum += power(tmp % 10, times);
				tmp /= 10;
			}
			if(sum == i) {
				resultList.add(i);
				System.out.println(sum);
			}
		}
		int sum = 0;
		for(int i : resultList) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println("time: " + (System.currentTimeMillis() - start));
	}

	static int power(int n, int k) {
		int mul = 1;
		for (int i = 0; i < k; i++) {
			mul *= n;
		}
		return mul;
	}

}
