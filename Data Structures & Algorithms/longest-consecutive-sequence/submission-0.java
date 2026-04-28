class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longestStreak = 0;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num : set) {
            
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }   
        }

        return longestStreak;

    }
}
