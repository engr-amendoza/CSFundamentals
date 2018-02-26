package mdza.cs.sorting;

import java.util.Arrays;
import java.util.Collections;

public class Quick extends Sort{

    // This class should not be instantiated.
    private Quick() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public void sort(Comparable[] a) {
        Collections.shuffle(Arrays.asList(a));
        //StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    // quicksort the subarray from a[lo] to a[hi]
/*    private void sort(Comparable[] a, int left, int right) { 
        if (left >= right) return;
        int middle = partition(a, left, right);
        sort(a, left, middle-1);
        sort(a, middle+1, right);
        assert isSorted(a, left, right);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private int partition(Comparable[] a, int start, int end) {
        int left = start;
        int right = end + 1;
        Comparable pivot = a[start];
        while (true) { 

            // find item on lo to swap
            while (less(a[++left], pivot))
                if (left == end) break;

            // find item on hi to swap
            while (less(pivot, a[--right]))
                if (right == start) break;      

            // check if pointers cross
            if (left >= right) break;

            exch(a, left, right);
        }

        // put partitioning item v at a[j]
        exch(a, start, right);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return right;
    }
*/
    
    public void sort(Comparable[] array, int left, int right) {
	if (left >= right)
		return;
	
	int middle = partition(array, left, right);
	sort(array, left, middle-1);
	sort(array, middle, right);
        }

    public int partition(Comparable[] array, int left, int right) {
        int pivot = (int) array[(left + right) / 2];

        while (left <= right) {
            while (less(array[left], pivot)) 
                left++;

            while (less(pivot, array[right]))
                right--;

            if (left <= right) {
                exch(array, left, right);
                left++;
                right--; 
                        }
            }
        return left;
    }
}