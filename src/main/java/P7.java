import java.util.ArrayList;
import java.util.List;

public class P7 {

	public static void main(String[] args) {
		List<Integer> primesList = new ArrayList<Integer>();
		primesList.add(2);
		for (int i = 3;; i++) {
			if (primesList.size() == 10001) {
				System.out.println(primesList.get(10000));
				break;
			}

			boolean flag = false;
			for (int j = 0; j < primesList.size(); j++) {
				if (i % primesList.get(j) == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				primesList.add(i);
			}
		}
	}

}
