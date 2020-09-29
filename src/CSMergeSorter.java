public class CSMergeSorter implements IntSorter {
    @Override
    public void sort(int[] inputArray) {
        int size=inputArray.length;
        int[] arrayCopy=new int[size];

        divide(inputArray, arrayCopy, 0, size-1);
    }

    private void divide(int[] inputArray, int[] arrayCopy, int low, int high) {
        if(high<=low)
            return;

        int mid=low+(high-low)/2;

        divide(inputArray, arrayCopy, low, mid);
        divide(inputArray, arrayCopy, mid+1, high);
        conquer(inputArray, arrayCopy, low, mid, high);
    }

    private void conquer(int[] inputArray, int[] arrayCopy, int low, int mid, int high) {
        for (int i=low; i<=high; i++) {
            arrayCopy[i]=inputArray[i];
        }
        int i=low;
        int j=mid+1;
        for(int k=low; k<=high; k++) {
           if(i>mid) {
               inputArray[k] = arrayCopy[j++];
           }
           else if(j>high) {
               inputArray[k]=arrayCopy[i++];
           }
           else if(arrayCopy[i]<inputArray[j]) {
               inputArray[k]=arrayCopy[i++];
           }
           else if (arrayCopy[i]>=inputArray[j]){
               inputArray[k]=arrayCopy[j++];
           }
        }
    }

}
