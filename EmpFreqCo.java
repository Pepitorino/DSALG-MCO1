/* This file contains implementations of sorting algorithms.
 * You are NOT allowed to modify any of the given method headers.
 */

 public class EmpFreqCo {

    /*
     * You may define additional helper functions here if you need to.
     * Make sure the helper functions have the private access modifier, as
     * they will only be used in this class.
     */
    public Record[] recordList;

    public long insertionSort(Record[] arr, int n) {
        long k=0;
        for (int i=1;i<n;i++)
        {
            Record temp = arr[i];
            k++;
            int j = i;
            k++;
            while((j>0)&&(arr[j-1].getIdNumber()>temp.getIdNumber()))
            {
                k++;
                arr[j]=arr[j-1];
                k++;
                j--;
                k++;
            }
            k++;
            arr[j]=temp;
            k++;
        }

        this.recordList = arr;
        return k++;
    }

    public long selectionSort(Record[] arr, int n) {
        long k=0;
        for (int i=0;i<n-1;i++)
        {
            k++;
            int key=i;
            k++;
            Record temp;
            k++;
            for (int j=i;j<n;j++)
            {
                k++;
                if (arr[key].getIdNumber()>arr[j].getIdNumber())
                {
                    key=j;
                    k++;
                }
                k++;
            }
            temp=arr[key];
            k++;
            arr[key]=arr[i];
            k++;
            arr[i]=temp;
            k++;
        }
        k++;
        this.recordList = arr;
        return k++;
    }

    public long mergeSort(Record[] arr, int p, int r) {
        long i=0;
        int arrayHalf = arr.length/2, leftIndex=0, rightIndex=0, mergeIndex=0;
        i++;
        if((arrayHalf*2)<arr.length) arrayHalf++; //if odd
        i++;

        Record[] leftSide = new Record[arrayHalf];
        i++;
        Record[] rightSide = new Record[arr.length/2];
        i++;

	    System.arraycopy(arr,0,leftSide,0,arrayHalf);
        i++;
	    System.arraycopy(arr,arrayHalf,rightSide,0,arr.length/2);
        i++;
        
        if(arr.length > 2) 
        {   i+=mergeSort(leftSide,0,0);
            leftSide = this.recordList;
            i++;
            i+=mergeSort(rightSide,0,0);
            rightSide = this.recordList;
            i++;
        }
        i++;
        
        while(leftIndex < arrayHalf && rightIndex < arr.length/2) 
        {   if(leftSide[leftIndex].getIdNumber() < rightSide[rightIndex].getIdNumber())
            {   arr[mergeIndex] = leftSide[leftIndex];
                i++;
                leftIndex++;
                i++;
            } else
            {   arr[mergeIndex] = rightSide[rightIndex];
                i++;
                rightIndex++;
                i++;
            }
            i++;
            mergeIndex++;
            i++;
        }

        if(leftIndex == arrayHalf)
        {
            System.arraycopy(rightSide, rightIndex, arr, mergeIndex, rightSide.length-rightIndex);
            i++;
        }
        i++;

        if(rightIndex == arr.length/2)
        {
            System.arraycopy(leftSide, leftIndex, arr, mergeIndex, leftSide.length-leftIndex);
            i++;
        }
        i++;
        this.recordList = arr;
        return i++;
    }

    public long bubbleSort(Record[] arr) {
        long k=0;
        Record temp = new Record("",0);
        k++;
        boolean flag = true;
        k++;

        for(int i=1; flag==true; i++)
        {   
            k++;
            flag = false;
            k++;
            for(int j=0; j<arr.length-i; j++)
            {
                k++;
                if(arr[j].getIdNumber() > arr[j+1].getIdNumber())
                {   
                    temp = arr[j];
                    k++;
                    arr[j] = arr[j+1];
                    k++;
                    arr[j+1] = temp;
                    k++;
                    flag = true;
                    k++;
                }
                k++;
            }
            k++;
        }
        k++;

        this.recordList = arr;
        return k++;
    }

}
