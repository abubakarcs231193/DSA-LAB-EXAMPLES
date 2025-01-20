public class ResizeArray {
    public static void main(String[] args) {
        int[] arr = {11, 32, 53, 64, 65};
        int newSize = 7;

        int[] newArr = new int[newSize];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
