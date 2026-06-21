class Solution {
    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        // String binaryStr = Integer.toString(number, 2);
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