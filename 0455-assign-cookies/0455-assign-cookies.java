class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);
        int c = 0;
        int i = 0;
        int count = 0;
        while(c < s.length && i < g.length){
            if(s[c] >= g[i]){
                c++;i++;
                count++;
            }
            else{
                 c++;
            }
        }
        return count;
    }
}