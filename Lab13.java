package lab13;

public class Lab13 {
    public static void main(String[] args) {
        BubbleSort.sortAndDisplay();
    }
}

class BubbleSort {
    public static void sortAndDisplay() {
        int n = 5;
        int[] arr = {67, 44, 82, 17, 20}; // Initialize an array

        System.out.print("Array before Sorting: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            int swaps = 0; // Flag to detect if any swap occurs
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // When the current item is bigger than the next
                    // Swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps = 1; // Set swap flag
                }
            }
            if (swaps == 0) // If no swaps occurred, array is already sorted
                break;
        }

        System.out.print("Array After Sorting: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
