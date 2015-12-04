package com.study.common.util;

import com.alibaba.fastjson.JSON;

public class Pair<F, S> {
	public Pair(F f, S s) {
		this.f = f;
		this.s = s;
	}

	public Pair() {
	}

	public F f;
	public S s;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
