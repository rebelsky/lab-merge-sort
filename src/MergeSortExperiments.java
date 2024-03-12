import java.util.Arrays;
import java.util.Comparator;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Experiments with merge sort.
 *
 * @author YourName Here
 * @author Your NameHere
 * @author Samuel A. Rebelsky
 */
public class MergeSortExperiments {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run a bunch of experiments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    experiment01(pen);
    experiment02(pen);
    experiment03(pen);
  } // main

  // +-------------+-------------------------------------------------
  // | Comparators |
  // +-------------+

  /**
   * Compare integers.
   */
  static Comparator<Integer> compareInts = (x,y) -> x == y ? 0 : x < y ? -1 : 1;

  /**
   * Compare strings.
   */
  static Comparator<String> compareStrings = (x,y) -> x.compareTo(y);

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+

  /**
   * Sort a small array of integers.
   */
  static void experiment01(PrintWriter pen) {
    integerSortExperiment(pen, new Integer[] { 3, 5, 1, 2, 4, 3 });
  } // experiment01(PrintWriter)

  /**
   * Sort a small array of strings.
   */
  static void experiment02(PrintWriter pen) {
    stringSortExperiment(pen, new String[] { "foo", "bar", "baz", "qux", "fu" });
  } // experiment02(PrintWriter)

  /**
   * Sort a larger array of integers.
   */
  static void experiment03(PrintWriter pen) {
    int size = 100;
    Integer[] vals = new Integer[size];
    Random r = new Random();
    // Fill the array in order.
    for (int i = 0; i < size; i++) {
      vals[i] = i;
    } // for
    // Permute the array
    for (int i = 0; i < size; i++) {
      swap(vals, i, r.nextInt(size));
    } // for
    integerSortExperiment(pen, vals);
  } // experiment03(PrintWriter)

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Swap two elements in an array.
   */
  static <T> void swap(T[] vals, int i, int j) {
    T tmp = vals[i];
    vals[i] = vals[j];
    vals[j] = tmp;
  } // swap(T[], int, int)

  /**
   * Sort an array of integers.
   */
  static void integerSortExperiment(PrintWriter pen, Integer[] vals) {
    pen.print(Arrays.toString(vals));
    pen.print(" -> ");
    MergeSorter.sort(vals, compareInts);
    pen.println(Arrays.toString(vals));
  } // integerSortExperiment(PrintWriter, Integer[])   

  /**
   * Sort an array of strings.
   */
  static void stringSortExperiment(PrintWriter pen, String[] vals) {
    pen.print(Arrays.toString(vals));
    pen.print(" -> ");
    MergeSorter.sort(vals, compareStrings);
    pen.println(Arrays.toString(vals));
  } // stringSortExperiment(PrintWriter, String[])   

} // class MergeSortExperiments
