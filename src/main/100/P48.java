public class P48 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long lastTenSum = 0;
		final long remain = 10000000000L;
		for(int i = 1; i < 1001; i++) {
			long sum = 1;
			for(int j = 0; j < i; j++) {
				sum *= i;
				sum %= remain;
			}
			lastTenSum += sum;
			lastTenSum %= remain;
		}
		System.out.println(lastTenSum);
		System.out.println("time: " + (System.currentTimeMillis() - start));
	}

}
