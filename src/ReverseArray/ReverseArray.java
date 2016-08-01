package ReverseArray;

/**
 * Created by namrataojha on 6/11/16.
 *
 */
public class ReverseArray {
    /* Function to reverse arr[] from start to end*/
    static void rvereseArray(int arr[], int start, int end) {
        // using recursive function to swap the elements
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        rvereseArray(arr, start + 1, end - 1);
    }

    /*  prints out an array on a line */
    static void print(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        print(arr, 6);
        rvereseArray(arr, 0, 5);
        System.out.println("Reversed array is ");
        print(arr, 6);
    }
}


