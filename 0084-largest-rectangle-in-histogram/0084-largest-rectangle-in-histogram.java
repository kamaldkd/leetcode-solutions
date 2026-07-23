class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n]; // next smaller element
        Deque<Integer> st = new ArrayDeque<>();

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            
            st.push(i);
        }

        //  Emptying stack
        st = new ArrayDeque<>();

        int height, width, pse, maxArea=0;
        for(int i=0; i<n; i++) {
            height = heights[i];
            while(!st.isEmpty() && heights[st.peek()] >= height) {
                st.pop();
            }
            pse = st.isEmpty() ? -1 : st.peek();

            width = nse[i] - pse - 1;
            maxArea = Math.max(maxArea, height * width);
            
            st.push(i);
        }

        return maxArea;
    }
}