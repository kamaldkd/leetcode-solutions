class Solution {
    public int removeDuplicates(int[] nums) {
        // ui -> unique index
        // int ui = 0;
        // for(int i = 1; i < nums.length; i++) {
        //     if(nums[i] != nums[i - 1]) {
        //         ui++;
        //         nums[ui] = nums[i];
        //     }
        // }
        // return ui + 1;

        // This pointer tracks the position to insert the next unique element
        int insertIndex = 1; 
        
        // Start iterating from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous one, it's unique
            if (nums[i] != nums[i - 1]) {
            	nums[insertIndex] = nums[i]; // Move it to the correct position
                insertIndex++; // Increment the count of unique elements
            }
        }
        
        // insertIndex represents the total number of unique elements (k)
        return insertIndex;
    }
}