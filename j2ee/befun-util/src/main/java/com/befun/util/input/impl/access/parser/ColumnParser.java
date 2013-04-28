package com.befun.util.input.impl.access.parser;

import java.util.Map;

public interface ColumnParser<T> {

    T parse(Map<String, Object> col);
}
