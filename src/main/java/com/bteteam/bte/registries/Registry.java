package com.bteteam.bte.registries;

public interface Registry<T> {

	Class<? extends T> getType();

}
