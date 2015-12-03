

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P23 {

	public static void main(String[] args) {
		int max = 28124;
		List<Integer> abundantList = new ArrayList<Integer>();
		for (int i = 2; i < max; i++) {
			if (isAbundantNum(i)) {
				abundantList.add(i);
			}
		}
		
		int sum = 0;
		for(int i = 1; i < max; i++) {
			System.out.println(i);
			boolean flag = false;
			for(int j = 0; j < abundantList.size(); j++) {
				if(i <= abundantList.get(j)) {
					break;
				}
				
				if(abundantList.contains(i - abundantList.get(j))) {
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	static boolean isAbundantNum(int n) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				set.add(i);
				set.add(n / i);
			}
		}

		int sum = 1;
		for (int i : set) {
			sum += i;
		}
		return sum > n;
	}

}
