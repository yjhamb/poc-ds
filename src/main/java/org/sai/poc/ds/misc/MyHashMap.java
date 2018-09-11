package org.sai.poc.ds.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MyHashMap<K, V> {
	private int size = 100;
	private ArrayList<LinkedList<Entry<K, V>>> bucketList = new ArrayList<>(size);

	private static class Entry<K, V> {
		final K key;
		V value;
		final int hashCode;

		private Entry(K key, V value) {
			this.key = key;
			this.value = value;
			hashCode = key.hashCode();
		}

		public V getValue() {
			return value;
		}

		public K getKey() {
			return key;
		}

	}

	public MyHashMap() {
		for (int i = 0; i < size; i++) {
			bucketList.add(i, null);
		}
	}

	public void put(K key, V value) {
		int index = key.hashCode() % size;
		LinkedList<Entry<K, V>> entryList = bucketList.get(index);
		if (entryList == null) {
			entryList = new LinkedList<>();
			bucketList.add(index, entryList);
		}
		Entry<K, V> entry = new Entry<>(key, value);
		entryList.add(entry);
	}

	public V get(K key) {
		V value = null;
		int index = key.hashCode() % 100;
		LinkedList<Entry<K, V>> entryList = bucketList.get(index);
		List<V> vList = entryList.parallelStream().filter(e -> e.getKey().equals(key)).map(e -> e.getValue())
				.collect(Collectors.toList());
		if (vList != null) {
			value = vList.get(0);
		}
		return value;
	}

	public static void main(String[] args) {
		MyHashMap<Integer, Integer> map = new MyHashMap<>();
		map.put(10, 100);
		map.put(11, 101);
		map.put(12, 102);
		map.put(110, 103);
		System.out.println("The value is: " + map.get(110));
	}

}
