package com.befun.domain.estate;

public enum MediaType {

	PICTURE, VIDEO, FILE;

	public static MediaType getValue(int ordinal) {
		for (MediaType e : MediaType.values()) {
			if (e.ordinal() == ordinal) {
				return e;
			}
		}
		throw new IllegalArgumentException(ordinal + " not acceptable!");
	}
}
