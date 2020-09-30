public class CSQuickSort implements IntSorter {
    @Override
    public void sort(int[] inputArray) {
        //ArrayUtil.shuffle(inputArray);
        int low=0;
        int high=inputArray.length-1;
        quickSort(inputArray,low, high);
    }

    private void quickSort(int[] inputArray, int low, int high) {
        if(high<=low)
            return;

//        if((high-low)<1) { // 1,2 and 3 generated approximately the same execution times
//            CSInsertionSorter.sort(inputArray, low, high);
//        }

        int part=inputArray[low];
        int i=low+1;
        int j=high+1;

        while(true) {
            while (inputArray[i] < part && i < high) {
                i++;
            }
            j--;
            while (inputArray[j] > part) { // 1 > 1 --> bryt
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

        int aux = inputArray[j]; // j=1
        inputArray[j] = part;
        inputArray[low] = aux;
        quickSort(inputArray, low, j-1);
        quickSort(inputArray, j+1, high);
    }

    /*public static void main(String[] args) {
        IntSorter testQuickSort=new CSQuickSort();
        int[] testArray1={5,3,6,4};
        testQuickSort.sort(testArray1);
        for(int i=0; i<testArray1.length; i++)
            System.out.print(testArray1[i]+" ");
    }*/
}
