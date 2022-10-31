package com.epam.mjc.stage0;


/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"Winter", "Spring", "Summer", "Autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] generatedArr = new int[length];
        for (int i = 1; i <= length; i++) {
            generatedArr[i - 1] = i;
        }
        return generatedArr;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) return i;
        }
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] reversedArr = new String[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            reversedArr[arr.length - i - 1] = arr[i];
        }
        return reversedArr;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int positiveCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) positiveCount++;
        }
        int[] positiveArr = new int[positiveCount];
        int positiveIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positiveArr[positiveIndex] = arr[i];
                positiveIndex++;
            }
        }
        return positiveArr;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public static int[][] sortRaggedArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            quickSort(arr[i], 0, arr[i].length - 1);
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);

            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int wall = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                wall++;
                swap(arr, i, wall);
            }
        }
        swap(arr, end, wall + 1);
        return (wall + 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void quickSort(int[][] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);

            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[][] arr, int start, int end) {
        int[] pivot = arr[end];
        int wall = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i].length < pivot.length) {
                wall++;
                swap(arr, i, wall);
            }
        }
        swap(arr, end, wall + 1);
        return (wall + 1);
    }

    private static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[][] arrTest = new int[][]{new int[]{2, 1}, new int[]{3}, new int[]{1, 6, 3}, new int[] {5, 6}};
//        sortRaggedArray(arrTest);
//        System.out.println(Arrays.deepToString(arrTest));
    }

}
