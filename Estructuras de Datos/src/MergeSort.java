public class MergeSort {    
    public void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;

            int[] L = new int[mid];
            int[] R = new int[arr.length - mid];

            
            for (int i = 0; i < mid; i++) {
                L[i] = arr[i];
            }

            for (int i = mid; i < arr.length; i++) {
                R[i - mid] = arr[i];
            }

            mergeSort(L);
            mergeSort(R);

            merge(arr, L, R);
        }
    }

    public void merge(int[] arr, int[] L, int[] R) {
        int i = 0, j = 0, k = 0;

        while (i < L.length && j < R.length) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < L.length) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < R.length) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
