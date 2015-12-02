
public class P2 {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int max = 100;
		int sum = 2;
		while(true) {
			a = a + b;
			if(a >= max) {
				break;
			}
			if(a % 2 == 0) {
				sum += a;
			}
			
			b = a + b;
			if(b >= max) {
				break;
			}
			if(b % 2 == 0) {
				sum += b;
			}
		}
		System.out.println(sum);
	}

}
