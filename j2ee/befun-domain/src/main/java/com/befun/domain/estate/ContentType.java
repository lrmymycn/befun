package com.befun.domain.estate;

public enum ContentType {

	FLOORPLAN, RENDER_INTERNAL, RENDER_EXTERNAL, PHOTOGRAPH, ENVIRONMENT, FLOORPLATE, OTHER;

	public static ContentType getValue(int ordinal) {
		for (ContentType e : ContentType.values()) {
			if (e.ordinal() == ordinal) {
				return e;
			}
		}
		throw new IllegalArgumentException(ordinal + " not acceptable!");
	}
}
