class Solution {
    public List<Integer> generateRow(int rowIndex) {
        List<Integer> row = new LinkedList<>();
        long ans = 1;
        row.add(1);

        for(int col = 1; col < rowIndex; col++) {

            ans *= (rowIndex - col);
            ans /= col;

            row.add((int)ans);
        }

        return row;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        
        for(int i = 1; i <= numRows; i++) {
            ans.add(generateRow(i));
        }

        return ans;
    }
}