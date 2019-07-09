package com.bteteam.bte.helper;

import com.bteteam.bte.registries.Registry;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReflectCollector {

	private ReflectCollector() {

	}

	public static <T> Stream<T> streamEntries(@Nonnull Registry<T> registry) {
		return getEntries(registry).stream();
	}

	public static <T> List<T> getEntries(@Nonnull Registry<T> registry) {
		Class type = registry.getType();
		List<T> tList = new ArrayList<>();
		Arrays.stream(registry.getClass().getDeclaredFields()).filter(f -> f.getType() == type).forEach(f -> {
			try {
				tList.add((T) f.get(registry));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});
		return tList;
	}

}
