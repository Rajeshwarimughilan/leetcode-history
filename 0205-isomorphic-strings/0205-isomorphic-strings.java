class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character>  ST = new HashMap<>();
        HashMap<Character, Character>  TS = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(ST.containsKey(ch1)){
                if(ST.get(ch1) != ch2) return false;
            }
            else{
                ST.put(ch1, ch2);
            }

            if(TS.containsKey(ch2)){
                if(TS.get(ch2) != ch1) return false;
            }
            else{
                TS.put(ch2, ch1);
            }
        }
        return true;
    }
}