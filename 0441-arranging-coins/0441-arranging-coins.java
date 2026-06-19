class Solution {
    public int arrangeCoins(int n) {
        List<Integer> arr = new ArrayList<>();
        int i  = 1;
        while(n > 0){
            arr.add(i);
            n -= i;
            i++;
        }
        return n == 0 ? arr.size() : arr.size() - 1;  
    }
}