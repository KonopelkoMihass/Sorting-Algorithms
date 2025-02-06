import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Algorithms {
    public Algorithms(){
        
    }

    // Implementation by Dominic Carr in Week 9 slides at ATU Galway
    // (at https://vlegalwaymayo.atu.ie/mod/resource/view.php?id=884535)
    public void bubbleSort(int[] arr) {
        boolean swapped = false;
        int length = arr.length;    // To reduce accessing variable within array, I placed it into a variable.
        int temp = 0;               // Will store a moved value

        // Using the do-while loop, we ensure that this loop will run fully at least once before checking for swapped var.
        // link (https://www.digitalocean.com/community/tutorials/java-do-while-loop)
        do {
            // State that there was no swap.  If after the loop it remains false, it implies that the array is sorted
            // and that program can exit the while loop
            swapped = false;

            // Iterate through the array from index 1 so that the value can be compared to the value in previous index (at 0)
            // Furthermore it simplifies handling of the end of array.
            for (int i = 1; i < length; i++) {
                // Compare previous element (i-1) to the currently iterated one (i). If previous element is
                // bigger than the current one, we swap them.  The operation is marked by setting swapped to true.
                if (arr[i-1] > arr[i]) {
                    temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;

                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Based on implementation by Dominic Carr in Week 9 slides at ATU Galway
    // (at https://vlegalwaymayo.atu.ie/mod/resource/view.php?id=884535)
    public void selectionSort(int[] arr) {
        int length = arr.length;    // To reduce accessing variable within array, I placed it into a variable.
        int minIndex;               // This variable will store index to an array element with a smallest value.
        int temp;                   // Will store a moved value

        // We iterate through the array.
        for (int i = 0; i < length; i++) {
            // Here we set a minIndex to equate to a current i.
            minIndex = i;
            // In this for loop we iterate through elements after i till the end of array.  We try to find an element with
            // the lowest value and store its index (j) into th minIndex.
            for (int j = i+1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Afterward, we swap the values in array elements.
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Based on implementation by Dominic Carr in Week 9 slides at ATU Galway
    // (at https://vlegalwaymayo.atu.ie/mod/resource/view.php?id=884535)
    public void insertionSort(int[] arr) {
        int length = arr.length;    // To reduce accessing variable within array, I placed it into a variable.
        int toSort = 1;             // This variable tracks the next index after sorted part of array.
        int temp = 0;               // Will store a moved value
        int itterator;              // Will be going backward to identify a spot where to move a value from toSort cell.

        // Repeat while sorted part is less than overall array length.
        for ( ; toSort < length;  toSort++) {
            // Set iterator to the position of an array cell to sort
            itterator = toSort;
            // Go backwards and continuously shift array element indexes by 1.  Loop will stop when the previous
            // element at (iterator - 1) is greater than the element at the (iterator) position.
            while (itterator > 0 && ( arr[itterator-1] > arr[itterator] )) {
                temp = arr[itterator];
                arr[itterator] = arr[itterator-1];
                arr[itterator-1] = temp;
                itterator--;
            }
        }

    }

    // Following resources were referenced when implementing this algorithm:
    // https://www.baeldung.com/java-merge-sort
    // https://www.javatpoint.com/merge-sort
    // https://javachallengers.com/merge-sort-with-java/
    public void mergeSort(int[] arr) {
        int length = arr.length;    // To reduce accessing variable within array, I placed it into a variable.

        // In the situation where there are no elements to sort, we escape this function
        // (and terminate this layer of recursion)
        if (length < 2) {
            return;
        }

        int midPoint = length/2;    // The mid-point of the array, which will be used to split arr int two

        // Prepare two halves for the passed array arr.
        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[length - midPoint];

        // Splitting array into the parts
        leftArray = Arrays.copyOfRange(arr, 0, midPoint);
        rightArray = Arrays.copyOfRange(arr, midPoint, length);

        // Proceed to further sort and divide the array via recursion.  The recursion will seize when the array size
        // is less than 2 elements (the "divide" step)
        mergeSort(leftArray);
        mergeSort(rightArray);

        // Then we proceed to merge the sub-arrays into a single array arr (the "conquer" part)
        merge( leftArray, rightArray, arr);
    }

    private void merge(int[] leftArray,int[] rightArray, int[] mergedArr) {
        int iLeft = 0, iRight = 0, iMerged = 0;     // Iterators for the three passed arrays.

        // We iterate through both sub-arrays simultaneously, and insert a smallest value into the mergedArray.
        // The process continuous while one of the iterators does not reach the end of its array (in case if sub-arrays
        // are asymmetrical).
        while (iLeft < leftArray.length && iRight < rightArray.length) {
            if (leftArray[iLeft] <= rightArray[iRight]) {
                mergedArr[iMerged++] = leftArray[iLeft++];
            } else {
                mergedArr[iMerged++] = rightArray[iRight++];
            }
        }

        // This inserts the remaining elements into the mergedArray.
        while (iLeft < leftArray.length) {
            mergedArr[iMerged++] = leftArray[iLeft++];
        }
        while (iRight < rightArray.length) {
            mergedArr[iMerged++] = rightArray[iRight++];
        }
    }



    // Following resources were referenced when implementing this algorithm:
    // https://www.baeldung.com/java-counting-sort
    // https://www.javatpoint.com/counting-sort
    // https://www.w3schools.com/dsa/dsa_algo_countingsort.php
    //
    // In order for counting sort to work, it is desired to know the range of values this sort can encounter in the array.
    // Thus, a parameter for maximum values is provided.
    public int[] countingSort(int[] arr, int maxValue) {
        int length = arr.length;    // To reduce accessing variable within array, I placed it into a variable.
        int countArrLength = (maxValue+1);  // This accounts for storing element between 0 to max value e.g. from 0 to 100

        // Create and initialize an array which will store occurrences of each value in array arr.
        // Also have one extra slot to account for the maxValue itself.
        int[] countArr = new int[countArrLength];

        // Set each element in counting array to 0.
        Arrays.fill(countArr, 0);

        // While iterating through array arr, we take the value within arr and use it as an index in countArr.
        // The value at that index is then incremented by 1.
        for (int value : arr) {
            countArr[value] += 1;
        }

        // In this loop a count array is transformed into a mapping array for the location of variables.
        // Index i is one of the values in array arr, and countArr[i] will now store the location the last index
        // of the value in the sorted array.  That last index will be used to insert the sorted value in a reverse order!
        for (int i = 1; i < countArrLength; i++) {
            countArr[i] += countArr[i - 1];
        }

        // Prepare an array to store sorted values.
        int[] sortedArray = new int[length];

        int current;  // Will store the value from array arr.

        // Iterate in reverse order from the last element.  Then use value stored in original array as an index in
        // countArr to access a location within an array to be sorted.
        for (int i = length - 1; i >= 0; i--) {
            current = arr[i];
            sortedArray[countArr[current] - 1] = current;
            countArr[current] -= 1;  // decrement the value, which is a position for the next instance of the value "current"
        }
        return sortedArray;
    }
}