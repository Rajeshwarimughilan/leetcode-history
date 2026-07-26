class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);
        int left = 0;
        int c = 0;
        int count = 0;

        while(left < g.length && c < s.length){
            if(g[left] <= s[c]){
                left++;
                count++;
                c++;
                
            }
            else{
                c++;
            }
        }
        return count; 
    }
}