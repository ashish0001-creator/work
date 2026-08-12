import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // End word must be present in the dictionary
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Store words for fast searching
        Set<String> words = new HashSet<>(wordList);

        // BFS queue
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // Initial sequence length
        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                // Change each character
                for (int j = 0; j < current.length(); j++) {

                    char[] chars = current.toCharArray();

                    // Try a-z
                    for (char c = 'a'; c <= 'z'; c++) {

                        chars[j] = c;
                        String next = new String(chars);

                        // Destination found
                        if (next.equals(endWord)) {
                            return level + 1;
                        }

                        // Valid and unvisited word
                        if (words.contains(next)) {
                            queue.offer(next);
                            words.remove(next);
                        }
                    }
                }
            }

            level++;
        }

        return 0;
    }
}