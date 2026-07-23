class StockSpanner {
    Deque<int[]> st; // (price, span)
    int currentIndex;

    public StockSpanner() {
        st = new ArrayDeque<>();
        currentIndex = 0;
    }

    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && price >= st.peek()[0]) {
            span += st.peek()[1];
            st.pop();
        }
        st.push(new int[]{price, span});

        return span;
    }
}

// expolanation of why we can also storr span.

// Instead of storing indices, store a pair:

// (price, span)

// For example:

// (100,1)
// (80,1)
// (60,1)

// Now suppose the next price is 70.

// We pop:

// (60,1)

// and instead of just removing it, we add its span.

// span = 1 + 1 = 2

// Then push:

// (70,2)

// Now suppose the next price is 75.

// Stack:

// (100,1)
// (80,1)
// (70,2)

// Pop:

// (70,2)
// span = 1 + 2 = 3

// Pop:

// (80,1)
// span = 3 + 1 = 4

// Push:

// (75,4)

// See the beauty?

// We don't need to count days one by one. Every popped element already knows the span of the days it represents.


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */