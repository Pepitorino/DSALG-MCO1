/* This file contains implementations of sorting algorithms.
 * You are NOT allowed to modify any of the given method headers.
 */

public class SortingAlgorithms {

    /*
     * You may define additional helper functions here if you need to.
     * Make sure the helper functions have the private access modifier, as
     * they will only be used in this class.
     */

    public void insertionSort(Record[] arr, int n) {
        // TODO: Implement this sorting algorithm here.
	for (int i=1;i<n;i++)
	{
		Record temp = arr[i];
		int j = i;
		while((j>0)&&(array[j-1].getIdNumber>temp.getIdNumber))
		{
			array[j]=array[j-1];
			j--;
		}
		array[j]=temp;
	}
    }

    public void selectionSort(Record[] arr, int n) {
        // TODO: Implement this sorting algorithm here.
	for (int i=0;i<n;i++)
	{
		int key=i;
		Record temp;
		for (int j=i;j<n;j++)
		{
			if (arr[key].getIdNumber<arr[j].getIdNumber)
			{
				key=j;
			}
		}
		temp=arr[key];
		arr[key]=arr[i];
		arr[i]=temp;
	}
    }

    public void mergeSort(Record[] arr, int p, int r) {
        // TODO: Implement this sorting algorithm here.

    }

    /*
     * Define AT LEAST ONE more sorting algorithm here, apart from the
     * ones given above. Make sure that the method accepts an array of
     * records
     */

}
