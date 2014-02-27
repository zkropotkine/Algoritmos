package com.cordyceps.algoritmos;

/**
 * Hello world!
 *
 */
public class Algoritmos 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        onlyExistElementsOnB();
        
    }
    
    public static void onlyExistElementsOnB() {
       final int[] listA = {24, 43, 65, 93, 102, 130, 131, 142, 205, 208, 221, 235};
       final int[] listB = {1, 4, 26, 35, 47, 50, 96, 110, 115, 135, 146, 147, 190, 206, 219};
       
       int numberElements = listA.length + listB.length;
       int[] resultList = new int[numberElements];
       
       int indexA = 0;
       int indexB = 0;
       
       for(int i = 0; i < numberElements; i++) {
           final boolean elementsExistOnBothList = indexB < listB.length && indexA < listA.length;
           final boolean onlyExistElementsOnA = indexB == listB.length && indexA < listA.length;
           final boolean onlyExistElementsOnB = indexA == listA.length && indexB < listB.length;
           
          if ( (elementsExistOnBothList && listA[indexA] < listB[indexB]) || onlyExistElementsOnA) {
              resultList[i] = listA[indexA++];
              System.out.println(resultList[i]);
          } else if ((elementsExistOnBothList && listA[indexA] > listB[indexB]) || onlyExistElementsOnB) {
              resultList[i] = listB[indexB++];
              System.out.println(resultList[i]);
          }
       }
       
       //for (Integer currentElement : resultList) {
       //    System.out.println(currentElement);
       //}
    }
}
