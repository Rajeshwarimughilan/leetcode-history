package recursion;
import java.util.*;


class Bubble_selection_recursion {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 3};
        System.out.println(Arrays.toString(bubble(arr, 0, arr.length)));
        System.out.println(Arrays.toString(selection(arr, 0, arr.length, 0)));
    }
    
    public static int[] bubble(int[] arr, int s, int e){
        if(e == 1) return arr;
        if(s < e - 1){
            if(arr[s] > arr[s+1]){
                swap(arr, s, s+1);
            }
            return bubble(arr, s+1, e);
        }
        return bubble(arr, 0, e-1);
    }
    
    
    public static int[] selection(int[] arr, int s, int e, int m){
        if(e == 0) return arr;
        if(s < e){
            if(arr[s] > arr[m]){
                return selection(arr, s+1, e, s);
            }else{
                return selection(arr, s+1, e, m);
            }
        }
        swap(arr, m, e-1);
        return selection(arr, 0, e-1, 0);
    }
    
    
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
