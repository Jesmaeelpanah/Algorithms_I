package QuickSort;
import java.util.Random;

// 1.39 N Lg N 
// best N Lg N (even if sorted already) - Worst-case N^2
public class QuickSort {

	private static final int CUTOFF = 10;
	
	public static void main(String[] args) {



	}
	
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo + CUTOFF - 1) {
			//Insertion.sort(a, lo, hi);
			return;
		}
		
		int m = medianOf3(a, lo, (lo + hi)/2, hi);
		exch(a, lo, m);
		
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	// Reduces Running time from linearithmic to linear
	private static void threewaysort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int lt = lo, gt = hi;
		Comparable v = a[lo];
		int i = lo;
		while(i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0)
				exch(a, lt++, i++);
			//cmp = a[i].compareTo(a[gt]);	// my suggestion is to inverse i and gt if i is bigger than gt
			else if (cmp > 0)
				exch(a, i, gt--);
			else
				i++;
		}
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}
	
	private static int medianOf3(Comparable[] a, int lo, int i, int hi) {
		return 0;
	}

	public static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		while(true) {
			while (less(a[++i], a[lo]) < 0)
				if(i == hi) break;
			
			while (less(a[lo], a[--j]) > 0)
				if(j == lo) break;
		
			if(i >= j) break;
			exch(a, i, j);		
		}
		
		exch(a, lo, j);
		return j;
	}
		
	public static int less(Comparable v, Comparable w) {
		return v.compareTo(w);
	}
	
	public static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	// Quick Select takes linear time on average and worst-case of N^2 
	public static Comparable select(Comparable[] a, int k) {
		//StdRandom.shuffle(a);
		
		int lo = 0, hi = a.length - 1;
		while(hi > lo) {
			int j = partition(a, lo, hi);
			if (j < k) 		lo = j + 1;
			else if (j > k) hi = j - 1;
			else			return a[k];
		}
		return a[k];
	}
}
