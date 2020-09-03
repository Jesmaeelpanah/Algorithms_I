/**
 * 
 */
import java.awt.List;
import java.util.*;

/**
 * @author jen
 *
 */
public class Search {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = {-3, -2, -1, 5, 6, 8, -10, -20};
		//System.out.println(findBitonicPoint(arr));
		//System.out.println(searchBiotonic(arr, -20, 5));
		System.out.println(searchBiotonic(arr, -20));
		//ThreeSum();
	}
	
	public static int searchBiotonicDsc(int arr[], int key, int left, int right) {
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (key == arr[mid])
				return mid;
			if (key > arr[mid])
				right = mid - 1;
			else
				left = mid + 1;		
		}
		return -1;
	}
	
	public static int searchBiotonicAsc(int arr[], int key, int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (key == arr[mid])
				return mid;
			if (key < arr[mid])
				right = mid - 1;
			else
				left = mid + 1;	
		}
		return -1;
	}
	
	public static int searchBiotonic(int arr[], int key, int index) {
		
		if (key > arr[index])
			return -1;
		else if (key == arr[index])
			return index;
		else
		{
			int temp = searchBiotonicAsc(arr, key, 0, index - 1);
			if (temp != -1)
				return temp;
			return searchBiotonicDsc(arr, key, index + 1, arr.length - 1);
		}
	}
	
	// Needs some work
	public static int searchBiotonic(int arr[], int key) {
		
		int mid, left = 0, right = arr.length - 1;

		mid = (left + right) / 2;
		if(key == arr[mid])
			return mid;
		
		if(arr[mid] >= arr[mid - 1] && arr[mid] <= arr[mid + 1]) {
			if(key < arr[mid])
				right = mid;
			else
				left = mid;
			while(left <= right) {
				mid = (left + right) / 2;
				if(key == arr[mid])
					return mid;
				if(key > arr[mid])
					left = mid;
				else
					right = mid;
			}
		}
		else {
			if(key > arr[mid])
				right = mid;
			else
				left = mid;
			
			while(left <= right) {
				mid = (left + right) / 2;
				if(key == arr[mid])
					return mid;
				if(key < arr[mid])
					left = mid;
				else
					right = mid;
			}
		}
		return -1;
	}
	
	public static int findBitonicPoint(int arr[]) {
		
		int mid, left = 0, right = arr.length - 1;

		while(left <= right) {
			mid = (left + right) / 2;
			if(arr[mid] >= arr[mid - 1] && arr[mid] <= arr[mid + 1])
				left = mid + 1;
			else if(arr[mid] <= arr[mid - 1] && arr[mid] >= arr[mid + 1])
				right = mid - 1;
			else
				return mid;
		}
		return -1;
	}

	public static void ThreeSum() {
		int[] arr = {-3, -2, -1, 8, 5, 0, -10, -20, 2, 10};
		
		Arrays.sort(arr);
		
		Hashtable<String, Boolean> htSolution = new Hashtable<String, Boolean>();
		
		for(int i = 0; i < arr.length - 2; i++) {
			int c = -arr[i];
			int low = i + 1;
			int high = arr.length - 1;
			
			while(low < high) {
				
				while(low + 1 < high && arr[low] == arr[low + 1]) low++;
				while(high - 1 < low && arr[high] == arr[high - 1]) high--;
				
				int a = arr[low];
				int b = arr[high];
				
				if(a + b == c) {
					String key = Integer.toString(-c) + '@' + Integer.toString(a) + '@' + Integer.toString(b);
					if(!htSolution.containsKey(key)) {
						htSolution.put(key, true);
					}
					low++;
					high--;
				}
				else if (a + b > c) {
					high--;
				}
				else
					low++;
			}
		}
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("\n" + htSolution);
	}
}
