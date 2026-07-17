class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[256];

        for(char ch : magazine.toCharArray()){
            arr[ch]++;
        }

        for(char ch : ransomNote.toCharArray()){
            arr[ch]--;
            if(arr[ch] < 0) return false;
        }

        return true;


    }
}