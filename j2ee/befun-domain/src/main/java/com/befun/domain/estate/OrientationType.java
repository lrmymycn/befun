package com.befun.domain.estate;

public enum OrientationType {

	EAST, SOUTH, WEST, NORTH;

	public static OrientationType getValue(int ordinal) {
		for (OrientationType e : OrientationType.values()) {
			if (e.ordinal() == ordinal) {
				return e;
			}
		}
		throw new IllegalArgumentException(ordinal + " not acceptable!");
	}
}
