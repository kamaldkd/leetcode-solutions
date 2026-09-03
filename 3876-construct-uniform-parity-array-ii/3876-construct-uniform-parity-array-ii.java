class Solution {
    public boolean uniformArray(int[] nums1) {

        // 1. We can find the parity of the array by checking the smallest element :
        //    if smallest == even then "parity = even" else "parity = odd"
        //    why the smallest element ?
        //    - because of this following rule:- nums2[i] = nums1[i] - nums1[j], for an index j != i, such that nums1[i] - nums1[j] >= 1
        //     example Input: nums1 = [2,3], Output: false
        //     nums2[i] = nums1[i] - nums1[j] this is the condition,
        //     not the other way round, so nums2[0] = nums1[1] - nums[0] = 3 - 2 = 1 is invalid, assuming i=0, j=1


        // After some observation, i got a conclusion that, 
        // 1. If the parity of nums1 is even(means the smallest element in nums is even, ) then array can not be all even if there exists >= 1 odd element.
        // If the parity is odd, then we can return true.

        int smallest = Integer.MAX_VALUE;
        for(int num : nums1) smallest = Math.min(smallest, num);

        if(smallest % 2 == 0) { // even parity
            for(int num : nums1) {
                if(num % 2 != 0) return false;
            }
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna