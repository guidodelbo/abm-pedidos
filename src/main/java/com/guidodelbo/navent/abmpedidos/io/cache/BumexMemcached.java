package com.guidodelbo.navent.abmpedidos.io.cache;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class BumexMemcached {
    private static BumexMemcached singleInstance = null;
    private final Map<String, Object> map;

    private BumexMemcached() {
        this.map = new ConcurrentHashMap<>();
    }

    public static BumexMemcached getInstance() {
        if(Objects.isNull(singleInstance))
            singleInstance = new BumexMemcached();

        return singleInstance;
    }

    public void set(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void delete(String key) {
        map.remove(key);
    }
}
