class Solution {
    public int countSegments(String s) {
        if(s.equals("")) return 0;
        int i = s.length() - 1;
        int res = 0;

        while(i >= 0){
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }

            if(i < 0){
                break;
            }

            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            
            
            res += 1;
        }
        return res;
    }
}