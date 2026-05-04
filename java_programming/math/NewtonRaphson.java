package math;
class NewtonRaphson {
    public static void main(String[] args) {
        System.out.println(NewtonRaphson(9));
    }
    
    public static double NewtonRaphson(int n){
        double x = n;
        double root;
        
        while(true){
            root = 0.5 * (x + (n/x));
            if(Math.abs(root - x) < 0.0001) break;
            x = root;
        }
        return x;
    }
}
