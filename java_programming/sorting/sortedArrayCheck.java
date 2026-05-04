// Check if array is sorted or not.
package sorting;
class sortedArrayCheck {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2, 3, 4};
        System.out.println(checkSorted1(arr));
        System.out.println(checkSorted2(arr));
    }
    
    public static boolean checkSorted1(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(i > 0 && arr[i-1] > arr[i]) return false;
        }
        return true;
    }
    
    public static boolean checkSorted2(int[] arr){
        return helper(arr, 0);
    }
    
    static boolean helper(int[] arr, int idx){
        if(idx == arr.length - 1) return true;
        return (arr[idx] < arr[idx + 1] && helper(arr, idx + 1));
    }
}
