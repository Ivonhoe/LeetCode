class Solution {
    public int findString(String[] words, String s) {
        int low = 0, high = words.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            while (mid > low && words[mid].equals("")) {
                mid--;
            }

            if (words[mid].compareTo(s) == 0) {
                return mid;
            } else if (words[mid].compareTo(s) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}