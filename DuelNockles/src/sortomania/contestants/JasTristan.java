//cant use multi thread sorts

package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class JasTristan extends Contestant {

	public Color getColor() {
		return new Color(102,194,255);
	}

	public String getSpriteName() {
		return CHUN_LI;
	}

	public double sortAndGetMedian(int[] random) {
		int length = random.length;
		int max = getMax(random, 0);
		for (int exp = 1; max/exp > 0; exp *= 10) {
			countSort(random, length, exp);
		}
		if(length % 2 == 1) {
			return random[(length-1)/2];
		}
		else {
			return ((random[length/2] + random[(length/2)-1]) / 2);
		}
	}
	
	public int getMax(int arr[], int max)
    {
        max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
	
	public void countSort(int arr[], int n, int exp)
    {
		int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        for (i = 0; i < n; i++) {
        	count[ (arr[i]/exp)%10 ]++;
        }
        
        for (i = 1; i < 10; i++) {
        	count[i] += count[i - 1];
        }
        
        for (i = n - 1; i >= 0; i--){
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
 
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		QuicksortString(strings, 0, strings.length - 1);
		for(int i = 0; i < strings.length; i++){
			if(strings[i].equals(toFind)){
				return i;
			}
		 }
		 return -1;
	}

	 public int partition(String[] stringArray, int idx1, int idx2) {
	        String pivotValue = stringArray[idx1];
	        while (idx1 < idx2) {
	           String value1;
	           String value2;
	           while ((value1 = stringArray[idx1]).compareTo( pivotValue ) < 0) {
	               idx1 = idx1 + 1;
	           }
	           while ((value2 = stringArray[idx2]).compareTo( pivotValue ) > 0) {
	               idx2 = idx2 - 1;
	           }
	           stringArray[idx1] = value2;
	           stringArray[idx2] = value1;
	        }
	        return idx1;
	    }
	 
	 public void QuicksortString(String[] stringArray, int idx1, int idx2) {
	        if (idx1 >= idx2) {
	            return;
	        }
	        int pivotIndex = partition(stringArray, idx1, idx2);
	        QuicksortString(stringArray, idx1, pivotIndex);
	        QuicksortString(stringArray, pivotIndex+1, idx2);
	     }
	    
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		int n = mostlySorted.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(mostlySorted, n, i);
 
        for (int i=n-1; i>=0; i--)
        {
            int temp = mostlySorted[0];
            mostlySorted[0] = mostlySorted[i];
            mostlySorted[i] = temp;
 
            heapify(mostlySorted, i, 0);
        }
        if(n % 2 == 1) {
			return mostlySorted[(n-1)/2];
		}
		else {
			return ((mostlySorted[n/2] + mostlySorted[(n/2)-1]) / 2);
		}
	}

	public void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
 
        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapify(arr, n, largest);
        }
    }

	public double sortMultiDim(int[][] grid) {
		int length = grid.length;
		int[] arr = new int[length];
		for(int i = 0; i < length; i ++) {
			arr[i] = (int) sortAndGetMedian(grid[i]);
		}
		return sortAndGetMedian(arr);
	}

	/*
	 * In task 5, sort the array of Comparables, then return the index of the specified Comparable. The returned index must be the index after sorting.
	 */
	
	public void quickSort(Comparable[] arr, int lowerIndex, int higherIndex) {
		
		if (arr == null || arr.length == 0) {
			return;
		}

		int i = lowerIndex;
		int j = higherIndex;
		
		Comparable pivot = arr[lowerIndex+(higherIndex-lowerIndex)/2];
		
		while (i <= j) {
			while (arr[i].compareTo(pivot) < 0) {
				i++;
			}
			while (arr[j].compareTo(pivot) > 0) {
				j--;
			}
			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		if (lowerIndex < j)
			quickSort(arr, lowerIndex, j);
		if (i < higherIndex)
			quickSort(arr, i, higherIndex);
	}
	
	public void swap(Comparable[] arr, int i, int j) {
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		int length = arr.length - 1;
		quickSort(arr, 0, length);
		return binarySearch(arr, 0, length, toFind);
	}

	public int binarySearch(Comparable[] arr, int lower, int upper, Comparable target) {
		if(upper >= lower) {
			int mid = lower + (upper - lower)/2;
			
			if(arr[mid].equals(target)) {
				return mid;
			}
			if(arr[mid].compareTo(target) > 0) {
				return binarySearch(arr, lower, mid - 1, target);
			}
			else return binarySearch(arr, mid + 1, upper, target);
		}
		return -1;
	}

}
