package prime;
class PrimeInRange {
    public static void main(String[] args) {
        
        for(int i = 2; i < 40; i++){
            if(isprime(i)) System.out.print(i + " ");
        }
    }
    
    public static boolean isprime(int n){
        int c = 2;
        while(c * c <= n){
            if(n % c == 0) return false;
            c++;
        }
        return true;
    }
}

