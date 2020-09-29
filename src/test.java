public class test implements IntSorter{
    public void sort(int[] array) { // det är denna metod som anropas utifrån
        int size=array.length;
        int[] extraArray=new int[size];
        divide(array, extraArray, 0, size-1);
    }

    private static void divide(int[] array, int[] extraArray, int lo, int hi) {
        if(hi<=lo)  // Kontrollera att den delarray som ska sorteras består av mer än ett element
            return;

        int mid=lo+(hi-lo)/2;
        divide(array, extraArray, lo, mid); // Fortsätt dela upp den vänstra delarrayen
        divide(array, extraArray, mid+1, hi); // Fortsätt dela upp den högra delarrayen
        conquer(array, extraArray, lo, mid, hi); // Sortera delarrayerna
    }

    private static void conquer (int[] array, int[] extraArray, int lo, int mid, int hi) {
        for (int k=0; k<array.length; k++)
            extraArray[k]=array[k];

        int i=0;
        int j=mid+1;
        for (int k=lo; k<=hi; k++) {
            if (i>mid) { // om i>mid så finns det bara kvar element i den övre halvan av delarrayen
                array[k] = extraArray[j];
                j++;
            }
            else if (j>hi) { // om j>hi så finns det bara kvar element i den nedre halvan
                array[k] = extraArray[i];
                i++;
            }
            else if (extraArray[i]<=extraArray[j]) {
                array[k]=extraArray[i];
                i++;
            }
            else {
                array[k]=extraArray[j];
                j++;
            }
        }
    }

//    public static void main(String[] args) {
//        int[] testArray1={6,7,8,3,5,1,4,6,8,2,90};
//        sort(testArray1);
//
//        for(int i=0; i<11; i++)
//            System.out.println(testArray1[i]);
//
//    }
}
