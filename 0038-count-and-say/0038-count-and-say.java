class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1"); 
        return reccurance(n, sb).toString();
    }

    public StringBuilder reccurance(int n, StringBuilder sb){
        if(n == 1){
            return sb;
        }
        int c = 1;
        StringBuilder temp = new StringBuilder("");
        for(int i = 1; i < sb.length(); i++){
            if(sb.charAt(i) != sb.charAt(i-1)){
                temp.append(c);
                temp.append(sb.charAt(i-1));
                c = 1;
            }else{
                c++;
            }
        }
        temp.append(c);
        temp.append(sb.charAt(sb.length()-1));
        return reccurance(n-1, temp);
    }
}