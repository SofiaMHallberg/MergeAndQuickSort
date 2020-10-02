import java.util.Random;

public class CSQuickSort implements IntSorter {
    private InsertionSorter insertionSorter=new InsertionSorter();
    @Override
    public void sort(int[] inputArray) {
      //  ArrayUtil.shuffle(inputArray);
        int low=0;
        int high=inputArray.length-1;
        quickSort(inputArray,low, high);
    }

    private void quickSort(int[] inputArray, int low, int high) {
        if(high<=low)
            return;

//        if((high-low)<40) {
//            CSInsertionSorter.sort(inputArray, low, high);
//        }

//        Random randomGenerator = new Random();
//        int r = low + randomGenerator.nextInt(high-low);
        int mid=low+(high-low)/2;
        int medianArray[]={inputArray[low], inputArray[mid], inputArray[high]};
        insertionSorter.sort(medianArray);
        //int median=medianArray[1];

        int medianIndex;
        if(medianArray[0]<medianArray[1] && medianArray[0]<medianArray[2])
            medianIndex=0;
        else if (medianArray[1]<medianArray[0] && medianArray[1]<medianArray[2])
            medianIndex=1;
        else
            medianIndex=2;

        int part=inputArray[medianIndex];
        int i=low+1;
        int j=high+1;

        while(true) {
            while (inputArray[i] < part && i < high) {
                i++;
            }
            j--;
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
        inputArray[j] = part;
        inputArray[low] = aux;
        quickSort(inputArray, low, j-1);
        quickSort(inputArray, j+1, high);
    }
}
