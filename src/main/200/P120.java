public class P120 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int sum = 0;
		for (int a = 3; a <= 1000; a++) {
			sum += calcRmax(a);
		}
		System.out.println(sum);
		System.out.println("time: " + (System.currentTimeMillis() - start));
	}

	static int calcRmax(int a) {
		int rmax = 0;
		int square = a * a;
		for (int n = 1; 2 * n <= a; n++) {
			int mul = (2 * n * a) % square;
			if (mul > rmax) {
				rmax = mul;
			}
		}
		return rmax;
	}

}
