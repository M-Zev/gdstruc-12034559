import java.util.Arrays;

public class quiz1 {
    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int x = 0; x < n - i - 1; x++) {
                if (arr[x] < arr[x + 1]) { // Swap if the element is smaller than the next
                    int temp = arr[x];
                    arr[x] = arr[x + 1];
                    arr[x + 1] = temp;
                }
            }
        }
    }

    public static void selectionSortModified(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int x = i + 1; x < n; x++) {
                if (arr[x] < arr[minIdx]) {
                    minIdx = x;
                }
            }

            // unsorted edge
            int temp = arr[minIdx];
            arr[minIdx] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] bubbleArr = {51, 12, 39, 11, 45, 69};
        int[] selectionArr = {57, 23, 98, 21, 25, 16};

        System.out.println("Bubble Sort Initial Array: " + Arrays.toString(bubbleArr));
        System.out.println("Selection Sort Initial Array: " + Arrays.toString(selectionArr));

        bubbleSortDescending(bubbleArr);
        System.out.println("Bubble Sort Descending: " + Arrays.toString(bubbleArr));

        selectionSortModified(selectionArr);
        System.out.println("Selection Sort Modified: " + Arrays.toString(selectionArr));
    }
}
