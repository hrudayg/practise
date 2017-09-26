package com.practise.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrieUtil {

	public static void main(String[] args) {
		Trie wordsDic = new Trie();
		TrieNode root = wordsDic.getRoot();

		List<String> wordsList = new ArrayList<>();
		wordsList.add("abc");
		wordsList.add("add");
		wordsList.add("abcd");
		wordsList.add("hruday");
		wordsList.add("peepli");

		System.out.println(" *** inserting in to the trie start ***");

		for (String word : wordsList) {
			root = insert(root, word);
			List<String> stringList = getAllStings(root);
			System.out.println(stringList);
		}

		System.out.println(" *** inserting in to the trie end ***");

		List<String> existsList = new ArrayList<>();
		existsList.add("abd");
		existsList.add("hello");
		existsList.add("hruday");

		for (String word : existsList) {
			boolean isExists = checkIfExists(root, word);
			if (isExists) {
				System.out.println("word " + word + " exists");
			} else {
				System.out.println("word " + word + " does not exists");
			}
			// System.out.println(root.toString());
		}

		List<String> prefixes = new ArrayList<>();
		prefixes.add("ab");
		prefixes.add("pra");

		System.out.println("*** getting all prefixed strings ***");
		for (String word : prefixes) {
			getAllStringWithPrefix(root, word);
		}

		System.out.println("*** getting all prefixed strings done ***");
		
	}

	private static List<String> getAllStringWithPrefix(TrieNode root, String word) {
		TrieNode temp = root;
		int index = 0;
		List<String> results = new ArrayList<>();
		boolean isPrefixFound = true;
		while (index < word.length()) {
			char ch = word.charAt(index);
			TrieNode trieNode = temp.exits(ch);
			if (trieNode != null) {
				temp = trieNode;
			} else {
				isPrefixFound = false;
				break;
			}
			index++;
		}

		if (isPrefixFound) {
			List<String> prefixedStrings = getAllStings(temp, word, new ArrayList<>());
			System.out.println(prefixedStrings);
		}

		return null;

	}
	
	private static List<String> getAllStings(TrieNode node){
		return getAllStings(node, "", new ArrayList<String>());
	}

	private static List<String> getAllStings(TrieNode node, String string, List<String> resultStrings) {
		for(Map.Entry<Character, TrieNode> entry : node.getChildren().entrySet()){
			TrieNode trieNode = entry.getValue();
			getAllStings(trieNode, string+entry.getKey(), resultStrings);
		}
		if(node.isEndOfWord()){
			resultStrings.add(string);
		}
		
		return resultStrings;
	}

	private static boolean checkIfExists(TrieNode root, String word) {
		System.out.println("checking if the word: "+word +" exists or not");
		TrieNode temp = root;
		int index = 0;
		boolean isWordExists = false;
		while (index < word.length()) {
			char ch = word.charAt(index);
			TrieNode trieNode = temp.exits(ch);
			if (trieNode == null) {
				return false;
			}
			temp = trieNode;
			index++;
		}

		if (temp.isEndOfWord()) {
			return true;
		}

		return isWordExists;
	}

	private static TrieNode insert(TrieNode root, String word) {
		System.out.println("inserting word: "+word);
		TrieNode temp = root;
		for (char ch : word.toCharArray()) {
			TrieNode returnedTrieNode = root.insert(ch);
			root = returnedTrieNode;
		}
		root.setEndOfWord(true);
		return temp;
	}

}
