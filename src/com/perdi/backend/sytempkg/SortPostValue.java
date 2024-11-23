package com.perdi.backend.sytempkg;

import java.util.ArrayList;

public class SortPostValue {
    private static int partition(ArrayList<PostValue> array, int begin, int end) {
        double pivot = array.getFirst().getValue();
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (array.get(j).getValue() <= pivot) {
                i++;

                PostValue aux = array.get(i);
                array.set(i,array.get(j));
                array.set(j,aux);
            }
        }
        PostValue aux = array.get(i+1);
        array.set(i+1,array.getLast());
        array.set(array.size()-1,aux);

        return i+1;
    }

    public static void quickSort(ArrayList<PostValue> array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            quickSort(array, begin, partitionIndex-1);
            quickSort(array, partitionIndex+1, end);
        }
    }
}
