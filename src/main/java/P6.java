public class P6 {
	public static void main(String[] args) {
		int end = 100;
		int squareSum = 0;
		for (int i = 1; i <= end; i++) {
			squareSum += (i * i);
		}

		int sum = 0;
		for (int i = 1; i <= end; i++) {
			sum += i;
		}
		int sumSquare = sum * sum;
		System.out.println(sumSquare - squareSum);

	}
}
