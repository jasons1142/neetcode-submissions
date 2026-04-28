class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                return true;
            } else {
                map.put(num, 1);
            }
        }
        return false;
    }
}
