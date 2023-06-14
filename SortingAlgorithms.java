/* This file contains implementations of sorting algorithms.
 * You are NOT allowed to modify any of the given method headers.
 */
import java.util.LinkedList;

 public class SortingAlgorithms {

    /*
     * You may define additional helper functions here if you need to.
     * Make sure the helper functions have the private access modifier, as
     * they will only be used in this class.
     */
    public Record[] recordList;

    public void insertionSort(Record[] arr, int n) {
        for (int i=1;i<n;i++)
        {
            Record temp = arr[i];
            int j = i;
            while((j>0)&&(arr[j-1].getIdNumber()>temp.getIdNumber()))
            {
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=temp;
        }

        this.recordList = arr;
    }

    public void selectionSort(Record[] arr, int n) {
        for (int i=0;i<n;i++)
        {
            int key=i;
            Record temp;
            for (int j=i;j<n;j++)
            {
                if (arr[key].getIdNumber()>arr[j].getIdNumber())
                {
                    key=j;
                }
            }
            temp=arr[key];
            arr[key]=arr[i];
            arr[i]=temp;
        }
        this.recordList = arr;
    }

    public void mergeSort(Record[] arr, int p, int r) {
        int arrayHalf = arr.length/2, leftIndex=0, rightIndex=0, mergeIndex=0;
        if((arrayHalf*2)<arr.length) arrayHalf++; //if odd

        Record[] leftSide = new Record[arrayHalf];
        Record[] rightSide = new Record[arr.length/2];

	System.arraycopy(arr,0,leftSide,0,arrayHalf);
	System.arraycopy(arr,arrayHalf,rightSide,0,arr.length/2);
        
        if(arr.length > 2) 
        {   mergeSort(leftSide,0,0);
            leftSide = this.recordList;
            mergeSort(rightSide,0,0);
            rightSide = this.recordList;
        }
        
        while(leftIndex < arrayHalf && rightIndex < arr.length/2) 
        {   if(leftSide[leftIndex].getIdNumber() < rightSide[rightIndex].getIdNumber())
            {   arr[mergeIndex] = leftSide[leftIndex];
                leftIndex++;
            } else
            {   arr[mergeIndex] = rightSide[rightIndex];
                rightIndex++;
            }
            mergeIndex++;
        }

        if(leftIndex == arrayHalf)
            System.arraycopy(rightSide, rightIndex, arr, mergeIndex, rightSide.length-rightIndex);
        if(rightIndex == arr.length/2)
            System.arraycopy(leftSide, leftIndex, arr, mergeIndex, leftSide.length-leftIndex);
        
        this.recordList = arr;
    }

    public void bubbleSort(Record[] arr) {
        Record temp = new Record("",0);
        boolean flag = true;

        for(int i=1; flag==true; i++)
        {   flag = false;
            for(int j=0; j<arr.length-i; j++)
                if(arr[j].getIdNumber() > arr[j+1].getIdNumber())
                {   temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
        }

        this.recordList = arr;
    }

}
