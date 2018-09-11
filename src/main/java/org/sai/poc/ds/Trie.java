package com.apple.ist.poc.ds;

import java.util.LinkedList;
import java.util.List;

public class Trie {

	private class TrieNode {
		List<TrieNode> children = new LinkedList<>();
		boolean end = false;
		char content;

		private TrieNode() {
		}

		private TrieNode(char ch) {
			content = ch;
		}

		private void addChild(TrieNode child) {
			children.add(child);
		}

		private TrieNode getChild(char ch) {
			for (TrieNode child : children) {
				if (child.content == ch) {
					return child;
				}
			}
			return null;
		}
	}

	TrieNode root = null;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode parent = root;
		for (int i = 0; i < word.length(); i++) {
			char current = word.charAt(i);
			TrieNode child = parent.getChild(current);
			if (child == null) {
				child = new TrieNode(current);
				parent.addChild(child);
			}
			parent = child;
		}
		parent.end = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			node = node.getChild(word.charAt(i));
			if (node == null) {
				return false;
			}
		}
		return node.end;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			node = node.getChild(prefix.charAt(i));
			if (node == null) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
