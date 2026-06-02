class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num.length(); i++){
            while(!stack.isEmpty() && k > 0 && num.charAt(i) < stack.peek()){
               stack.pop();
               k--; 
            }
            stack.push(num.charAt(i));
        }

        while(k > 0){
            stack.pop();
            k--;
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        sb.reverse();

        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        if(sb.toString().equals("")){
            return "0";
        } 
        else{
            return sb.toString();
        } 
    }
}