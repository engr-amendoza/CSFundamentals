package mdza.cs.sorting;

import java.util.Comparator;

public abstract class Sort {
    
    // is v < w ?
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    public boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }

    public void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    // print array to standard output
    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
        // is the array a[] sorted?
    public boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
        
    // is the array sorted from a[lo] to a[hi]
    public boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array a[] sorted?
    public boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    public boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i-1])) return false;
        return true;
    }
    
        // is the array h-sorted?
    public boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (less(a[i], a[i-h])) return false;
        return true;
    }
    
    public boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

}
