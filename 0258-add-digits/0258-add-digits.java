class Solution {
    public int addDigits(int num) {
        int len = computelen(num);
        while(len > 1){
            int sum = 0;
            while(num > 0){
                int digit = num % 10;
                sum += digit;
                num /= 10;
            }
            num = sum;
            len = computelen(num);
        }
        return num;
    }

    public int computelen(int n){
        int c = 0;
        while(n > 0){
            n /= 10;
            c++;
        }
        return c;
    }
}