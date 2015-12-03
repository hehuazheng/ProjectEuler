

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

public class P22 {

	public static void main(String[] args) throws IOException {
		String content = FileUtils.readFileToString(new File(
				"data/p022_names.txt"));
		String[] words = content.split(",");
		Arrays.sort(words);
		long sum = 0;
		for (int i = 0; i < words.length; i++) {
			sum += calcSum(words[i]) * (i+1);
		}
		System.out.println(sum);
	}

	static int calcSum(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '"') {
				continue;
			}
			sum += (s.charAt(i) - 'A' + 1);
		}
		return sum;
	}

}
