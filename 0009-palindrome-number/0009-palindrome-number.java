class Solution {
    public boolean isPalindrome(int x) {
        int check =  x;
        int rev = 0;
        while(x > 0){
            rev = rev * 10 + (x % 10);
            x /= 10;
        }

        if( rev == check) return true;
        else return false;
    }
}