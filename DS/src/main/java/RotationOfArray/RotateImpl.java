package RotationOfArray;

/**
 * Created by pku141 on 8/24/2017.
 */
public class RotateImpl  implements Rotate{

    public int [] rotate(int[] inputArray, int d) {
        //
        int [] temp = new int[d];
        int inputArrayLastIndex = inputArray .length - 1;
        int diff = d + 1;
        int startingIndex =0;
        for (int i = 0 ; i< d ; i++){
            inputArray[i] = temp[i];
        }

        for (int i = diff ; i < inputArrayLastIndex ;i++ ){
            inputArray[i-diff] = inputArray[i];
        }

        for (int i = inputArrayLastIndex - d ;i < inputArrayLastIndex ;i++){
            inputArray[i] = temp[startingIndex++];
        }

        return inputArray;

    }
}
