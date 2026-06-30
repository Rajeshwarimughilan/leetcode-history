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
        
        Arrays.sort(arr1, idx, arr1.length);

        return arr1;
    }
}