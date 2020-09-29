public class CSQuickSort implements IntSorter {
    @Override
    public void sort(int[] inputArray) {
        ArrayUtil.shuffle(inputArray);

        int low=0;
        int high=inputArray.length;
    }

    private void quickSort(int[] inputArray, int low, int high) {
        if(high<=low)
            return;

        int part=inputArray[low];
        int i=low;
        int j=high+1;



        while(true) {

            while (inputArray[i] < part && i < high) {
                i++;
            }

            while (inputArray[j] > part) {
                j--;
            }

            if (i >= j)
                break;
            else {
                int aux = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = aux;
            }
        }

            int aux = inputArray[j];
            inputArray[j] = inputArray[low];
            inputArray[low] = aux;

        quickSort(inputArray, low, j-1);
        quickSort(inputArray, j+1, high);

    }

    public static void main(String[] args) {
        IntSorter testQuickSort=new CSQuickSort();
        int[] testArray1={5,3,6,4};
        testQuickSort.sort(testArray1);
        for(int i=0; i<testArray1.length; i++)
            System.out.print(testArray1[i]+" ");
    }
}
