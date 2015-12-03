
/**
 * 素因数分解
 */
public class P5 {

	public static void main(String[] args) {
		int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
		int[] primesCounter = {0, 0, 0, 0, 0, 0, 0, 0};
		int end = 20;
		for(int i = 2; i <= end; i++ ) {
			for(int j = 0; j < primes.length && i >= primes[j]; j++) {
				int k = i;
				int cnt = 0;
				while(k % primes[j] == 0) {
					cnt++;
					k /= primes[j];
				}
				if(cnt > primesCounter[j]) {
					primesCounter[j] = cnt;
				}
			}
		}
		
		int sum = 1;
		for(int i = 0; i < primes.length; i++) {
			while(primesCounter[i] > 0) {
				sum *= primes[i];
				primesCounter[i]--;
			}
		}
		System.out.println(sum);
	}

}
