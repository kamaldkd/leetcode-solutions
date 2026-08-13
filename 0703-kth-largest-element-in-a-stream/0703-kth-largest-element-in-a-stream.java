import java.util.*;

class KthLargest {
    PriorityQueue<Integer> pq;
    int kth;
    
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        kth = k;
        for(int i=0; i<nums.length; i++) {
            pq.offer(nums[i]);
            if(pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        if(pq.size() < kth) {
            pq.offer(val);
        } else if(val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna