package com.devstromo.maps.chaining;

import lombok.Data;
import lombok.NonNull;

@Data
class HashItem<K, V> {
    private final K key;
    @NonNull
    private V value;
    private HashItem<K, V> nextHashItem;
}
