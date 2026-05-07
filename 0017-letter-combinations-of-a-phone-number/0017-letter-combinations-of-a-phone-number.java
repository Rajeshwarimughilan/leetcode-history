class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] map = {"", "", "abc", "def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        subsethelper(digits, res, "", map);
        return res;
    }

    static void subsethelper(String up, List<String> res, String p, String[] map){
        if(up.isEmpty()){
            res.add(p);
            return;
        }
        int idx = up.charAt(0) - '0';
        String letters = map[idx];

        for(int i = 0; i < letters.length(); i++){
            char ch = letters.charAt(i);
            subsethelper(up.substring(1), res, p+ch, map);
        }

        
    }


}