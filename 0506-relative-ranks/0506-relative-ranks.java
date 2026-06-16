class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, String> map = new HashMap<>();
        String[] res = new String[score.length];
        int[] s = Arrays.copyOf(score, score.length);
        for(int i = 0; i < s.length - 1; i++){
            for(int j = 0; j < s.length - i - 1; j++){
                if(s[j] < s[j+1]){
                    int temp = s[j]; s[j] = s[j+1]; s[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < s.length; i++){
            if(i == 0) map.put(s[i], "Gold Medal");
            else if(i == 1) map.put(s[i], "Silver Medal");
            else if(i == 2) map.put(s[i], "Bronze Medal");
            else map.put(s[i], String.valueOf(i + 1));
        }

        for(int i = 0; i < score.length; i++){
            res[i] = map.get(score[i]);
        }
        return res;



    }
}