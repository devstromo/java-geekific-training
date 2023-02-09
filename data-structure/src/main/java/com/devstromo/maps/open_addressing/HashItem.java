package com.devstromo.maps.open_addressing;

import lombok.Data;
import lombok.NonNull;

@Data
class HashItem<K, V> {
    private final K key;
    @NonNull
    private V value;
}