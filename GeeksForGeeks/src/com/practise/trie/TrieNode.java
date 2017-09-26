package com.practise.trie;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://www.youtube.com/watch?v=AXjmTQ8LEoI
 * 
 * @author hruday.g
 *
 */
public class TrieNode {

	private Map<Character, TrieNode> children;
	private boolean isEndOfWord;

	public TrieNode() {
		children = new TreeMap<>();
	}

	public TrieNode insert(char ch) {
		TrieNode trieNode = null;
		if (children == null) {
			trieNode = new TrieNode();
			trieNode.children.put(ch, new TrieNode());
		} else {
			trieNode = children.get(ch);
			if (trieNode == null) {
				trieNode = new TrieNode();
				this.children.put(ch, trieNode);
			} else {
				return trieNode;
			}
		}
		return this.children.get(ch);
	}

	public boolean isEndOfWord() {
		return isEndOfWord;
	}

	public void setEndOfWord(boolean isEndOfWord) {
		this.isEndOfWord = isEndOfWord;
	}
	
	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		Set<Character> childrenChars = this.children.keySet();
		StringBuffer sb = new StringBuffer();
		for (char ch : childrenChars) {
			sb.append(ch + " -> ");
			TrieNode trieNode = this.children.get(ch);
			String childNodeStr = trieNode.toString();
			if (!childNodeStr.isEmpty()) {
				sb.append("[" + childNodeStr + "]");
			}
		}
		return sb.toString();
	}

	public TrieNode exits(char ch) {
		TrieNode trieNode = this.children.get(ch);
		return trieNode;
	}

}
