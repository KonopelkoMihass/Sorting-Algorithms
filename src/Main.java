
import java.util.Random;


public class Main {
    // Number of test arrays I decided to use for this project.  They are manually defined in generateUnsortedArrays.
    // For the fairness of the test, I create one set of test arrays, then pass their clones to the algorithms
    final static int NUMBER_OF_TEST_ARRAYS = 25;

    // Number of algorithms developed and used in this project.
    final static int NUMBER_OF_ALGORITHMS = 5;

    // Number of runs done per a sort of single unsorted array by an algorithm.
    final static int NUMBER_OF_RUNS = 10;

    // A maximal range of values generated which are inserted into the unsorted arrays.
    final static int MAX_VALUE_RANGE = 100;


    public static void main( String[] args) {
        double[][] performanceTimesForAllAlgorithms = algorithmTester();
        printResults(performanceTimesForAllAlgorithms);
    }

    // This method runs all algorithms.
    private static double[][] algorithmTester() {
        System.out.println("Preparing components for testing");

        // We have 5 algorithms, and 25 arrays of unsorted data to sort through.
        // Thus, we need to store 25 time results for 5 algorithms.
        // 0. Bubble Sort
        // 1. Selection Sort
        // 2. Insertion Sort
        // 3. Merge Sort
        // 4. Counting Sort
        double[][] performanceTimesForAllAlgorithms = new double[NUMBER_OF_ALGORITHMS][NUMBER_OF_TEST_ARRAYS];

        // Then we create 25 unsorted arrays, which will be cloned for each algorithm to be sorted.
        int[][] unsortedArrays = generateUnsortedArrays();

        // Initialize algorithms
        Algorithms algorithms = new Algorithms();

        // A temp variable which will store average run time.
        double avgRunTime;

        // temp variables for measurement;
        long startTime, endTime, timeElapsed;


        System.out.println("Starting Bubble Sort Test");
        // Iterate 25 times per each array
        for (int i = 0; i < NUMBER_OF_TEST_ARRAYS; i++) {
            avgRunTime = 0;

            // Iterate NUMBER_OF_RUNS times for each array.  Then we add timeElapsed into a variable which is later divided
            // to get an average run time.
            for (int j = 0; j < NUMBER_OF_RUNS; j++) {
                int[] unsortedArrClone = unsortedArrays[i].clone();
                startTime = System.nanoTime();
                algorithms.bubbleSort(unsortedArrClone);
                endTime = System.nanoTime();
                timeElapsed = endTime - startTime;
                avgRunTime += timeElapsed/1000000.0;
            }
            performanceTimesForAllAlgorithms[0][i] = avgRunTime/NUMBER_OF_RUNS;

            // In case if tests take too long, at lest inform user that they are running.
            if ((i+1)%5 == 0) {
                System.out.println((i+1) + "/" + unsortedArrays.length+" tests completed");
            }
        }

        System.out.println("Starting Selection Sort Test");
        for (int i = 0; i < NUMBER_OF_TEST_ARRAYS; i++) {
            avgRunTime = 0;
            for (int j = 0; j < NUMBER_OF_RUNS; j++) {
                int[] unsortedArrClone = unsortedArrays[i].clone();
                startTime = System.nanoTime();
                algorithms.selectionSort(unsortedArrClone);
                endTime = System.nanoTime();
                timeElapsed = endTime - startTime;
                avgRunTime += timeElapsed/1000000.0;
            }
            performanceTimesForAllAlgorithms[1][i] = avgRunTime/NUMBER_OF_RUNS;

            if ((i+1)%5 == 0) {
                System.out.println((i+1) + "/" + unsortedArrays.length+" tests completed");
            }
        }

        System.out.println("Starting Insert Sort Test");
        for (int i = 0; i < NUMBER_OF_TEST_ARRAYS; i++) {
            avgRunTime = 0;
            for (int j = 0; j < NUMBER_OF_RUNS; j++) {
                int[] unsortedArrClone = unsortedArrays[i].clone();
                startTime = System.nanoTime();
                algorithms.insertionSort(unsortedArrClone);
                endTime = System.nanoTime();
                timeElapsed = endTime - startTime;
                avgRunTime += timeElapsed/1000000.0;
            }
            performanceTimesForAllAlgorithms[2][i] = avgRunTime/NUMBER_OF_RUNS;

            if ((i+1)%5 == 0) {
                System.out.println((i+1) + "/" + unsortedArrays.length+" tests completed");
            }
        }

        System.out.println("Starting Merge Sort Test");
        for (int i = 0; i < NUMBER_OF_TEST_ARRAYS; i++) {
            avgRunTime = 0;
            for (int j = 0; j < NUMBER_OF_RUNS; j++) {
                int[] unsortedArrClone = unsortedArrays[i].clone();
                startTime = System.nanoTime();
                algorithms.mergeSort(unsortedArrClone);
                endTime = System.nanoTime();
                timeElapsed = endTime - startTime;
                avgRunTime += timeElapsed/1000000.0;
            }
            performanceTimesForAllAlgorithms[3][i] = avgRunTime/NUMBER_OF_RUNS;

            if ((i+1)%5 == 0) {
                System.out.println((i+1) + "/" + unsortedArrays.length+" tests completed");
            }
        }

        System.out.println("Starting Counting Sort Test");
        for (int i = 0; i < NUMBER_OF_TEST_ARRAYS; i++) {
            avgRunTime = 0;
            for (int j = 0; j < NUMBER_OF_RUNS; j++) {
                int[] unsortedArrClone = unsortedArrays[i].clone();
                startTime = System.nanoTime();
                algorithms.countingSort(unsortedArrClone, MAX_VALUE_RANGE);
                endTime = System.nanoTime();
                timeElapsed = endTime - startTime;
                avgRunTime += timeElapsed/1000000.0;
            }
            performanceTimesForAllAlgorithms[4][i] = avgRunTime/NUMBER_OF_RUNS;

            if ((i+1)%5 == 0) {
                System.out.println((i+1) + "/" + unsortedArrays.length+" tests completed");
            }
        }

        return performanceTimesForAllAlgorithms;
    }

    // This generates a set of 25 unsorted arrays of varied, preset length, with inserted values up to a maxValue.
    private static int[][] generateUnsortedArrays() {
        int[][] arrays = new int[25][];
        arrays[0] = arrayCreator(100);
        arrays[1] = arrayCreator(250);
        arrays[2] = arrayCreator(500);
        arrays[3] = arrayCreator(750);
        arrays[4] = arrayCreator(1000);
        arrays[5] = arrayCreator(1250);
        arrays[6] = arrayCreator(1500);
        arrays[7] = arrayCreator(1750);
        arrays[8] = arrayCreator(2000);
        arrays[9] = arrayCreator(2500);
        arrays[10] = arrayCreator(3000);
        arrays[11] = arrayCreator(3500);
        arrays[12] = arrayCreator(4000);
        arrays[13] = arrayCreator(4500);
        arrays[14] = arrayCreator(5000);
        arrays[15] = arrayCreator(6000);
        arrays[16] = arrayCreator(7000);
        arrays[17] = arrayCreator(8000);
        arrays[18] = arrayCreator(9000);
        arrays[19] = arrayCreator(10000);
        arrays[20] = arrayCreator(12000);
        arrays[21] = arrayCreator(14000);
        arrays[22] = arrayCreator(16000);
        arrays[23] = arrayCreator(18000);
        arrays[24] = arrayCreator(20000);
        return arrays;
    }

    // This method creates an array of specified length, with inserted values up to a maxValue.
    private static int[] arrayCreator (int length) {
        Random rand = new Random();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(MAX_VALUE_RANGE + 1);
        }
        return arr;
    }

    // A long (potentially inefficient) method to print results in a table format.
    private static void printResults (double[][] performanceTimesForAllAlgorithms) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.printf ("%-15s %-7d %-7d %-7d %-7d %-7d %-7d %-7d %-7d %-7d %-7d %-7d %-7d %-7d %-7d %-7d %-7d %-7d " +
                        "%-7d %-7d %-7d %-7d %-7d %-7d %-7d %-7d", "Size", 100, 250, 500, 750, 1000, 1250, 1500,
                1750, 2000,2500,3000,3500,4000,4500,5000,6000,7000,8000,9000,10000,12000,14000,16000,18000,20000);

        System.out.println();
        System.out.printf ("%-15s %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f " +
                        "%-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f",
                "Bubble Sort",
                performanceTimesForAllAlgorithms[0][0],
                performanceTimesForAllAlgorithms[0][1],
                performanceTimesForAllAlgorithms[0][2],
                performanceTimesForAllAlgorithms[0][3],
                performanceTimesForAllAlgorithms[0][4],
                performanceTimesForAllAlgorithms[0][5],
                performanceTimesForAllAlgorithms[0][6],
                performanceTimesForAllAlgorithms[0][7],
                performanceTimesForAllAlgorithms[0][8],
                performanceTimesForAllAlgorithms[0][9],
                performanceTimesForAllAlgorithms[0][10],
                performanceTimesForAllAlgorithms[0][11],
                performanceTimesForAllAlgorithms[0][12],
                performanceTimesForAllAlgorithms[0][13],
                performanceTimesForAllAlgorithms[0][14],
                performanceTimesForAllAlgorithms[0][15],
                performanceTimesForAllAlgorithms[0][16],
                performanceTimesForAllAlgorithms[0][17],
                performanceTimesForAllAlgorithms[0][18],
                performanceTimesForAllAlgorithms[0][19],
                performanceTimesForAllAlgorithms[0][20],
                performanceTimesForAllAlgorithms[0][21],
                performanceTimesForAllAlgorithms[0][22],
                performanceTimesForAllAlgorithms[0][23],
                performanceTimesForAllAlgorithms[0][24]);

        System.out.println();
        System.out.printf ("%-15s %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f " +
                        "%-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f",
                "Selection Sort",
                performanceTimesForAllAlgorithms[1][0],
                performanceTimesForAllAlgorithms[1][1],
                performanceTimesForAllAlgorithms[1][2],
                performanceTimesForAllAlgorithms[1][3],
                performanceTimesForAllAlgorithms[1][4],
                performanceTimesForAllAlgorithms[1][5],
                performanceTimesForAllAlgorithms[1][6],
                performanceTimesForAllAlgorithms[1][7],
                performanceTimesForAllAlgorithms[1][8],
                performanceTimesForAllAlgorithms[1][9],
                performanceTimesForAllAlgorithms[1][10],
                performanceTimesForAllAlgorithms[1][11],
                performanceTimesForAllAlgorithms[1][12],
                performanceTimesForAllAlgorithms[1][13],
                performanceTimesForAllAlgorithms[1][14],
                performanceTimesForAllAlgorithms[1][15],
                performanceTimesForAllAlgorithms[1][16],
                performanceTimesForAllAlgorithms[1][17],
                performanceTimesForAllAlgorithms[1][18],
                performanceTimesForAllAlgorithms[1][19],
                performanceTimesForAllAlgorithms[1][20],
                performanceTimesForAllAlgorithms[1][21],
                performanceTimesForAllAlgorithms[1][22],
                performanceTimesForAllAlgorithms[1][23],
                performanceTimesForAllAlgorithms[1][24]);

        System.out.println();
        System.out.printf ("%-15s %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f " +
                        "%-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f",
                "Insert Sort",
                performanceTimesForAllAlgorithms[2][0],
                performanceTimesForAllAlgorithms[2][1],
                performanceTimesForAllAlgorithms[2][2],
                performanceTimesForAllAlgorithms[2][3],
                performanceTimesForAllAlgorithms[2][4],
                performanceTimesForAllAlgorithms[2][5],
                performanceTimesForAllAlgorithms[2][6],
                performanceTimesForAllAlgorithms[2][7],
                performanceTimesForAllAlgorithms[2][8],
                performanceTimesForAllAlgorithms[2][9],
                performanceTimesForAllAlgorithms[2][10],
                performanceTimesForAllAlgorithms[2][11],
                performanceTimesForAllAlgorithms[2][12],
                performanceTimesForAllAlgorithms[2][13],
                performanceTimesForAllAlgorithms[2][14],
                performanceTimesForAllAlgorithms[2][15],
                performanceTimesForAllAlgorithms[2][16],
                performanceTimesForAllAlgorithms[2][17],
                performanceTimesForAllAlgorithms[2][18],
                performanceTimesForAllAlgorithms[2][19],
                performanceTimesForAllAlgorithms[2][20],
                performanceTimesForAllAlgorithms[2][21],
                performanceTimesForAllAlgorithms[2][22],
                performanceTimesForAllAlgorithms[2][23],
                performanceTimesForAllAlgorithms[2][24]);

        System.out.println();
        System.out.printf ("%-15s %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f " +
                        "%-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f",
                "Merge Sort",
                performanceTimesForAllAlgorithms[3][0],
                performanceTimesForAllAlgorithms[3][1],
                performanceTimesForAllAlgorithms[3][2],
                performanceTimesForAllAlgorithms[3][3],
                performanceTimesForAllAlgorithms[3][4],
                performanceTimesForAllAlgorithms[3][5],
                performanceTimesForAllAlgorithms[3][6],
                performanceTimesForAllAlgorithms[3][7],
                performanceTimesForAllAlgorithms[3][8],
                performanceTimesForAllAlgorithms[3][9],
                performanceTimesForAllAlgorithms[3][10],
                performanceTimesForAllAlgorithms[3][11],
                performanceTimesForAllAlgorithms[3][12],
                performanceTimesForAllAlgorithms[3][13],
                performanceTimesForAllAlgorithms[3][14],
                performanceTimesForAllAlgorithms[3][15],
                performanceTimesForAllAlgorithms[3][16],
                performanceTimesForAllAlgorithms[3][17],
                performanceTimesForAllAlgorithms[3][18],
                performanceTimesForAllAlgorithms[3][19],
                performanceTimesForAllAlgorithms[3][20],
                performanceTimesForAllAlgorithms[3][21],
                performanceTimesForAllAlgorithms[3][22],
                performanceTimesForAllAlgorithms[3][23],
                performanceTimesForAllAlgorithms[3][24]);

        System.out.println();
        System.out.printf ("%-15s %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f " +
                        "%-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f %-7.3f",
                "Counting Sort",
                performanceTimesForAllAlgorithms[4][0],
                performanceTimesForAllAlgorithms[4][1],
                performanceTimesForAllAlgorithms[4][2],
                performanceTimesForAllAlgorithms[4][3],
                performanceTimesForAllAlgorithms[4][4],
                performanceTimesForAllAlgorithms[4][5],
                performanceTimesForAllAlgorithms[4][6],
                performanceTimesForAllAlgorithms[4][7],
                performanceTimesForAllAlgorithms[4][8],
                performanceTimesForAllAlgorithms[4][9],
                performanceTimesForAllAlgorithms[4][10],
                performanceTimesForAllAlgorithms[4][11],
                performanceTimesForAllAlgorithms[4][12],
                performanceTimesForAllAlgorithms[4][13],
                performanceTimesForAllAlgorithms[4][14],
                performanceTimesForAllAlgorithms[4][15],
                performanceTimesForAllAlgorithms[4][16],
                performanceTimesForAllAlgorithms[4][17],
                performanceTimesForAllAlgorithms[4][18],
                performanceTimesForAllAlgorithms[4][19],
                performanceTimesForAllAlgorithms[4][20],
                performanceTimesForAllAlgorithms[4][21],
                performanceTimesForAllAlgorithms[4][22],
                performanceTimesForAllAlgorithms[4][23],
                performanceTimesForAllAlgorithms[4][24]);

    }
}