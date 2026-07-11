class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxfreq = 1;
        int count = 0;
        for(int i : tasks){
            map.put(i, map.getOrDefault(i, 0) + 1);
            maxfreq = Math.max(maxfreq, map.get(i));
        }

        for(int x : map.values()){
            if(x == maxfreq) count++;
        }

        int res = (maxfreq - 1) * (n + 1) + count;
        
        if( res < tasks.length){
            return tasks.length;
        }
        return res;
    }
}