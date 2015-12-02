package com.projecteuler;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class P18 {

	public static void main(String[] args) throws IOException {
		List<String> lines = FileUtils.readLines(new File("data/p18.data"));
		int[][] table = new int[lines.size()][];
		for (int i = 0; i < lines.size(); i++) {
			String[] arr = lines.get(i).split("\\s+");
			table[i] = new int[arr.length];
			for (int j = 0; j < arr.length; j++) {
				table[i][j] = Integer.parseInt(arr[j]);
			}
		}

		for (int i = 1; i < lines.size(); i++) {
			for (int j = 0; j < table[i].length; j++) {
				int max = -1;
				if (j >= 1 && j <= table[i - 1].length) {
					max = table[i - 1][j - 1];
				}

				if (j < table[i - 1].length) {
					if (max < table[i - 1][j]) {
						max = table[i - 1][j];
					}
				}

				table[i][j] = max + table[i][j];
			}
		}

		int max = -1;
		int pos = 0;
		for (int i = 0; i < table[lines.size() - 1].length; i++) {
			if (max < table[lines.size() - 1][i]) {
				pos = i;
				max = table[lines.size() - 1][i];
			}
		}

		System.out.println(pos);
		System.out.println(max);
	}
}
