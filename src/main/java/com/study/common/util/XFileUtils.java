package com.study.common.util;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class XFileUtils {
	public static int[][] readIntMatrixFromFile(String path) throws Exception {
		return readIntMatrixFromFile(path, 0);
	}

	public static int[][] readIntMatrixFromFile(String path, int defaultValue)
			throws Exception {
		List<String> list = FileUtils.readLines(new File(path), "utf-8");
		int[][] result = new int[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			String[] arr = list.get(i).split(",");
			result[i] = new int[arr.length];
			for (int j = 0; j < arr.length; j++) {
				try {
					result[i][j] = Integer.parseInt(arr[j]);
				} catch (Exception e) {
					result[i][j] = defaultValue;
				}
			}
		}
		return result;
	}
}
