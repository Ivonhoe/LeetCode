import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<String> ans = new ArrayList<>();

    public String[] permutation(String s) {
        List<Character> path = new ArrayList<>();
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        boolean[] used = new boolean[s.length()];
        bracktrace(charArray, 0, path, used);
        return ans.toArray(new String[ans.size()]);
    }

    private void bracktrace(char[] s, int k, List<Character> path, boolean[] used) {
        if (path.size() == s.length) {
            StringBuffer sb = new StringBuffer();
            for (Character c : path) {
                sb.append(c);
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (used[i] || (i > 0 && s[i - 1] == s[i]) && !used[i - 1]) {
                continue;
            }

            path.add(c);
            used[i] = true;
            bracktrace(s, i + 1, path, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
