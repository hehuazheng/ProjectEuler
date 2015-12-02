package com.projecteuler;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Lists;

public class P13 {

	public static void main(String[] args) throws IOException {
		List<String> lines = FileUtils.readLines(new File("data/p13.data"));
		List<Integer> list = Lists.newArrayList();
		int toBeAdd = 0;
		for (int i = 49; i >= 0; i--) {
			int sum = toBeAdd;
			for (String line : lines) {
				try {
				sum += (line.charAt(i) - '0');
				}catch(Exception e) {
					System.out.println(line + " " + i);
					throw new IOException();
				}
			}
			toBeAdd = sum / 10;
			list.add(sum % 10);
		}
		Collections.reverse(list);
		System.out.println(toBeAdd + ", " + list);
	}

}
