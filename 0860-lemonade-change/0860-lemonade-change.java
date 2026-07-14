class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0; int ten = 0;

        for(int i = 0; i < bills.length; i++){
            if(i == 0 && bills[i] != 5) return false;

            if(bills[i] == 5) five++;
            else if(bills[i] == 10) ten++;
            

            if(bills[i] == 5) continue;

            else if(bills[i] == 10){
                if(five < 1) return false;
                else{
                    five--;
                }
            }
            else{
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }

                else if(five >= 3){
                    five -= 3;;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}