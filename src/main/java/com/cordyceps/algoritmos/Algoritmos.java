package com.cordyceps.algoritmos;

/**
 * Hello world!
 *
 */
public class Algoritmos 
{
    private static int counter = 0;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //mergeLists();
        final int[] pearls = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        findPearlJam(pearls);
        
        final int[] pearls1 = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        findPearlJam(pearls1);
        
        final int[] pearls2 = {0, 0, 1, 0, 0, 0, 0, 0, 0, 0};
        findPearlJam(pearls2);

        final int[] pearls3 = {0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
        findPearlJam(pearls3);

        final int[] pearls4 = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        findPearlJam(pearls4);

        final int[] pearls5 = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
        findPearlJam(pearls5);

        final int[] pearls6 = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        findPearlJam(pearls6);

        final int[] pearls7 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        findPearlJam(pearls7);

        final int[] pearls8 = {0, 0, 0, 0, 0, 0, 0, 0, 1, 0};
        findPearlJam(pearls8);

        final int[] pearls9 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        findPearlJam(pearls9);
    }
    
    public static void mergeLists() {
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
    
    public static void findPearlJam(int[] pearls) {
       int position = findPearl(pearls, 0, pearls.length - 1);
       
       System.out.println("Position: " + (position + 1));
       System.out.println("Counter: " + counter);
       counter = 0;
    }

    private static int findPearl(int[] pearls, int startPosition, int finalPosition) {
        counter++;
        int arraySize = finalPosition - startPosition + 1;
        
        // This ends when we only have two pearls.
        if (arraySize == 2) {
            if (pearls[startPosition] > pearls[finalPosition]) {
                return startPosition;
            } else {
                return finalPosition;
            }
        }
 
        // Uneven Pearls
        if (arraySize % 2 != 0) 
        {   
            // Found the element at the middle ..I..
            int unEvenElementPos = startPosition + (arraySize / 2) ;
            
            // Check if the midle elements is the false pearl 
            if (pearls[unEvenElementPos] > pearls[startPosition]) {
                return unEvenElementPos;
            } else {
                boolean pesoMayor = pesarPerlas(startPosition + (arraySize / 2), pearls);
                
                if (pesoMayor) {
                    return findPearl(pearls, startPosition, startPosition + arraySize / 2 - 1);
                } else {
                    return findPearl(pearls, startPosition + (arraySize / 2) + 1, finalPosition);
                }
            }
        } 
        // Even Pearls
        else {
            boolean pesoMayor = pesarPerlas(startPosition + (arraySize / 2), pearls);

            if (pesoMayor) {
                return findPearl(pearls, startPosition, startPosition + arraySize / 2 - 1);
            } else {
                return findPearl(pearls, startPosition + (arraySize / 2), finalPosition);
            }
        }        
    }

    private static boolean pesarPerlas(int arraySize, int[] pearls) {
        boolean pesoMayor = false;
        for (int i = 0; i < arraySize; i++) {
            if (pearls[i] == 1) {
                pesoMayor = true;
            }
        }
        return pesoMayor;
    }
}
