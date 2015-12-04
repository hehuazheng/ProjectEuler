import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Lists;

public class P59 {
	
	/**
	 * original text
	 * <pre>
	 * (The Gospel of John, chapter 1) 1 In the beginning the Word already existed. He was with God, and he was God. 2 He was in the beginning with God. 3 He created everything there is. Nothing exists that he didn't make. 4 Life itself was in him, and this life gives light to everyone. 5 The light shines through the darkness, and the darkness can never extinguish it. 6 God sent John the Baptist 7 to tell everyone about the light so that everyone might believe because of his testimony. 8 John himself was not the light; he was only a witness to the light. 9 The one who is the true light, who gives light to everyone, was going to come into the world. 10 But although the world was made through him, the world didn't recognize him when he came. 11 Even in his own land and among his own people, he was not accepted. 12 But to all who believed him and accepted him, he gave the right to become children of God. 13 They are reborn! This is not a physical birth resulting from human passion or plan, this rebirth comes from God.14 So the Word became human and lived here on earth among us. He was full of unfailing love and faithfulness. And we have seen his glory, the glory of the only Son of the Father.
	 * </pre>
	 * 
	 * hejf - 2015年12月4日
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		String content = FileUtils.readFileToString(new File(
				"data/p059_cipher.txt"), "utf-8");
		String[] arr = content.trim().split(",");
		List<Integer> list = Lists.newArrayList();
		for (String s : arr) {
			try {
				list.add(Integer.parseInt(s));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		PrintWriter pw = new PrintWriter(new File("d:/log.txt"));
		for (char i = 'a'; i <= 'z'; i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				for (char k = 'a'; k <= 'z'; k++) {
					StringBuilder sb = new StringBuilder();
					for (int m = 0; m < list.size(); m += 3) {
						sb.append((char) (list.get(m) ^ (int) i));
						if (m < list.size() - 1) {
							sb.append((char) (list.get(m + 1) ^ (int) j));
						}
						if (m < list.size() - 2) {
							sb.append((char) (list.get(m + 2) ^ (int) k));
						}
					}
					//pw.print(sb.toString());
					String candidate = sb.toString();
					if(candidate.contains("chapter") && candidate.contains("beginning")) {
						int sum = 0;
						for(int n = 0; n < candidate.length(); n++) {
							sum += (int)candidate.charAt(n);
						}
						System.out.println(sum);
						break;
					}
				}
			}
		}
		pw.close();
	}

}
