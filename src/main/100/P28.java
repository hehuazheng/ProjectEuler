

public class P28 {

	public static void main(String[] args) {
		int sum = 1;
		int end = 1001;
		for (int width = 3; width <= end; width += 2) {
			int start = (width - 2) * (width - 2) + width - 1;
			sum += 4 * start + 6 * (width -1);
		}
		System.out.println(sum);
	}

}
