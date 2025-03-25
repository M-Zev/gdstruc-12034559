import java.util.Arrays;
import java.util.Random;

public class GotALotOfTimeAlgorithm {

    public static double getCurrentTime() {
        return System.currentTimeMillis() / 1000.0;  // Current time in seconds
    }

    public static void shiftDown(int[] array, int index) {
        if (index + 1 < array.length) {  // Ensure within bounds
            int temp = array[index];
            array[index] = array[index + 1];
            array[index + 1] = temp;
        }
    }

    public static void shiftUp(int[] array, int index) {
        if (index - 1 >= 0) {  // Ensure within bounds
            int temp = array[index];
            array[index] = array[index - 1];
            array[index - 1] = temp;
        }
    }

    public static void printRandomMessage() {
        String[] messages = {
                "Still sorting... Hope you brought snacks!",
                "Don't worry, the algorithm knows what it's doing. Probably.",
                "Sorting... or is it philosophizing about the nature of time?"
        };
        Random random = new Random();
        System.out.println(messages[random.nextInt(messages.length)]);
    }

    public static void chronoSort(int[] array) {
        boolean isSorted = false;
        double nextPrintTime = getCurrentTime() + 30; // First message after 30 seconds
        int exponent = 1; // Exponential growth factor

        while (!isSorted) {
            isSorted = true;
            double currentTime = getCurrentTime();

            if (currentTime >= nextPrintTime) {
                printRandomMessage();
                nextPrintTime = currentTime + Math.pow(2, exponent) * 30; //Double the wait time exponentially
                exponent++;
            }

            for (int i = 0; i < array.length; i++) {
                if (array[i] > currentTime) {
                    shiftDown(array, i);
                    isSorted = false;
                } else {
                    shiftUp(array, i);
                    isSorted = false;
                }
                currentTime = getCurrentTime();
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 12, 3, 7, 9};
        System.out.println("Original Array: " + Arrays.toString(numbers));
        chronoSort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }
}
