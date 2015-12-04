import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.study.common.util.NumberUtils;
import com.study.common.util.Pair;

public class P116 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int red = 2;
		int green = 3;
		int black = 4;
		int n = 50;

		List<Pair<Integer, Integer>> all = Lists.newArrayList();
		all.addAll(process(n, red));
		all.addAll(process(n, green));
		all.addAll(process(n, black));

		Collections.sort(all, new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> o1,
					Pair<Integer, Integer> o2) {
				if (o1.f == o2.f) {
					return o1.s - o2.s;
				}
				return o1.f - o2.f;
			}
		});

		System.out.println(all);
		long sum = 0;
		for (Pair<Integer, Integer> p : all) {
			sum += c(p.f, p.s);
		}
		System.out.println(sum);
		System.out.println("time: " + (System.currentTimeMillis() - start));
	}

	static long c(int n, int m) {
		if (m == 0) {
			return 1;
		}
		
		if(m == 1) {
			return n;
		}

		Map<Integer, Integer> map = Maps.newHashMap();
		for (int i = m + 1; i <= n; i++) {
			add(map, NumberUtils.decompositionPrimeFactors(i));
		}

		for (int i = 2; i <= n - m; i++) {
			sub(map, NumberUtils.decompositionPrimeFactors(i));
		}

		return multiply(map);
	}

	static long multiply(Map<Integer, Integer> map) {
		long mul = 1;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			for (int i = 0; i < value; i++) {
				mul *= key;
			}
		}
		return mul;
	}

	static void add(Map<Integer, Integer> map, Map<Integer, Integer> map2) {
		for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
			Integer key = entry.getKey();
			if (map.get(key) != null) {
				map.put(key, map.get(key) + entry.getValue());
			} else {
				map.put(key, entry.getValue());
			}
		}
	}

	static void sub(Map<Integer, Integer> map, Map<Integer, Integer> map2) {
		for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
			Integer key = entry.getKey();
			if (map.get(key) != null) {
				map.put(key, map.get(key) - entry.getValue());
			} else {// 不应该出现的状况
				throw new RuntimeException();
			}
		}
	}

	static List<Pair<Integer, Integer>> process(int n, int block) {
		int times = n / block;
		List<Pair<Integer, Integer>> list = Lists.newArrayList();
		for (int i = 1; i <= times; i++) {
			int num = n - i * block + i;
			list.add(new Pair<Integer, Integer>(num, i));
		}
		return list;
	}
}
