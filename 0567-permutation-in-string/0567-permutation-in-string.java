class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;
        int k = s1.length();
        char[] want = new char[26];
        char[] window = new char[26];

        for(char c  : s1.toCharArray()){
            want[c - 'a']++;
        }

        for(int i = 0; i < k; i++){
            window[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(want, window)) return true;

        for(int i = k; i < s2.length(); i++){
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i - k) - 'a']--;

            if(Arrays.equals(want, window)){
                return true;
            }
        }
        return false;
    }
}