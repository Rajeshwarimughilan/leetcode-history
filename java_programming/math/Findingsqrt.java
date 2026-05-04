package math;

class Findingsqrt {
    public static void main(String[] args) {
        System.out.print(findSqrt(5, 3));
    }
    
    public static double findSqrt(int n, int p){
        int start = 0; int end = n;
        double r = 0.0;
        while(start <= end){
            int m = start + (end - start)/2;
            if((m*m) == n) return m;
            else if(m*m < n){
                r = m;
                start = m + 1;
            }
            else end = m - 1;
        }
        double inc = 0.1;
        for(int i = 0; i < p; i++){
            while(r * r < n) r += inc;
            r -= inc;
            inc = inc/10;
        }
        return r;
         
    }
}
