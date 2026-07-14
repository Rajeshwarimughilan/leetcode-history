class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < bills.length; i++){
            if(i == 0 && bills[i] != 5) return false;

            map.put(bills[i] , map.getOrDefault(bills[i], 0) + 1);

            if(bills[i] == 5) continue;
            else if(bills[i] == 10){
                if(map.getOrDefault(5, 0) < 1) return false;
                else{
                    map.put(5, map.get(5) - 1);
                }
            }
            else{
                if(map.getOrDefault(5, 0) > 0 && map.getOrDefault(10, 0) > 0){
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) - 1);
                }

                else if(map.getOrDefault(5, 0) >= 3){
                    map.put(5, map.get(5) - 3);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}