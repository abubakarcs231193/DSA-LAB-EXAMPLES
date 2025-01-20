public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0, 11, 0, 20, 44, 0, 3};
        int position = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[position ] = arr[i];
                if (position  != i) {
                    arr[i] = 0;
                }
                position ++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
