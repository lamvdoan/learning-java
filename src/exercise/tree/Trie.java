package exercise.tree;

import java.util.ArrayList;
import java.util.List;

class Trie {
    private TrieNode root;
    private static final int ALPHABET_SIZE = 26;
    private List<String> matches = new ArrayList<>();
    private boolean matchFound = false;

    private class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfString = false;
    }

    Trie() {
        root = new TrieNode();
    }

    void insert(String key) {
        key = key.toLowerCase();

        TrieNode node = root;

        for (int i = 0; i < key.length(); i++) {
            int alphaIndex = key.charAt(i) - 'a';

            if (node.children[alphaIndex] == null) {
                node.children[alphaIndex] = new TrieNode();
            }

            node = node.children[alphaIndex];
        }

        node.isEndOfString = true;
    }

    boolean search(String key) {
        key = key.toLowerCase();
        TrieNode node = root;

        for (int i = 0; i < key.length(); i++) {
            int alphaIndex = key.charAt(i) - 'a';

            if (node.children[alphaIndex] == null) {
                return false;
            }

            node = node.children[alphaIndex];
        }

        return node.isEndOfString;
    }

    void autoComplete(String key) {
        key = key.toLowerCase();

        TrieNode node = getNodeOfLastKeyLetter(key, root);
        lookForAnyMatch(key, node);
        printResults(key);
    }

    private TrieNode getNodeOfLastKeyLetter(String key, TrieNode node) {
        for (int i = 0; i < key.length(); i++) {
            int alphaIndex = key.charAt(i) - 'a';

            if (node.children[alphaIndex] == null) {
                node = null;
                break;
            }

            node = node.children[alphaIndex];
        }

        return node;
    }

    private void lookForAnyMatch(String key, TrieNode node) {
        if (node != null) {
            StringBuilder sb;

            // Match Found.  Now dig for all possible words.
            for (int j = 0; j < ALPHABET_SIZE; j++) {
                if (node.children[j] != null) {
                    sb = new StringBuilder(key);
                    sb.append(intToChar(j));
                    findWord(node.children[j], sb);
                }
            }
        }
    }

    private char intToChar(int number) {
        return (char) (number + (int) 'a');
    }

    private TrieNode findWord(TrieNode node, StringBuilder sb) {
        if (node.isEndOfString) {
            String key = sb.toString();
            matches.add(key);
            matchFound = true;
            lookForAnyMatch(key, node);

            return null;
        }

        for (int j = 0; j < ALPHABET_SIZE; j++) {
            if (node.children[j] != null) {
                sb.append((char) (j + (int) 'a')); // append the letter
                findWord(node.children[j], sb);
            }
        }

        return null;
    }

    private void printResults(String key) {
        if (matchFound) {
            System.out.println("Matches found for " + key + ":");
            matches.forEach(System.out::println);
        } else {
            System.out.println(String.format("No autocomplete found for '%s'", key));
        }

        System.out.println();
    }
}
