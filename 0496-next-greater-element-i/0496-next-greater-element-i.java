class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int n = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums2[n-1], -1);

        Stack<Integer> st = new Stack<>();
        st.push(nums2.length - 1); 

        for(int i = nums2.length - 2; i >= 0; i--) {
            int curr = nums2[i];
            while(!st.isEmpty() && curr > nums2[st.peek()]) st.pop();

            if(st.isEmpty()) map.put(curr, -1);
            else map.put(curr, nums2[st.peek()]);

            st.push(i);
        }

        int[] ans = new int[nums1.length];
        int i = 0;
        for(int num : nums1) {
            ans[i++] = map.get(num);
        }

        return ans;
    }
}