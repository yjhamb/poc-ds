package org.sai.poc.ds.cache.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

    @Test
    public void testRemove() {
	cache.add(1, "Hello");
	cache.add(2, "World");
	cache.remove(2);
	String val = cache.get(2);
	assertNull(val);
    }

    @Test
    public void testAddWithPurge() {
	cache.add(1, "Hello");
	for (int i = 0; i < 9; i++) {
	    cache.add(i, "Value" + i);
	}
	String val = cache.get(0);
	cache.list();
	assertEquals(val, "Value0");
    }
}
