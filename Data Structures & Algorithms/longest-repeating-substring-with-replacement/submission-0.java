class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxCount = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            maxCount = Math.max(maxCount, map.get(c));

            if ((right - left + 1) - maxCount > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
        
    }
}
