package RotationOfArray;

import java.util.Scanner;

/**
 * Created by pku141 on 8/24/2017.
 */
public class RotationOfArray {
    public static void main(String[] args) {

        int inputarray[] = {1,2,3,4,5};
        int d = 2;
        for(int i : inputarray)
            System.out.println(i);
        Rotate rotate = new RotateImpl();
       inputarray= rotate.rotate(inputarray,d);
        for(int i : inputarray)
            System.out.println(i);


    }
}
