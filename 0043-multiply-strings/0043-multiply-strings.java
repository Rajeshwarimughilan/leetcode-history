class Solution {
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num2.length() - 1; i >= 0; i--){
            int n2 = num2.charAt(i) - '0';
            for(int j = num1.length() - 1; j >= 0; j--){
                int n1 = num1.charAt(j) -'0';
                int pos1 = i + j;
                int pos2 = i + j + 1;
                int product = n1*n2;
                int sum = product + res[pos2];
                
                res[pos2] = sum % 10;
                res[pos1] += sum / 10; 
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : res){
            if(!(sb.length() == 0 && num == 0)){
                sb.append(num);
            }
        }
        return sb.toString();
    }
}