package integer_sorting;


public class App 
{
	private int[] arr;
	private int[] tempMergeArr;
	private int length;
	
    public static void main( String[] args )
    {
        int[] exampleArr = {6, 2, 52, 25, 11, 50}; //can be any array or there can be listen for input in place
        App sorting = new App();
        sorting.sort(exampleArr);
        for(int i:exampleArr)
        {
        	System.out.println(i);
        }
    }
    
    public void sort(int inputArr[])
    {
    	arr = inputArr;
    	length = inputArr.length;
    	tempMergeArr = new int[length];
    	doMergeSort(0, length - 1);
    }
    
    /* A merge sort splitting the array in two, sorting and then merging*/
    private void doMergeSort(int lowerIndex, int higherIndex)
    {
    	if(lowerIndex < higherIndex)
    	{
    		int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
    		doMergeSort(lowerIndex, middle);
    		doMergeSort(middle + 1, higherIndex);
    		mergeParts(lowerIndex, middle, higherIndex);
    	}
    }
    
    private void mergeParts(int lowerIndex, int middle, int higherIndex)
    {
    	for(int i = lowerIndex; i <= higherIndex; i++)
    	{
    		tempMergeArr[i] = arr[i];
    	}
    	int i = lowerIndex;
    	int j = middle + 1;
    	int k = lowerIndex;
    	while(i <= middle && j <= higherIndex)
    	{
    		if(tempMergeArr[i] <= tempMergeArr[j])
    		{
    			arr[k] = tempMergeArr[i];
    			i++;
    		}
    		else
    		{
    			arr[k] = tempMergeArr[j];
    			j++;
    		}
    		k++;
    	}
    	while (i <= middle)
    	{
    		arr[k] = tempMergeArr[i];
    		k++;
    		i++;
    	}
    }
}
