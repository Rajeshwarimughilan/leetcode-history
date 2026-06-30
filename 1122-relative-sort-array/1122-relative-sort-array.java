class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int idx = 0;
        for(int i = 0; i < arr2.length; i++){
            for(int j = 0; j < arr1.length; j++){
                int t = arr2[i];
                if(arr1[j] == t){
                    int temp = arr1[j];
                    arr1[j] = arr1[idx];
                    arr1[idx] = temp;
                    idx++;
                }
            }
        }
        
        for(int i = idx; i < arr1.length - 1; i++){
            for(int j= idx; j < arr1.length - 1 - i + idx; j++){
                if(arr1[j] > arr1[j+1]){
                    int t = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = t;
                }
            }
        }
        return arr1;
    }

}