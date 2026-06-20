class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqarr = new int[26];

        int left = 0;
        int maxfreq = 0;
        int ans = 0;
        for(int right = 0; right < s.length(); right++){
            freqarr[s.charAt(right) - 'A']++;

            maxfreq = Math.max(maxfreq, freqarr[s.charAt(right) - 'A']);

            while((right - left + 1) - maxfreq > k){
                freqarr[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}