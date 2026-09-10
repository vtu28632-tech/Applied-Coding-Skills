import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t -'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int countMax = 0;
        for (int f : freq) {
            if (f == maxFreq) countMax++;
        }

        int partCount = maxFreq - 1;
        int partLength = n + 1;
        int emptySlots = partCount * partLength + countMax;

        return Math.max(emptySlots, tasks.length);
    }
}
