class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];

        for (int[] relationship : trust) {
            score[relationship[0]]--; // This person trusts someone
            score[relationship[1]]++; // Someone trusts this person
        }

        for (int person = 1; person <= n; person++) {
            if (score[person] == n - 1) {
                return person;
            }
        }

        return -1;
    }
}