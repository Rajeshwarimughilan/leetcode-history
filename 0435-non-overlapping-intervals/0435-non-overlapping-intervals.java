class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      // we consider ending time based sorting cause we need to find the maximum number of non overlapping intervals.
      Arrays.sort(intervals, (a,b) -> Integer.compare(a[1] , b[1]));

      int prev = intervals[0][1];
      int count = 0;

      for(int i = 1; i < intervals.length; i++){
        int[] curr = intervals[i];
        if(prev > curr[0]){
            count++;
        }
        else{
            prev = curr[1];
        }
      }
      return count;  
    }
}