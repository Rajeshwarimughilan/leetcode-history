class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int count = t.length();
        int start = 0;
        int minlen = Integer.MAX_VALUE;
        int[] freq = new int[128];
       
        for(char c : t.toCharArray()){
            freq[c]++;
        }
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(freq[ch] > 0) count -= 1;
            freq[ch]--;

            while(count == 0){
                if(right - left + 1 < minlen){
                    minlen = right - left + 1;
                    start = left;
                }
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)] > 0) count++;
                left++;
                 
            }

        } 

       return minlen == Integer.MAX_VALUE ?  "" : s.substring(start, start + minlen);
    }
}