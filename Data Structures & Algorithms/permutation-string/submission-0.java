class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = s1.length() - 1;

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1Freq[c - 'a']++;
        }

        while (right < s2.length()) {
            int[] subFreq = new int[26];
            for (int i = left; i <= right; i++) {
                char c = s2.charAt(i);
                subFreq[c-'a']++;
            }

            if (Arrays.equals(subFreq, s1Freq)) {
                return true;
            }

            left++;
            right++;
        }

        return false;
    }
}
