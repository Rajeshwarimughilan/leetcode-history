class Solution {
    public int compress(char[] chars) {
        int left = 0;
        int index = 0;
        while(left < chars.length){
            char ch = chars[left];
            int count = 1;

            while(left + 1 < chars.length && ch == chars[left+1]){
                count++;
                left++;
            }
            chars[index++] = ch;
            if(count > 1){
                String str = String.valueOf(count);

                for(char c: str.toCharArray()){
                    chars[index++] = c;
                } 
            }
            left++;
        }
        return index;
    }
}