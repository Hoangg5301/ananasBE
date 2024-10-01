package com.example.ananasstore.common.functioninterface;

import java.util.function.Function;

public interface ConverterEntityToDto<T, U> extends Function<T,U> {
}
