class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new LinkedList<>();
        long ans = 1;
        row.add(1);
        for(int col = 1; col <= rowIndex; col++) {
            ans *= ((rowIndex + 1) - col);
            ans /= col;
            row.add((int)ans);
        }
        return row;
    }
}