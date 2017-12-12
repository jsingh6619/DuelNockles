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
		// TODO Auto-generated method stub
		return 0;
	}

	public double sortMultiDim(int[][] grid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

}
