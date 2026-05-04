package sorting;
//Merge sort using recursion not inplace and inplace
import java.util.*;
class Mergesort_both {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 2, 6, 1, 8};
        System.out.println(Arrays.toString(mergesort(arr)));
        mergesortinplace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    
    public static int[] mergesort(int[] arr){
        if(arr.length == 1) return arr;
        
        int mid = arr.length/2;
        
        int[] left =  mergesort(Arrays.copyOfRange(arr, 0, mid));
        int[] right =  mergesort(Arrays.copyOfRange(arr, mid, arr.length));
        
        return merge1(left, right);
    }
    
    public static int[] merge1(int[] left, int[] right){
        int i = 0;int j = 0;int k = 0;
        int[] mix = new int[left.length + right.length];
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                mix[k++] = left[i++];
            }else{
                mix[k++] = right[j++];
            }
        }
        
        while(i < left.length){
            mix[k++] = left[i++];
        }
        
        while(j < right.length){
            mix[k++] = right[j++];
        }
        
        return mix;
    } 
    
    public static void mergesortinplace(int[] arr, int l, int r){
        if(r-l == 1) return;
        
        int mid = l + (r-l)/2;
        
        mergesortinplace(arr, l, mid);
        mergesortinplace(arr, mid, r);
        
        merge2(arr, l, mid, r);
        
    }
    
    public static void merge2(int[] arr, int l, int m, int r){
        int i = l;int j = m;int k = 0;
        int[] mix = new int[r-l];
        while(i < m && j < r){
            if(arr[i] < arr[j]){
                mix[k++] = arr[i++];
            }else{
                mix[k++] = arr[j++];
            }
        }
        
        while(i < m){
            mix[k++] = arr[i++];
        }
        
        while(j < r){
            mix[k++] = arr[j++];
        }
        int b = 0;
        for(int a = l; a < r; a++){
            arr[a] = mix[b++];
        }
    } 
}
