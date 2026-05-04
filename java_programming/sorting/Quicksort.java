package sorting;
import java.util.*;
//Quicksort 


class Quicksort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,7, 3, 6, 9, 2};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void quicksort(int[] arr, int low, int high){
        
        if(low >= high) return;
        
        int start = low; int end = high;
        int mid = low + (high - low)/2;
        int pivot = arr[mid];
        while(start <= end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end){
                int temp = arr[start];arr[start] = arr[end]; arr[end] = temp;
                start++; end--;
            } 
        }
        quicksort(arr, low, end);
        quicksort(arr, start, high);
    }
}
