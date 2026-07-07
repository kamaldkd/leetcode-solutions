class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int largestArea = -1;
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n]; // previous smaller element
        int[] nse = new int[n]; // next smaller element

        // pse
        st.push(0);
        pse[0] = -1;
        for (int i = 1; i <= n - 1; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty())
                pse[i] = -1;
            else
                pse[i] = st.peek();

            st.push(i);
        }
        // emptying stack
        while (!st.isEmpty())  st.pop();
        // nse
        st.push(n - 1);
        nse[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) nse[i] = n;
            else  nse[i] = st.peek();

            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            if (largestArea < area) {
                largestArea = area;
            }
        }
        return largestArea;
    }
}