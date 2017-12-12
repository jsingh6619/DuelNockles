//cant use multi thread sorts

package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class JasTristan extends Contestant {

	private int max;

	public Color getColor() {
		return new Color(102,194,255);
	}

	public String getSpriteName() {
		return CHUN_LI;
	}

	public double sortAndGetMedian(int[] random) {
		int length = random.length;
		max = getMax(random);
		for (int exp = 1; max/exp > 0; exp *= 10) {
			countSort(random, length, exp);
		}
		if(length % 2 == 1) {
			return random[(length-1)/2];
		}
		else {
			return random[length/2] + random[(length/2)-1] / 2;
		}
	}
	
	public int getMax(int arr[])
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
		// TODO Auto-generated method stub
		return 0;
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
			return (mostlySorted[n/2] + mostlySorted[(n/2)-1]) / 2;
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
		// TODO Auto-generated method stub
		return 0;
	}

	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		
	}

}
