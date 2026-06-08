class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            ans <<= 1; //make space
            ans |= (n & 1); //add last digit 
            // n /= 2; this works nly for positive number
            n >>>= 1; //will work for both positive nad negative
        }
        return ans;
    }
}