
package sieve;
class SieveOfEratosthenes {
    public static void main(String[] args) {
        seive(50);
    }
    
    public static void seive(int n){
        
        boolean[] temp = new boolean[n+1];
        for(int i = 2; i*i <= n; i++){
            if(!temp[i]){
                for(int j = i*2; j <= n; j += i){
                    temp[j] = true;
                }
            }
        }
        
        for(int k = 2; k <= n; k++){
            if(!temp[k]) System.out.print(k + " ");
        }
    }
}

//timecomplexity :  n * log(logn)
