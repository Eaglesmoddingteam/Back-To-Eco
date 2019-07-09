package com.bteteam.bte.helper;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamHelper {

	private StreamHelper() {

	}

	public static <T> Stream<T> combine(Stream<T[]> stream) {
		ArrayList<T> list = new ArrayList<>();
		stream.map(Lists::newArrayList).forEach(list::addAll);
		return list.stream();
	}


}
