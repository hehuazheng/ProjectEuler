import java.util.List;

import com.google.common.collect.Lists;

public class P104 {

	public static void main(String[] args) {
		List<Integer> add1 = Lists.newArrayList(1);
		List<Integer> add2 = Lists.newArrayList(1);
		int n = 2;
		while (true) {
			System.out.println(add1.size());
			add(add1, add2);
			n++;
			if (satisfied(add1)) {
				System.out.println(add1);
				System.out.println(n);
				break;
			}
			add(add2, add1);
			n++;
			if (satisfied(add2)) {
				System.out.println(add2);
				System.out.println(n);
				break;
			}
		}
	}

	/**
	 * 大数加法，个位在前
	 */
	static void add(List<Integer> add1, List<Integer> add2) {
		int remain = 0;
		for (int i = 0; i < add2.size(); i++) {
			int sum = add2.get(i) + remain;
			if (i < add1.size()) {
				sum += add1.get(i);
				add1.set(i, sum % 10);
			} else {
				add1.add(sum % 10);
			}
			remain = sum / 10;
		}
		while (remain > 0) {
			add1.add(remain % 10);
			remain /= 10;
		}
	}

	static boolean satisfied(List<Integer> list) {
		int sz = list.size();
		if (sz < 9) {
			return false;
		} else if (sz >= 9) {
			boolean[] flag = new boolean[9];
			for (int i = 0; i < 9; i++) {
				int val = list.get(i);
				if (val == 0) {
					return false;
				}
				if (flag[val - 1]) {
					return false;
				}
				flag[val - 1] = true;
			}

			boolean[] flag2 = new boolean[9];
			for (int i = sz - 9; i < sz; i++) {
				int val = list.get(i);
				if (val == 0) {
					return false;
				}
				if (flag2[val - 1]) {
					return false;
				}
				flag2[val - 1] = true;
			}
		}
		return true;
	}

}
