import java.util.Comparator;
import java.util.Arrays;

/**
 * A simple way to sort arrays using merge sort.
 *
 * @author Samuel A. Rebelsky
 */
public class MergeSorter {

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sort an array using the merge sort algorithm.
   */
  public static <T> void sort(T[] vals, Comparator<? super T> comparator) {
    mergeSort(vals, 0, vals.length, comparator);
  } // sort

  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    int l = lo;
    int r = mid;
    T[] tmp = Arrays.copyOfRange(vals, lo, hi); 
    int i = 0;
    // Invariants:
    // a. Elements [0..i) of tmp are sorted. (Trivial; empty.)
    // b. The last element of that range is less than or equal to 
    //    vals[l] and vals[r], provided l < mid / r < hi.  (Trivial; empty)
    // c. Elements [0..i) of tmp are a permutation of elements [lo..l)
    //    and [mid..r) of vals. (Trivial; all are empty)
    while ((l < mid) && (r < hi)) {
      if (comparator.compare(vals[l],vals[r]) <= 0) {
        tmp[i++] = vals[l++];
        // a holds because we added a new element at least as large
        // as the last value in the range.
        // b holds because vals[l] was <= vals[l+1] and
        // vals[l] was <= vals[r].
        // c holds because we copied one element
        ;; 
      } else {
        tmp[i++] = vals[r++];
        // The invariants continue to hold for the same reason
      }
    } // while

    while (l < mid) {
      tmp[i++] = vals[l++];
    } // while

    while (r < hi) {
      tmp[i++] = vals[r++];
    } // while

    // We've copied the values into tmp. Now we need to copy them
    // back.
    for (i = 0; i < tmp.length; i++) {
      vals[lo + i] = tmp[i];
    } // for
  } // merge

  /**
   * Sort the values in positions [lo..hi) of vals.
   */
  public static <T> void mergeSort(T[] vals, int lo, int hi, Comparator<? super T> comparator) {
    // If we have zero or one elements, we're done.
    if ((lo + 1) >= hi)
      return;
    // Otherwise
    else {
      // Pick a midpoint
      int mid = lo + (hi - lo)/2;
      // Sort both halves
      mergeSort(vals, lo, mid, comparator);
      mergeSort(vals, mid, hi, comparator);
      // And merge 'em back together
      merge(vals, lo, mid, hi, comparator);
    } // else
  } // mergeSort

} // class MergeSorter
