package org.sai.poc.ds.cache.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.sai.poc.ds.cache.LRUCache;

/**
 * Unit test for LRU cache
 */
public class LRUCacheTest {

    private LRUCache<Integer, String> cache = new LRUCache<>();

    @Test
    public void testAdd() {
	cache.add(1, "Hello");
	cache.add(2, "World");
	String val = cache.get(2);
	assertEquals(val, "World");
    }
}
