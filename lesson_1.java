//         Первый семинар.
// 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
// 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
// 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

// Пункты реализовать в методе main
// *Пункты реализовать в разных методах
// int i = new Random().nextInt(k); //это кидалка случайных чисел!)

import java.util.Random;
import java.util.Arrays;

public class lesson_1 {
    public static void main(String[] args) {
        
        Random random = new Random();
        int i = random.nextInt(2001);     
        System.out.println(i);
        String bin_i = Integer.toBinaryString(i);
        int n = bin_i.length();
        System.out.println(n);
        
        int max = Short.MAX_VALUE;
        
        int[] m1 = new int[max/n];
        int m1_count = 0;
        for (int j = 2; j <= max; j++) {
            if (j%n==0){
                m1[m1_count] = j;
                m1_count+=1;
            }
        }
        System.out.println(Arrays.toString(m1));
        //System.out.println(m1.length);
        
        int min = Short.MIN_VALUE;
        int len_m2 = Math.abs(min/n);
        int[] m2 = new int[len_m2];
        int m2_count = 0;
        for (int h = min; h <0; h++) {
            if (h%n==0){
                m2[m2_count] = h;
                m2_count+=1;
            }
        }
        System.out.println(Arrays.toString(m2));
        //System.out.println(m2.length);
    }
    // public static int random_number() {
    //     Random random = new Random();
    //     int i = random.nextInt(2001); 
    //     return i;
        
    // }
    
}
