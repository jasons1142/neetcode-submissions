class Solution {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> set = new HashSet<>();
        int start = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }

            set.add(c);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
