class Solution {
    public int titleToNumber(String columnTitle) {

        int power = 0;
        int ans = 0;
        for(int i = columnTitle.length()- 1; i>= 0; i--){
            ans += Math.pow(26, power) * (columnTitle.charAt(i) - 64);
            power++;
        }
        return ans;
    }
}