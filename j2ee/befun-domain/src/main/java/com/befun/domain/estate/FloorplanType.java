package com.befun.domain.estate;

public enum FloorplanType {

	APARTMENT, TOWN_HOUSE, HOUSE;

	public static FloorplanType getValue(int ordinal) {
		for (FloorplanType e : FloorplanType.values()) {
			if (e.ordinal() == ordinal) {
				return e;
			}
		}
		throw new IllegalArgumentException(ordinal + " not acceptable!");
	}
}
