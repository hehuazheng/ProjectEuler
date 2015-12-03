
public class P4 {
	public static void main(String[] args) {
		int a = 999;
		int b = 999;
		
		int max = a *b;
		
		boolean flag = false;
		for(int i = max; i > 0; i--) {
			for(int j = 100; j < 1000; j++) {
				if((i % j == 0) && (i/j) < 1000 && isPalindrome(i)) {
					System.out.println(i);
					System.out.println(j);
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		
	}
	
	private static final boolean isPalindrome(int d) {
		String s = String.valueOf(d);
		int len = s.length();
		int i = len/2;
		for(int j = 0; j <= i; j++) {
			if(!(s.charAt(j) == s.charAt(len - j -1))) {
				return false;
			}
		}
		return true;
	}
}
