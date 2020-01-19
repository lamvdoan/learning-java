package exercise.tree;

public class TrieTest {
    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their", "answering", "answered", "answers"};

        Trie trie = new Trie();

        for (String key : keys) {
            trie.insert(key);
        }

        System.out.println("true, " + trie.search("answer"));
        System.out.println("false, " + trie.search("an"));
        System.out.println("true, " + trie.search("the"));

        System.out.println();

        trie.autoComplete("tr");
        trie.autoComplete("there");
        trie.autoComplete("an");
    }
}
