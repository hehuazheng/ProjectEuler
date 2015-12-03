
public class P3 {

	public static void main(String[] args) {
		long value = 600851475143L;
		for(int i = 2; i < 775147; i++ ) {
			if(value < i) {
				break;
			}
			while(value > i && value % i == 0) {
				value = value/i;
			}
		}
		System.out.println(value);
	}

}
