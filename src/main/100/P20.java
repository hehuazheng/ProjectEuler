

import java.util.ArrayList;
import java.util.List;

public class P20 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		int n = 100;
		for (int i = 2; i <= n; i++) {
			int remain = 0;
			for (int j = 0; j < list.size(); j++) {
				int val = list.get(j) * i;
				val += remain;
				remain = val / 10;
				list.set(j, val % 10);
			}
			while(remain > 0) {
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
