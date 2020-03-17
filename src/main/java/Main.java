import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static Integer[] getArray(){
        Integer[] array = new Integer[10];
        Random random = new Random();
        for (int i = 0; i< array.length; i++) {
            array[i] = random.nextInt(5);
        }
        return array;
    }

    public static void main(String[] args){
        Integer[] a = getArray();
        System.out.println(Arrays.toString(a) + " initial array");
        mergeSort(a);
        System.out.println(Arrays.toString(a) + " sorted array");
        System.out.println(Arrays.toString(whithOutDuplicates((Integer[]) mergeSort(a))) + " final array");
    }

    public static Comparable[] mergeSort(Comparable[] list){
        if (list.length <= 1){
            return list;
        }

        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, list);
        return list;
    }

    private static void merge(Comparable[] first, Comparable[] second, Comparable[] result){
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;

        while (iFirst < first.length && iSecond < second.length){
            if (first[iFirst].compareTo(second[iSecond]) < 0){
                result[iMerged] = first[iFirst];
                iFirst++;
            }else{
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }

    public static Integer[] whithOutDuplicates(Integer[] array){
        int k = 0;
        int length = array.length;
        for(int i = 0; i < length-1; i++){
            if(array[i] == array[i+1]){
                array = (Integer[]) ArrayUtils.remove(array, i);
                length--;
                i--;
                k++;
            }
        }
        System.out.println(k + " = k");
        return array ;
    }
}
