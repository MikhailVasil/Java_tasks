import java.util.Arrays;

class HeapSort {
    public static void buildTree(int[] arr, int sortLength) {
        //int n = arr.length;
        for (int i = sortLength/2-1; i >=0 ; i--) {
            heapify (arr,sortLength,i);
        }
        // Введите свое решение ниже

    }
    private static void heapify(int[]arr, int n, int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n&&arr[l]>arr[largest]){
            largest = l;
        }
        if(r<n&&arr[r]>arr[largest]){
            largest = r;
        }

        if(largest!=i){
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(arr,n,largest);
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
// Введите свое решение ниже
      //  int n = sortArray.length;

        buildTree(sortArray, sortLength);

        for (int i = sortLength-1; i >=0 ; i--) {
            int tmp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = tmp;
            heapify(sortArray, i, 0);
        }
    }
}

// Не удаляйте и не меняйте метод Main!
public class Test {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}