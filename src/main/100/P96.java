import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

public class P96 {

	public static void main(String[] args) throws IOException {
		List<String> lines = FileUtils.readLines(new File(
				"data/p096_sudoku.txt"));
		for (int i = 0; i < lines.size(); i += 10) {
			int[][] digits = new int[9][9];
			for (int j = i + 1; j < i + 10; j++) {
				String line = lines.get(j);
				for (int k = 0; k < line.length(); k++) {
					digits[j - i - 1][k] = line.charAt(k) - '0';
				}
			}

			permMain(digits);
			// System.out.println(JSON.toJSONString(digits));
			break;
		}
	}

	static void permMain(int[][] matrix) {
		List<List<Integer>> rowAllowed = Lists.newArrayList();
		List<List<Integer>> colAllowed = Lists.newArrayList();
		List<List<Integer>> diagAllowed = Lists.newArrayList();
		for (int i = 0; i < 9; i++) {
			List<Integer> rowAllowedDigits = new LinkedList<>(
					Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9));
			List<Integer> colAllowedDigits = new LinkedList<>(
					Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9));
			for (int j = 0; j < 9; j++) {
				if (matrix[i][j] != 0) {
					rowAllowedDigits.remove((Object) matrix[i][j]);
				}
				if (matrix[j][i] != 0) {
					colAllowedDigits.remove((Object) matrix[j][i]);
				}
			}
			rowAllowed.add(rowAllowedDigits);
			colAllowed.add(colAllowedDigits);
		}

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				List<Integer> diagAllowedDigits = new LinkedList<>(
						Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9));
				for (int k = i; k < i + 3; k++) {
					if (matrix[k][j] != 0) {
						diagAllowedDigits.remove((Object) matrix[k][j]);
					}
					if (matrix[k][j + 1] != 0) {
						diagAllowedDigits.remove((Object) matrix[k][j + 1]);
					}
					if (matrix[k][j + 2] != 0) {
						diagAllowedDigits.remove((Object) matrix[k][j + 2]);
					}
					diagAllowed.add(diagAllowedDigits);
				}
			}
		}

		int startI = -1;
		int startJ = -1;
//		int minAllowedCount = 100;// 写入一个不可能出现的值
		List<Integer> allows = null;
		while (true) {
			if (matrix[0][0] != 0 && matrix[0][1] != 0 && matrix[0][2] != 0) {
				System.out.println(JSON.toJSONString(matrix));
				break;
			}
			loop: for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (matrix[i][j] == 0) {
						List<Integer> allowed = Lists.newArrayList(rowAllowed
								.get(i));
						allowed.retainAll(colAllowed.get(j));
						allowed.retainAll(diagAllowed.get(getRectPos(i, j)));
						if (allowed.size() == 1) {
							matrix[i][j] = allowed.get(0);
							rowAllowed.get(i).remove((Object) matrix[i][j]);
							colAllowed.get(j).remove((Object) matrix[i][j]);
							diagAllowed.get(getRectPos(i, j)).remove(
									(Object) matrix[i][j]);
							break loop;
//						} else if (minAllowedCount > allowed.size()) {
//							minAllowedCount = allowed.size();
//							allows = allowed;
//							startI = i;
//							startJ = j;
						}
					}
				}
			}
		}
		System.out.println("i: " + startI + " j: " + startJ + " " + allows);
	}

	static void perm(int[][] matrix, List<List<Integer>> rowAllowed,
			List<List<Integer>> colAllowed, List<List<Integer>> diagAllowed) {

	}

	static int getRectPos(int i, int j) {
		return (i / 3) * 3 + j / 3;
	}
}
