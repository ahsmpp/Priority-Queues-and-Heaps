import java.util.*;

public class MaxHeapCheck {
    public static boolean  isHeap(int[] arr,  int n) {
        //Check if the array element is less than it's child element in the array,
        //and if they are less return false else return true
        boolean check = false;
        for(int i = 0; i < n; i++) {
            if((2 * i) + 1 < n) {
                if(arr[i] < arr[(2 * i) + 1]) {
                    return check;
                }
            }
            if((2 * i) + 2 < n) {
                if(arr[i] < arr[(2 * i) + 2]) {
                    return check;
                }
            }
        }
        check = true;
        return check;
    }

    public static int[] getArrayInput(int size, Scanner scanner) {
       int array[] = new int[size];
       for (int i = 0; i < size; i++) {
           array[i] = scanner.nextInt();
       }
       return array;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeArray1 = scanner.nextInt();
        //int arr[] = {99,33,87,24,19,56,84,11,9,17,14,42,51,77,71,2,4,3};
        int arr[] = getArrayInput(sizeArray1, scanner);
	int n = arr.length;
	String x = isHeap(arr, n)? "Yes": "No";
 
	System.out.println(x);
    }
}