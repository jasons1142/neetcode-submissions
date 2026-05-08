class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        int[] output = new int[n];

        prefix[0] = nums[0];
        postfix[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        for (int i = n - 2; i > 0; i--) {
            postfix[i] = nums[i] * postfix[i + 1];
        }

        output[0] = postfix[1];
        output[n - 1] = prefix[n - 2];

        for (int i = 1; i < n - 1; i++) {
            output[i] = prefix[i - 1] * postfix[i + 1];
        }

        return output;

    }
}  
