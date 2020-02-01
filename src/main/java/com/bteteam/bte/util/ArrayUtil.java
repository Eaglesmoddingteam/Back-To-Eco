package com.bteteam.bte.util;

import com.google.common.collect.Sets;

import java.util.HashSet;

public class ArrayUtil {

	public static <T> boolean smartCompare(T[] arr1, T[] arr2) {
		HashSet<T> set = Sets.newHashSet(arr1);
		HashSet<T> set2 = Sets.newHashSet(arr2);
		return set.equals(set2);
	}

}
