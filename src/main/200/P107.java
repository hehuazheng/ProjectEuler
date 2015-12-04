import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.study.common.util.Pair;
import com.study.common.util.XFileUtils;

public class P107 {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		final int[][] matrix = XFileUtils.readIntMatrixFromFile(
				"data/p107_network.txt", Integer.MAX_VALUE);
		int sz = matrix.length;

		int sum = 0;
		List<Pair<Integer, Integer>> edgeList = Lists.newArrayList();
		for (int i = 0; i < sz - 1; i++) {
			for (int j = i + 1; j < sz; j++) {
				if (matrix[i][j] != Integer.MAX_VALUE) {
					edgeList.add(new Pair<Integer, Integer>(i, j));
					sum += matrix[i][j];
				}
			}
		}

		// 对边排序
		Collections.sort(edgeList, new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> o1,
					Pair<Integer, Integer> o2) {
				return matrix[o1.f][o1.s] - matrix[o2.f][o2.s];
			}
		});

		boolean[] connected = new boolean[sz];
		List<Set<Integer>> connectList = Lists.newArrayList();
		Pair<Integer, Integer> p = edgeList.get(0);
		connected[p.f] = true;
		connected[p.s] = true;
		addToSet(connectList, p);

		int localsum = matrix[p.f][p.s];
		for (int i = 1; i < edgeList.size(); i++) {
			p = edgeList.get(i);
			// 只要有一点不在集合中，则直接加入
			if (!connected[p.f] || !connected[p.s]) {
				connected[p.f] = true;
				connected[p.s] = true;
				addToSet(connectList, p);
				localsum += matrix[p.f][p.s];
			} else {
				// 检查两点均在集合中，但是否联通，不联通，则需要加入
				if(!connected(connectList, p)) {
					localsum += matrix[p.f][p.s];
					//将其连通
					merge(connectList, p);
				}
			}
		}

		System.out.println(sum - localsum);
		System.out.println("time: " + (System.currentTimeMillis() - start));
	}

	static void merge(List<Set<Integer>> list, Pair<Integer, Integer> p) {
		int cnt = 0;
		int[] idx = new int[2];
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).contains(p.f)) {
				idx[cnt++] = i;
			}
			if(list.get(i).contains(p.s)) {
				idx[cnt++] = i;
			}
			if(cnt == 2) {
				break;
			}
		}
		list.get(idx[0]).addAll(list.get(idx[1]));
		list.remove(idx[1]);
	}
	
	static void addToSet(List<Set<Integer>> list, Pair<Integer, Integer> p) {
		for (Set<Integer> set : list) {
			if (set.contains(p.f) || set.contains(p.s)) {
				set.add(p.f);
				set.add(p.s);
				return;
			}
		}
		Set<Integer> set = new HashSet<>();
		set.add(p.f);
		set.add(p.s);
		list.add(set);
	}
	
	static boolean connected(List<Set<Integer>> list, Pair<Integer, Integer> p) {
		for (Set<Integer> set : list) {
			if (set.contains(p.f) && set.contains(p.s)) {
				return true;
			}
		}
		return false;
	}
}
