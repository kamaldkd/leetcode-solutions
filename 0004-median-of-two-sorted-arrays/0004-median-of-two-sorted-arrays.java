class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int[] combined = new int[m + n];
        int i = 0;
        int j = 0;
        int index = 0;
        
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                combined[index++] = nums1[i++];
            } else {
                combined[index++] = nums2[j++];
            }
        }
        
        while(i < m) {
                combined[index++] = nums1[i++];
        }
        
        while(j < n) {
                combined[index++] = nums2[j++];
        }
               
        int x = combined.length;
        if(x == 1) {
            return combined[0];
        } else {
        int mid = x / 2;
        if(x % 2 == 0) return (double)(combined[mid - 1] + combined[mid]) / 2;
        else return combined[mid];
        } 
    }
}