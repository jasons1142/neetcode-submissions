class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] freq = new int[k];

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((a, b) -> Integer.compare(a.getValue(), b.getValue()));

        int index = 0;
        for (int i = entryList.size() - 1; i >= entryList.size() - k; i--) {
            freq[index++] = entryList.get(i).getKey();
        }

        return freq;
    }
}
