class Solution {
    public int findComplement(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(num % 2);
            num /= 2;
        }
        String bin = sb.reverse().toString();
        int idx = bin.length() - 1;
        int res = 0;
        for(char b : bin.toCharArray()){
            if(b == '0'){
                res += 1 * Math.pow(2, idx);
            }
            idx--;
        }
        return res;
    }
}