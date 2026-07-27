class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < chars.length){
            int count = 1;
            int j = i;
            while(j < chars.length - 1 && chars[j] == chars[j+1]){
                count++;
                j++;
            }
            sb.append(chars[i]);
            if(count != 1){
                sb.append(count);
            }

            i = j + 1;

        }

        for (int k = 0; k < sb.length(); k++) {
            chars[k] = sb.charAt(k);
        }

        
        return sb.length();
    }
}