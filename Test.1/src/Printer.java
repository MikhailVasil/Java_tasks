import java.util.Arrays;


class MergeSort {
    public static int[] mergeSort(int[] arr) {
        // Напишите свое решение ниже

        if (arr == null) {
            return null;
        }
        if (arr.length < 2) {
            return arr;

        }
        int[] left = new int[arr.length / 2]; // Разбиваем массив на подмасиивы
        int[] right = new int[arr.length - arr.length / 2];
        System.arraycopy(arr, 0, left, 0, arr.length / 2);// Копируем подмассивы
        System.arraycopy(arr, arr.length / 2, right, 0, arr.length - arr.length / 2);
        left = mergeSort(left);// Рекурсивно уменьшаем
        right = mergeSort(right);
        return mergeArray(left, right);



    }

    public static int[] mergeArray(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aLength = a.length;
        int bLength = b.length;
        int i = 0, j = 0, k = 0;
        while (i < aLength && j < bLength) {
            if (a[i] <= b[j]) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < aLength) {
            result[k] = a[i];
            i++;
            k++;
        }
        while (j < bLength) {
            result[k] = b[j];
            j++;
            k++;
        }
        return result;

    }
}
// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        int[] a;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{5, 1, 6, 2, 3, 4};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        MergeSort answer = new MergeSort();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);
    }
}