class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int max = 0;
        for(int num : set) {
            if(set.contains(num-1)) continue;

            int currMax = 0;
            while(set.contains(num)) {
                currMax += 1;
                num += 1;
            }

            max = Math.max(max, currMax);
        }
        return max;
    }
}