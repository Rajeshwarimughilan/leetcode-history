class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i = 1; i <= n; i++){
            res[i] = compute(i);
        }
        return res;
    }
    
    public int compute(int x){
        int c = 0;
        while(x > 0){
            if(x % 2 == 1) c++;
            x /= 2;
        }
        if( x == 1) c++;

        return c;
    }
}