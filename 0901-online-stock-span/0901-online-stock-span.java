class StockSpanner {
    ArrayList<Integer> list;
    Deque<Integer> st;
    int i;

    public StockSpanner() {
        list = new ArrayList<>();
        st = new ArrayDeque<>();
        i = 0;
    }

    public int next(int price) {
        list.add(price);
        while (!st.isEmpty() && price >= list.get(st.peek())) {
            st.pop();
        }

        int span;
        if (st.isEmpty())
            span = i + 1;
        else
            span = i - st.peek();

        st.push(i++);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */