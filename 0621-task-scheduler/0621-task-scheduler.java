class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxfreq = 0;
        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxfreq = Math.max(map.get(ch), maxfreq);
        }
        int maxcount = 0;
        for(int val : map.values()){
            if(val == maxfreq) maxcount++;
        }

        int computed = (maxfreq - 1) * (n + 1) + maxcount;
        
       return Math.max(tasks.length, computed);

    }
}