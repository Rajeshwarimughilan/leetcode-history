package arrays;
import java.util.*;
// Check if an array is sorted

public class CheckSortedArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i  < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(helper(arr, n));
    }
    
    public static boolean helper(int[] arr,int n){
        for(int i = 1; i < n; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
        
    }
}
