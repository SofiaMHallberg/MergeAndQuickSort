public class CSInsertionSorter {
    public static void sort(int[] a, int low, int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && a[j] < a[j-1]; j--) {
                int x = a[j];
                a[j] = a[j-1];
                a[j-1] = x;
            }
        }
    }
}
