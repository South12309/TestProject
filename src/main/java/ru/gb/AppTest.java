package ru.gb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AppTest {

    public int[] getArrayFrom4(int[] array) {

        int j=0;
        for (int i = array.length-1; i >=0; i--) {
                if (array[i]==4) {
                    j=i+1;
                    return Arrays.copyOfRange(array, j, array.length);
                }
        }

        throw new RuntimeException();

    }

    public boolean chekArrayInclude1or4(int[] array) {
        boolean is1=false;
        boolean is4=false;

        for (int i : array) {
           if (i==1)
               is1 = true;
           if(i==4)
               is4=true;
        }

        return is1 && is4;
    }
}
