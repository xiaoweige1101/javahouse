package com.javahouse.jdk.function;

import java.util.Objects;
import java.util.function.Function;

public class DataBuilder {

    public static<K, V> V build(K key, Function<? super K, ? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        V v = mappingFunction.apply(key);

        return v;
    }


}
