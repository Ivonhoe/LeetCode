import java.util.HashMap;
import java.util.Map;

class WordsFrequency {

    Map<String, Integer> map = new HashMap<>();

    public WordsFrequency(String[] book) {
        for (String word : book) {
            int cnt = map.getOrDefault(word, 0);
            map.put(word, cnt + 1);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book); int param_1 = obj.get(word);
 */