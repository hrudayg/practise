package com.practise.trie;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}

	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
		this.root = root;
	}
	
}
