class Solution {
    public boolean isPowerOfTwo(int n) {
        // if( n < 0) return false;
        // while( n % 2 == 0){
        //     n /= 2;
        // }
        // return n == 1;
        if(n <= 0) return false;
        if((n & (n-1)) == 0) return true;
        else return false;
    }

    //use n & (n-1) == 0 condition
}