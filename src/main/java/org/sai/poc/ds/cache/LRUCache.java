package org.sai.poc.ds.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Implementation of the LRU Cache
 *
 */
public class LRUCache<K, V> {

    private static final int MAX_CACHE_SIZE = 10;

    private Map<K, V> cacheMap = new HashMap<>(MAX_CACHE_SIZE);
    private LinkedList<K> cacheList = new LinkedList<>();

    public void add(K key, V value) {
	if (cacheMap.size() == MAX_CACHE_SIZE) {
	    // purge least recently used item
	    purge();
	}
	// add new entry
	cacheMap.put(key, value);
	cacheList.addLast(key);
    }

    private void purge() {
	K key = cacheList.pollFirst();
	cacheMap.remove(key);
    }

    public void remove(K key) {
	int index = cacheList.indexOf(key);
	cacheList.remove(index);
	cacheMap.remove(key);
    }

    public V get(K key) {
	int index = cacheList.indexOf(key);
	cacheList.remove(index);
	cacheList.addLast(key);
	return cacheMap.get(key);
    }
}
