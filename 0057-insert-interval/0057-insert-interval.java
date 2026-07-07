class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {

    // note:- Array is already sorted

    // initialization 
    int n = intervals.length;
    List<int[]> ans = new ArrayList<>();

    int i = 0;

    //add all intervals that are completely before newInterval.
    while (i < n && intervals[i][1] < newInterval[0]) {
      ans.add(intervals[i]);
      i++;
    }

    // Merge every overlapping interval into newInterval
    while (i < n && intervals[i][0] <= newInterval[1]) { // if there is an interval which starts before ending our newInterval then merge
      newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
      newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
      i++;
    }

    // So before processing the remaining intervals, We need to save this merged interval
    ans.add(newInterval);

    // Add all remaining intervals
    while (i < n) {
      ans.add(intervals[i]);
      i++;
    }
    
    // return the answer as a 2d array
    return ans.toArray(new int[ans.size()][]);
  }
}