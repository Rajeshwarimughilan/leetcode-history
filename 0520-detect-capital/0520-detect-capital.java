class Solution {
    public boolean detectCapitalUse(String word) {
        if(((word.charAt(0) >= 65 && word.charAt(0) <= 90) && islower(word, 1)) ||
        islower(word, 0) || 
        isupper(word)
        ) return true;
        return false;
    }
    public static boolean islower(String s, int start){
        for(int i = start; i < s.length(); i++){
            if(s.charAt(i) < 95 || s.charAt(i) > 122) return false;
        }
        return true;
    }

    public static boolean isupper(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < 65 || s.charAt(i) > 90) return false;
        }
        return true;
    }
}