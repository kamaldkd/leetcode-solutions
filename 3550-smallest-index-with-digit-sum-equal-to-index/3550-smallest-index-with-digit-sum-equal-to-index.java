class Solution {
    public int findDigitSum(int num) {
        int ans = 0;
        while(num > 0) {
            int digit = num % 10;
            ans += digit;
            num /= 10;
        }
        return ans;
    }
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(findDigitSum(nums[i]) == i) return i;
        }
        return -1;
    }
}