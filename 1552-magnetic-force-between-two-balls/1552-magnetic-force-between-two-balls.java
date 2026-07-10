class Solution {
    public boolean canPlace(int[] positions, int m, int force) {
        int nextBasket = positions[0] + force;
        m--;
        for(int i=1; i<positions.length; i++) {
            if(positions[i] >= nextBasket) {
                m--;
                nextBasket = positions[i] + force;
            }
        }

        return m <= 0;
    }
    public int maxDistance(int[] position, int m) {
        int[] positions = position;
        Arrays.sort(positions);

        int n = positions.length;

        int low = 1;
        int high = positions[n-1] - positions[0];

        int ans = 0;
        int mid;
        while(low <= high) {
            mid = low + (high-low)/2;
            if(canPlace(positions, m, mid)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}