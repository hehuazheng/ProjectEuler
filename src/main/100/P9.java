public class P9 {

	public static void main(String[] args) {
		int max = 1000;
		for(int i = 1; i < max; i++) {
			for(int j = i; j < max; j++) {
				for(int k = j; k < max; k++ ) {
					int squareI = i*i;
					int squareJ = j*j;
					int squareK = k*k;
					int sum = i + j + k;
					
					if(sum > 1000) {
						break;
					}
					if(sum == 1000 && squareI + squareJ == squareK ) {
						System.out.println(i + " " + j + " " + k);
						break;
					}
				}
			}
		}
	}

}
