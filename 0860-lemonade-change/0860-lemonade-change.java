class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0] != 5) return false;;
        
        HashMap<Integer, Integer> map = new HashMap<>();


        for(int i = 0; i < bills.length; i++){
            int rupee = bills[i];
            map.put(rupee, map.getOrDefault(rupee, 0) + 1);
            if(rupee == 10){
                //check 5 rupee - 1
                if(map.getOrDefault(5, 0) >= 1){
                    map.put(5, map.get(5) - 1);
                    if(map.get(5) == 0) map.remove(5);
                }
                else{
                    return false;
                }
            }
            else if(rupee == 20){
                // check 3- 5 rupee or 1-ten rupee and 1- 5 rupee
                if(map.getOrDefault(10, 0) >= 1 && map.getOrDefault(5, 0) >= 1){
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                    if(map.get(5) == 0) map.remove(5);
                    if(map.get(10) == 0) map.remove(10);
                }
                else if(map.getOrDefault(5, 0) >= 3){
                    map.put(5, map.get(5) - 3);
                    if(map.get(5) == 0) map.remove(5);
                }
                else{
                    return false;
                }

            }
        }
        return true;
    }
}