package Assignment6;

import java.io.PrintWriter;
import java.lang.Math;


public class Main {

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    double arr[] = {1.1, 2, 2.34, 5.34};
    int arrint[] = {1,2,3,4};
    int arrint2[] = {5,6,7,8,9,10,11};
    String arrstr[] = { "hello", "world", "!" };
    pen.println(contains(arr, 1, 4.2));
    pen.println(fastModExp(10, 2, 4));
    for (int i = 0; i < allPairs(arrint).length; i++) {
    pen.println("left " + allPairs(arrint)[i].getFst() + "right " + allPairs(arrint)[i].getSnd());
    }
    pen.println(concatAndReplicateAll(arrstr, 5));
    for (int i = 0; i < interleave(arrint, arrint2).length; i++) {
      pen.println(interleave(arrint, arrint2)[i]);
    }
    for (int i = 0; i < interleave(arrint2, arrint).length; i++) {
      pen.println(interleave(arrint2, arrint)[i]);
    }
  }//main

  
  /**
   * @param dubs, an array of doubles
   * @param eps, a double
   * @param d, a double
   * @return boolean, a boolean
   * @pre
   *  no additionals
   * @post
   *  returns true if there exists a double in dubs such that its difference with d is less than eps
   *  returns false otherwise
   */
  public static boolean contains(double[] dubs, double eps, double d) {
    for (double i : dubs) {
      if (Math.abs(i - d) < eps) {
        return true;
      }//if
    }//for
    return false;
  }//contains(double[], double, double)

  /**
   * @param x, an int
   * @param y, an int
   * @param m, an int
   * @return mod, an int
   * @pre
   *  no additionals
   * @post
   *  returns the integer value of x to the y exponent mod m
   */
  public static int fastModExp(int x, int y, int m) {
    int mod = 1;
    if ((y % 2) == 0) {
      for (int i = 0; i < y / 2; i++) {
        mod *= ((x * x) % m);
      }//for
    } else {
      for (int i = 0; i < y - 1; i++) {
        mod *= x;
      }//for
      mod = x * (mod % m);
    }//else
    mod = mod % m;
    return mod;
  }//fastModExp

  /**
   * @param arr, an array of integers
   * @return pairarr, an array of pairs
   * @throws IllegalArgumentException
   * @pre
   *  arr is not null
   * @post
   *  returns an array of pairs of all possible combinations of input
   *  each pair is consists two elements from arr
   */
  public static IntPair[] allPairs(int[] arr) throws IllegalArgumentException{
    if (arr == null) {
      throw new IllegalArgumentException();
    } else {
    int len = arr.length;
    int lenpair = len * len;
    IntPair[] pairarr = new IntPair[lenpair];
    int curr = 0;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        pairarr[curr] = new IntPair(arr[i], arr[j]);
        curr++;
      }//for
    }//for
    return pairarr;
    }//else
  }//allPairs(int[])
  
  /**
   * @param arr, an array of string
   * @param n, an int
   * @return str, a string
   * @pre
   *  n must be a non negative integer
   * @post
   *  str is a string that replicates n times of each of the string in arr
   */
  public static String concatAndReplicateAll(String[] arr, int n) {
    String str = "";
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < n; j++) {
        str += arr[i];
      } // for
    } // for
    return str;
  }// concatAndReplicateAll(String[], int)
  
  /**
   * @param arr1, an array of int
   * @param arr2, an array of int
   * @return arr3, an array of int
   * @pre
   *  no additionals
   * @post
   *  arr3 contains all elements in arr1 and arr2
   *  the length of arr3 is the sum of the length of arr1 and arr2
   *  the order of the elements in arr3 follows one taken from arr1 and one taken from arr2 until one array is empty
   *  the remaining elements of the longer array is placed at the end of arr3 with no order change
   */
  public static int[] interleave (int[] arr1, int[] arr2) {
    int len1 = arr1.length;
    int len2 = arr2.length;
    int len = len1 + len2;
    int[] arr3 = new int[len];
    if (len1 <= len2) {
      for (int i = 0; i < len1 * 2; i+=2) {
        arr3[i] = arr1[i/2];
        arr3[i+1] = arr2[i/2];
      }//for
      for (int i = len1; i < len2; i++) {
        arr3[len1 + i] = arr2[i];
      }//for
    } else {
        for (int i = 0; i < len2 * 2; i+=2) {
          arr3[i] = arr1[i/2];
          arr3[i+1] = arr2[i/2];
        }//for
        for (int i = len2; i < len1; i++) {
          arr3[len2 + i] = arr1[i];
        }//for
    }//else
    return arr3;
  }//interleave(int[], int[])
}//class
