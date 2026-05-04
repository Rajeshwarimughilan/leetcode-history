package reversal;
class ReversalMethods {
    public static void main(String[] args) {

        rev1(1234);

        rev2(1234);
        System.out.println(sum2);

        System.out.println(rev3(1234));
    }

    // -------- Iterative --------
    public static void rev1(int n){
        int sum1 = 0;

        while(n > 0){
            int rem = n % 10;
            sum1 = sum1 * 10 + rem;
            n = n / 10;
        }
        System.out.println(sum1);
    }

    // -------- Recursion with global --------
    static int sum2 = 0;

    public static void rev2(int n){
        if(n == 0) return;

        int rem = n % 10;
        sum2 = sum2 * 10 + rem;

        rev2(n/10);
    }

    // -------- Pure recursion --------
    public static int rev3(int n){
        int digit = (int)Math.log10(n) + 1;
        return rev3helper(n, digit);
    }

    public static int rev3helper(int n, int digit){

        if(n == 0)
            return 0;

        int rem = n % 10;

        return (int)(rem * Math.pow(10, digit - 1))
                + rev3helper(n/10, digit - 1);
    }
}
